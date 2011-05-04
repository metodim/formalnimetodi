package ii.edu.mk.parser;

import static ii.edu.mk.parser.Ccs2Parser.ADD;
import static ii.edu.mk.parser.Ccs2Parser.CO_LABEL;
import static ii.edu.mk.parser.Ccs2Parser.DEF;
import static ii.edu.mk.parser.Ccs2Parser.LABEL;
import static ii.edu.mk.parser.Ccs2Parser.PROCESS;
import static ii.edu.mk.parser.Ccs2Parser.RENAME;
import static ii.edu.mk.parser.Ccs2Parser.RENAME_CLAUSE;
import static ii.edu.mk.parser.Ccs2Parser.RENAME_SINGLE;
import static ii.edu.mk.parser.Ccs2Parser.RESTRICT;
import static ii.edu.mk.parser.Ccs2Parser.RESTRICT_LABELS;
import static ii.edu.mk.parser.Ccs2Parser.SYNC;
import static ii.edu.mk.parser.Ccs2Parser.TAU;
import static ii.edu.mk.parser.Ccs2Parser.TRANSITION;
import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsDefinition;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsRename;
import ii.edu.mk.ccs.domain.CcsRestrict;
import ii.edu.mk.ccs.domain.CcsSynch;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.CcsOperator;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ASTDomainBuilder {

	private final static Logger LOG = LogManager.getLogger(ASTDomainBuilder.class);
	
	public static final ASTDomainBuilder INSTANCE = new ASTDomainBuilder();
	
	public CcsOperation getRoot(String expression) throws Exception {
		return (CcsOperation) getDomain(getAstFromExpression(expression));
	}

	public CcsOperation getRootNoRecursion(String expression) throws Exception {
		return (CcsOperation) getDomainNoRecursion(getAstFromExpression(expression));
	}
	
	private CommonTree getAstFromExpression(String expression) throws RecognitionException {
		Ccs2Lexer lex = new Ccs2Lexer(new ANTLRStringStream(expression));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Ccs2Parser parser = new Ccs2Parser(tokens);
		return (CommonTree) parser.expr().getTree();
	}
	
	/**
	 * Non recursive implementation for building the Ccs domain model tree form AST tree.
	 * 
	 * @param node - the root node of the AST tree
	 * @return CcsOperator - root node of the model domain model tree
	 */
	private CcsOperator getDomainNoRecursion(Tree rootNode){
		LinkedList<Tree> nodeList = traversePostOrder(rootNode);
		LinkedList<CcsOperator> operatorStack = new LinkedList<CcsOperator>();
		for(Tree node : nodeList){
			switch (node.getType()) {
				case DEF: LOG.debug("DEF");

					CcsOperation operation = (CcsOperation) operatorStack.pop();
					CcsProcess process = (CcsProcess) operatorStack.pop();
					CcsDefinition definition = new CcsDefinition(process, operation);
					operatorStack.push(definition);
					break;
				case ADD: LOG.debug("ADD");
					
					CcsOperation rightOperation = (CcsOperation) operatorStack.pop();
					CcsOperation leftOperation = (CcsOperation) operatorStack.pop();
					CcsAdd add = new CcsAdd(leftOperation, rightOperation);
					operatorStack.push(add);
					break;
				case SYNC: LOG.debug("SYNC");

					CcsOperation rightOperation1 = (CcsOperation) operatorStack.pop();
					CcsOperation leftOperation1 = (CcsOperation) operatorStack.pop();
					CcsSynch synch = new CcsSynch(leftOperation1, rightOperation1);
					operatorStack.push(synch);
					break;
				case RESTRICT: LOG.debug("RESTRICT");

					ListOperator restrictList1 = (ListOperator) operatorStack.pop();
					CcsOperation operation1 = (CcsOperation) operatorStack.pop();
					CcsRestrict restrict = new CcsRestrict(operation1, restrictList1.<CcsAction>getList());
					operatorStack.push(restrict);
					break;
				case RENAME: LOG.debug("RENAME");
					
					MapOperator renameMap1 = (MapOperator) operatorStack.pop();
					CcsOperation operation2 = (CcsOperation) operatorStack.pop();
					CcsRename rename = new CcsRename(operation2, renameMap1.<CcsAction>getMap());
					operatorStack.push(rename);
					break;
				case TAU: LOG.debug("TAU"); // Action = TAU | CO_LABEL | LABEL
					
					operatorStack.push(CcsAction.TAU);
					break;
				case LABEL: LOG.debug("LABEL");

					operatorStack.push(new CcsAction(node.getText()));
					break;
				case CO_LABEL: LOG.debug("CO_LABEL");

					operatorStack.push(new CcsAction(node.getText(), true));
					break;
				case TRANSITION: LOG.debug("TRANSITION");
					
					CcsOperation operation3 = (CcsOperation) operatorStack.pop();
					CcsAction action = (CcsAction) operatorStack.pop();
					CcsTrans transition = new CcsTrans(action, operation3);
					operatorStack.push(transition);
					break;
				case PROCESS: LOG.debug("PROCESS");

					operatorStack.push(new CcsProcess(node.getText()));
					break;
				//build compound nodes and put them on stack
				case RESTRICT_LABELS: LOG.debug("RESTRICT_LABELS");
				
					ListOperator restrictList = new ListOperator();
					restrictList.setList(getRestrictActions(node));
					operatorStack.push(restrictList);
					break;
				case RENAME_CLAUSE: LOG.debug("RENAME_CLAUSE");
				
					MapOperator renameMap = new MapOperator();
					renameMap.setMap(getRenameMap(node));
					operatorStack.push(renameMap);
					break;
				default:
					throw new IllegalArgumentException("Should not be here node.getType()=" + node.getType());
			}
			
		}
		return operatorStack.get(0);
	
	}
	
	private LinkedList<Tree> traversePostOrder(Tree rootNode){
		LinkedList<Tree> stackOut = new LinkedList<Tree>();
		Stack<Tree> stackIn =new Stack<Tree>();
		stackIn.push(rootNode);

		while(!stackIn.isEmpty()){
			Tree node = stackIn.peek();
			stackOut.addFirst(node);
			stackIn.pop();
			if(isNotRestricOrRename(node)){
				if(node.getChildCount() >= 1 && node.getChild(0) != null){
					stackIn.push(node.getChild(0));
				}
				if(node.getChildCount() >= 2 && node.getChild(1) != null){
					stackIn.push(node.getChild(1));
				}	
			}
		}
		
		return stackOut;
	}
	
	private boolean isNotRestricOrRename(Tree node){
		return node.getType() != RESTRICT_LABELS 
				&& node.getType() != RENAME_CLAUSE
				&& node.getType() != RENAME_SINGLE;
	}
	
	/**
	 * Helper class
	 * @author carevski
	 */
	class ListOperator extends CcsOperator{
		List<? extends CcsOperator> listOperator;
		@Override
		public OperatorType getType() {return null;}
		public <T extends CcsOperator> void setList(List<T> list){ listOperator = list; }
		@SuppressWarnings("unchecked")
		public <T extends CcsOperator> List<T> getList(){return (List<T>) listOperator; }
	}
	
	/**
	 * Helper class
	 * @author carevski
	 */
	class MapOperator extends CcsOperator{
		Map<? extends CcsOperator, ? extends CcsOperator> mapOperator;
		@Override
		public OperatorType getType() {return null;}
		public <T extends CcsOperator> void setMap(Map<T, T> map){ mapOperator = map; }
		@SuppressWarnings("unchecked")
		public <T extends CcsOperator> Map<T, T> getMap(){return (Map<T, T>) mapOperator; }
	}
	
	
	/**
	 * Recursive implementation for building the Ccs domain model tree form AST tree.
	 * 
	 * @param node - the root node of the AST tree
	 * @return CcsOperator - root node of the model domain model tree
	 */
	private CcsOperator getDomain(Tree node) {
		switch (node.getType()) {
			
			case DEF: LOG.debug("DEF");
				return new CcsDefinition(new CcsProcess(node.getChild(0).getText()),
						(CcsOperation) getDomain((CommonTree) node.getChild(1)));
		
			case ADD: LOG.debug("ADD");
				return new CcsAdd((CcsOperation) getDomain(node.getChild(0)),
						(CcsOperation) getDomain((CommonTree) node.getChild(1)));
	
			case SYNC: LOG.debug("SYNC");
				return new CcsSynch((CcsOperation) getDomain(node.getChild(0)),
						(CcsOperation) getDomain(node.getChild(1)));
	
			case RESTRICT: LOG.debug("RESTRICT");
				return new CcsRestrict((CcsOperation) getDomain(node.getChild(0)),
						getRestrictActions(node.getChild(1)));
	
			case RENAME: LOG.debug("RENAME");
				return new CcsRename((CcsOperation) getDomain(node.getChild(0)),
						getRenameMap(node.getChild(1)));
	
				// Action = TAU | CO_LABEL | LABEL
			case TAU: LOG.debug("TAU");
				return CcsAction.TAU;
	
			case LABEL: LOG.debug("LABEL");
				return new CcsAction(node.getText());
	
			case CO_LABEL: LOG.debug("CO_LABEL");
				return new CcsAction(node.getText(), true);
	
			case TRANSITION: LOG.debug("TRANSITION");
				return new CcsTrans((CcsAction) getDomain(node.getChild(0)),
						(CcsOperation) getDomain(node.getChild(1)));
	
			case PROCESS: LOG.debug("PROCESS");
				return new CcsProcess(node.getText());
	
			default:
				throw new IllegalArgumentException("Should not be here node.getType()=" + node.getType());
		}
	}

	private List<CcsAction> getRestrictActions(Tree node) {

		if (node.getType() != RESTRICT_LABELS){
			throw new IllegalArgumentException("node.type must be RESTRICT_LABELS !");
		}
		
		List<CcsAction> restrictActions = new ArrayList<CcsAction>();

		for (int i = 0; i < node.getChildCount(); i++) {
			if (node.getChild(i).getType() != LABEL
					&& node.getChild(i).getType() != CO_LABEL
					&& node.getChild(i).getType() != TAU)
				throw new IllegalArgumentException("node type must be LABEL, CO_LABEL or TAU !");

			restrictActions.add(new CcsAction(node.getChild(i).getText()));
		}

		return restrictActions;
	}

	private Map<CcsAction, CcsAction> getRenameMap(Tree node) {

		if (node.getType() != RENAME_CLAUSE)
			throw new IllegalArgumentException("node.type must be RENAME_CLAUSE !");

		Map<CcsAction, CcsAction> renameMap = new HashMap<CcsAction, CcsAction>();

		for (int i = 0; i < node.getChildCount(); i++) {
			Tree renameSingle = node.getChild(i);

			if (renameSingle.getType() != RENAME_SINGLE)
				throw new IllegalArgumentException("renameSingle node type must be RENAME_SINGLE !");

			if (renameSingle.getChildCount() != 2)
				throw new IllegalArgumentException("renameSingle node must have exactly 2 children !");

			renameMap.put(new CcsAction(renameSingle.getChild(0).getText()),
					new CcsAction(renameSingle.getChild(1).getText()));
		}

		return renameMap;
	}
	
	//for debugging purposes
	@SuppressWarnings("unused")
	private void toStringNode(Tree node){
		switch(node.getType()){
		case DEF:System.out.println("DEF");break;
		case ADD:System.out.println("ADD");break;
		case SYNC:System.out.println("SYNC");break;
		case RESTRICT:System.out.println("RESTRICT");break;
		case RENAME:System.out.println("RENAME");break;
		case TAU:System.out.println("TAU");break;
		case LABEL:System.out.println("LABEL");break;
		case CO_LABEL:System.out.println("CO_LABEL");break;
		case PROCESS:System.out.println("PROCESS");break;
		case TRANSITION:System.out.println("ТРАNSITION");break;
		case RESTRICT_LABELS:System.out.println("RESTRICT_LABELS");break;
		case RENAME_CLAUSE:System.out.println("RENAME_CLAUSE");break;
		case RENAME_SINGLE:System.out.println("RENAME_SINGLE");break;
		}
	}
	
}
