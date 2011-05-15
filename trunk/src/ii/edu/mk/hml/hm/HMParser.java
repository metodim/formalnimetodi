
package ii.edu.mk.hml.hm;

import ii.edu.mk.hml.logic.HMLogic;
import ii.edu.mk.hml.logic.Logic;
import ii.edu.mk.hml.utils.BooleanOperation;
import ii.edu.mk.hml.utils.Node;
import ii.edu.mk.hml.exceptions.ParseException;

import java.util.ArrayList;
import java.util.Stack;


public class HMParser {
  
  private Logic logic;
  private BooleanOperation finalResult = new BooleanOperation(true, 'R');
  private Stack<BooleanOperation> booleanStack = new Stack<BooleanOperation>();
  
  private String previousToken = "";
  private String actionName = "";
  private boolean literalOnTop = false;
  private Stack<String> stack = new Stack<String>();
  private ArrayList<String> grammar = new ArrayList<String>();
  private ArrayList<String> terminals = new ArrayList<String>();
  private ArrayList<String> nonterminals = new ArrayList<String>();
  private int parsingTable[][];
  
  
  //Constants
  private String[] grammarRules = {
      "$ˆ$ˆ$ˆˆˆ",                 //0
      "Term Expression",          //1
      "AND Term Expression",      //2
      "OR Term Expression",       //3
      "UW Term Expression",       //4
      "US Term Expression",       //5
      "",                         //6
      "NOT Term",                 //7
      "[ Actions ] Term",         //8
      "< Actions > Term",         //9
      "TT",                       //10
      "FF",                       //11
      "( HML )",                  //12
      "Action",                   //13
      "{ Action ActionsList }",   //14
      ", Action ActionsList",     //15
      "",                         //16
      "Literal Name",             //17
      "Literal",                  //18
      "Number",                   //19
      "",                         //20
      "a",                        //21
      "b",                        //22
      "c",                        //23
      "d",                        //24
      "e",                        //25
      "f",                        //26
      "g",                        //27
      "h",                        //28
      "i",                        //29
      "j",                        //30
      "k",                        //31
      "l",                        //32
      "m",                        //33
      "n",                        //34
      "o",                        //35
      "p",                        //36
      "q",                        //37
      "r",                        //38
      "s",                        //39
      "t",                        //40
      "u",                        //41
      "v",                        //42
      "w",                        //43
      "x",                        //44
      "y",                        //45
      "z",                        //46
      "0",                        //47
      "1",                        //48
      "2",                        //49
      "3",                        //50
      "4",                        //51
      "5",                        //52
      "6",                        //53
      "7",                        //54
      "8",                        //55
      "9",                        //56
      };

  
  //Allowed terminals
  private String terminalSigns[] = {"a","b","c","d","e","f","g","h","i",
      "j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
      "0","1","2","3","4","5","6","7","8","9", ""};
  
  //Used nonterminals
  private String nonterminalSigns[] = {"HML","Expression","Term","Actions",
      "ActionsList","Action","Name","Literal","Number"};

  
  
  /**
   * Creates new parser. It only needs the start node of the graph to execute
   * actions.
   * @param startNode the start node of the graph
   */
  public HMParser(Node startNode) {
    this.logic = new HMLogic(startNode);
    for(int i=0;i<grammarRules.length;i++) grammar.add(grammarRules[i]);
    for(int i=0;i<HMLexer.tokens.length;i++) terminals.add(HMLexer.tokens[i]);
    for(int i=0;i<terminalSigns.length;i++) terminals.add(terminalSigns[i]);
    for(int i=0;i<nonterminalSigns.length;i++) nonterminals.add(nonterminalSigns[i]);
    
    stack.push("HML");
    
    createParsingTable();
  }
  
  
  /**
   * Gets the result of expression execution. This function needs to be called 
   * by the {@link HMLexer} when there are no more tokens in the expression.
   * @return true if the expression is OK, else false
   */
  public boolean getFinalResult() {
    return finalResult.isValueTrue();
  }
  
  
  /**
   * Stack condition.
   */
  public boolean isStackEmpty(){
    return stack.isEmpty();
  }
  
