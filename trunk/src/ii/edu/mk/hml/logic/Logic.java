
package ii.edu.mk.hml.logic;

import ii.edu.mk.hml.hm.Action;
import ii.edu.mk.hml.hm.HMParser;
import ii.edu.mk.hml.utils.Graph;
import ii.edu.mk.hml.utils.Node;
import ii.edu.mk.hml.logic.Logic;
import ii.edu.mk.hml.logic.NodeState;
import ii.edu.mk.hml.logic.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * <p>Abstract class to be extended with Hennessy-Milner logic.</p>
 * <p>This class is used in the {@link HMParser} class and here is
 * one scenario which describes its purpose:<br />
 * - Lets take this expression for example:
 * [a] ( &lt;a&gt;tt AND &lt;b&gt;tt ). This are the functions that
 * will be called to evaluate whether it is true or false:
 * <ul>
 * <li>{@link Logic#ExecuteAction(Action) ExecuteAction} for action: [a]
 * <li>{@link Logic#PushState() PushState} for "(" token
 * because we need to be able to return to this state when:
 * <ul>
 * <li>the bracket closes
 * <li>OR operation is called
 * <li>AND operation is called
 * </ul> 
 * <li>{@link Logic#ExecuteAction(Action) ExecuteAction} for action:
 * &lt;a&gt;
 * <li>{@link Logic#ExecuteTT() ExecuteTT} for "tt" token and get the
 * boolean returned for boolean logic processing
 * <li>{@link Logic#PopState() PopState} for "AND" token because we
 * need to return to previous state (after the execution of action [a])
 * <li>{@link Logic#ExecuteAction(Action) ExecuteAction} for action:
 * &lt;b&gt;
 * <li>{@link Logic#ExecuteFF() ExecuteFF} for "ff" token and get the
 * boolean returned for boolean logic processing
 * <li>{@link Logic#PopState()() PopState} for ")" token.
 * </ul>
 * - When the expression processing is finished we will get this boolean
 * logic expression: (boolean AND boolean)... and then is the easy part :) 
 * </p>
 */
public abstract class Logic {
  protected State currentState;
  
  
  /**
   * Creates new Logic for the given graph. It actually crates new {@link State}
   * with {@link Graph#getStartNode() getStartNode} in State's current nodes list.
   * This State is initial and the execution of 
   */
  public Logic(Node startNode) {
    currentState = new State(startNode);
  }
  
  
  /**
   * Executes "(" token.
   */
  public void ExecuteOpenBracket() {
    PushState();
    PushState();
    currentState.resetCurrentNodesPaths();
    currentState.resetErrorPaths();
//    System.out.println("OpenBracket");
  }
  
  /**
   * Executes ")" token
   */
  public void ExecuteCloseBracket() {
    PopState();
    PopState();
//    System.out.println("CloseBracket");
  }
  

  /**
   * Remembers the current state by putting it on top of the stack.
   */
  public void PushState() {
    State newState = new State(currentState);
    newState.setPreviousState(currentState);
    currentState = newState;
  }
  
  /**
   * Overrides the current state with the previous state.
   */
  public void PopState() {
    currentState = currentState.getPreviousState();
  }
  
  /**
   * This function is called if: AND or OR operation is called.
   */
  public void PopPushOperationState() {
    ArrayList<Integer> errorPaths = currentState.getErrorPaths();
    Collections.sort(errorPaths, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 < o2 ? 0 : 1;
      }
    });

    PopState();
    ArrayList<NodeState> currentNodesState = currentState.getCurrentNodesState();
    PushState();
    
    for (int i = errorPaths.size() - 1; i >= 0; i--) {
      currentNodesState.remove((int)errorPaths.get(i));
    }

    currentState.setCurrentNodesState(currentNodesState);
    currentState.resetCurrentNodesPaths();
    currentState.resetErrorPaths();
    
//    System.out.println("PopPushOperationState");
  }
  
  
  /**
   * This function will be called by the parser when he reaches to some
   * {@link Action}.
   * <br /><i>You should implement your logic to execute the given action.</i>
   * @param a {@link Action} to be executed
   */
  public abstract void ExecuteAction(Action a);
  
  
  /**
   * This function will be called by the parser
   * when it reaches to "tt" token.
   * <br /><i>You should implement your logic to check your state.</i>
   * @return true if the state is OK, else false
   */
  public abstract boolean ExecuteTT();
  
  /**
   * This function will be called by the parser
   * when it reaches to "ff" token.
   * <br /><i>You should implement your logic to check your state.</i>
   * @return true if the state is NOT OK, else false
   */
  public abstract boolean ExecuteFF();
  
  /**
   * This function will be called by the parser
   * when it reaches to {@link Action} but before the action there is "until"
   * operator: Uw or Us. 
   * <br /><i>You should implement your logic to check your state.</i>
   * @return true if the state is NOT OK, else false
   */
  public abstract boolean ExecuteUntil(Action previousAction, Action currentAction, boolean untilWeak);
}