  /**
   * This function needs to be called by the {@link HMLexer} when
   * there are no more tokens in the expression. It checks whether the parser
   * state is OK.<br /><b>It can be called only ONE time</b>
   * @return true if parser state is ok, else false
   */
  public boolean isEverythingOK() {
    return "Expression".equals(stack.pop());
  }
  
  /**
   * Tries to parse the given token.
   * @param token The token to be parsed
   * @return Error message if the parsing fails
   */
  public String parse(String token){
    try{
      startParsing(token);
      previousToken = token;
      return "";
    }catch(Exception exc){
      return exc.getMessage();
    }
  }
  
  /**
   * The real parsing.
   * @param token The token to be parsed
   * @throws ParseException if the parsing fails
   */
  private void startParsing(String token) throws ParseException {
    if(stack.isEmpty()){
      throw new ParseException("The expresson is not completed (valid)");
    }
    String topOnStack = stack.pop();
    
    
    //if an action is creating
    if (literalOnTop) {
      actionName = topOnStack;
      literalOnTop = false;
    }
    if("Literal".compareTo(topOnStack)==0) {
      literalOnTop = true;
    }
    
    //if on the top on stack is Name
    if("Name".compareTo(topOnStack)==0) {
      parseName(token);
      return ;
    }
    
    //if in the top on stack is terminal
    if(topOnStack.compareTo(token)==0 && terminals.indexOf(topOnStack)>=0) {
      executeTokenAction(token);
      return ;
    }
    
    //if in the top on stack is nonterminal and got something else
    if(nonterminals.indexOf(topOnStack)==-1){
      throw new ParseException("ERROR: Sintax error. Exprected: \"" + topOnStack + "\" but got: \"" + token + "\"");
    }
    if(nonterminals.indexOf(token)>=0){
      throw new ParseException("ERROR: The token: \"" + token + "\" produces internal error. Change it!");
    }
    
    //finds a rule in grammar to substitute the nonterminal in the top of the stack
    int index=-1;
    int terminali_index = terminals.indexOf(token);
    if(terminali_index >= 0) {
      index = parsingTable[nonterminals.indexOf(topOnStack)][terminali_index];
    }
    else{
      throw new ParseException("ERROR: Expected reserve token after: \"" + previousToken + "\"");
    }
    
    //if there is no rule tries to apply (lambda) as exchange
    if(index==0 || index>=grammar.size()){
      index = parsingTable[nonterminals.indexOf(topOnStack)][terminals.indexOf("")];
      if(index<=0 || index>=grammar.size()){
        throw new ParseException("ERROR: Incorect sintax");
      }
    }
    
    //if in the top on the stack is nonterminal and needs to be substituted
    String pravilo[] = grammar.get(index).split(" ");
    if(pravilo[0].compareTo("")!=0 && index>=1) {
      for(int i=pravilo.length-1;i>=0;i--) stack.push(pravilo[i]);
    }
    startParsing(token);
  }
  
  
  /**
   * Checks if the name of the {@link Action} is valid.
   * @param token the name of the action
   * @throws ParseException if the name parsing fails
   */
  private void parseName(String token) throws ParseException{
    if(terminals.indexOf(token) >= terminals.indexOf("a") && token.length() > 0) {
      try {
        int ind = parsingTable[nonterminals.indexOf("Literal")][terminals.indexOf(Character.toString(token.charAt(0)))];
        if(ind <=0 || ind >=grammar.size()){
          throw new ParseException("ERROR: Each action name must begin with a literal");
        }
        for(int i=1;i<token.length();i++){
          ind = parsingTable[nonterminals.indexOf("Name")][terminals.indexOf(Character.toString(token.charAt(i)))];
          if(ind <=0 || ind >=grammar.size()){
            throw new ParseException("ERROR: Each action name can consists of: literals and numbers, only");
          }
        }
        actionName = token;
      } catch(Exception exc){
        throw new ParseException("ERROR: In action name. Each action name can consists of: literals and numbers, only");
      }
    }
    else{
      startParsing(token);
      //throw new ParseException("ERROR: The action name must not be one of the reserved names.");
    }
  }
  
  
  private void executeTokenAction(String token) throws ParseException {
    if ("]".equals(token)) {
      logic.ExecuteAction(new Action(actionName, true));
      
    } else if (">".equals(token)) {
      logic.ExecuteAction(new Action(actionName, false));
      
    } else if ("(".equals(token)) {
      logic.ExecuteOpenBracket();
      booleanStack.push(new BooleanOperation(finalResult));
      finalResult = new BooleanOperation(true, 'R');
      
    } else if (")".equals(token)) {
      logic.ExecuteCloseBracket();
      BooleanOperation topOnStack = booleanStack.pop();
      topOnStack.evaluateBoolean(finalResult.isValueTrue());
      finalResult = topOnStack;
      
    } else if ("AND".equals(token)) {
      logic.PopPushOperationState();
      finalResult.setPreviousOperation('A');
      
    } else if ("OR".equals(token)) {
      logic.PopPushOperationState();
      finalResult.setPreviousOperation('O');
      
    } else if ("NOT".equals(token)) {
      throw new ParseException("Operation: \"NOT\" is not currently supported.");
      
    } else if ("TT".equals(token)) {
      finalResult.evaluateBoolean(logic.ExecuteTT());
      
    } else if ("FF".equals(token)) {
      finalResult.evaluateBoolean(logic.ExecuteFF());
      
    } else if ("{".equals(token)) {
      throw new ParseException("Operation: \"{\" is not currently supported.");
      
    } else if ("}".equals(token)) {
      throw new ParseException("Operation: \"}\" is not currently supported.");
      
    } else if (",".equals(token)) {
      throw new ParseException("Operation: \",\" is not currently supported.");
      
    } else if ("US".equals(token)) {
      throw new ParseException("Operation: \"US\" is not currently supported.");
      
    } else if ("UW".equals(token)) {
      throw new ParseException("Operation: \"UW\" is not currently supported.");
      
    }
  }

  
  /**
   * Creating the parsing table.
   */
  private void createParsingTable(){
    parsingTable = new int[nonterminals.size()][terminals.size()];
    
    //HML
    parsingTable[0][4] = 1;
    parsingTable[0][5] = 1;
    parsingTable[0][7] = 1;
    parsingTable[0][9] = 1;
    parsingTable[0][10] = 1;
    parsingTable[0][11] = 1;
    
    //Expression
    for(int i=0;i<4;i++) parsingTable[1][i] = i+2;
    parsingTable[1][terminals.size() - 1] = 6;
    
    //Term
    parsingTable[2][4] = 7;
    parsingTable[2][5] = 8;
    parsingTable[2][7] = 9;
    parsingTable[2][9] = 10;
    parsingTable[2][10] = 11;
    parsingTable[2][11] = 12;
    
    //Actions
    parsingTable[3][13] = 14;
    for(int i=16;i<42;i++) parsingTable[3][i] = 13;
    
    //ActionsList
    parsingTable[4][15] = 15;
    parsingTable[4][terminals.size() - 1] = 16;
    
    //Action
    for(int i=16;i<42;i++) parsingTable[5][i] = 17;
    
    //Name
    for(int i=16;i<42;i++) parsingTable[6][i] = 18;
    for(int i=42;i<52;i++) parsingTable[6][i] = 19;
    parsingTable[6][terminals.size() - 1] = 20;
    
    //Literal
    for(int i=16;i<42;i++) parsingTable[7][i] = i + 5;
    
    //Number
    for(int i=42;i<52;i++) parsingTable[8][i] = i + 5;
  }
  
}