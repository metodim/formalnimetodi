
package ii.edu.mk.hml.logic;

import ii.edu.mk.hml.utils.Graph;
import ii.edu.mk.hml.utils.Node;

import java.util.ArrayList;



/**
 * This class is used in {@link Logic} to easy manipulate with the {@link NodeState}s.
 */
public class State {
  private ArrayList<NodeState> currentNodesState;
  private ArrayList<Integer> errorPaths;
  private State previousState;
  private Boolean previousActionForAll;
  private Boolean status;
  private Boolean previousStatus;
  
  
  /**
   * @param startNode {@link Graph}'s start node
   */
  public State(Node startNode) {
    currentNodesState = new ArrayList<NodeState>();
    currentNodesState.add(new NodeState(startNode, null));
    errorPaths = new ArrayList<Integer>();
    this.previousState = null;
    this.previousActionForAll = null;
    this.status = true;
    this.previousStatus = true;
  }
  
  /**
   * @param state The state to be copied.
   */
  public State(State state) {
    currentNodesState = state.getCurrentNodesState();
    errorPaths = state.getErrorPaths();
    this.previousState = null;
    this.previousActionForAll = state.isPreviousActionForAll();
    this.status = state.isStatusOK();
    this.previousStatus = state.isPreviousStatusOK();
  }
  
  
  /**
   * @return Returns copy of the currentNodes list.
   */
  public ArrayList<NodeState> getCurrentNodesState() {
    ArrayList<NodeState> tempList = new ArrayList<NodeState>(currentNodesState.size());
    for (NodeState nodeState : currentNodesState) {
      tempList.add(new NodeState(nodeState.getNode(), nodeState.getPath()));
    }
    return tempList;
  }
  
  /**
   * @return how many nodes are currently opened.
   */
  public int getCurrentNodesStateCount() {
    return currentNodesState.size();
  }
  
  /**
   * @param currentNodes The currentNodes to set.
   */
  public void setCurrentNodesState(ArrayList<NodeState> currentNodesState) {
    this.currentNodesState = currentNodesState;
  }
  
  
  /**
   * Sets all {@link NodeState}s paths to <b>null</b>.
   */
  public void resetCurrentNodesPaths() {
    for (NodeState nodeState : currentNodesState) {
      nodeState.setPath(null);
    }
  }

  
  /**
   * @return the errorPaths
   */
  public ArrayList<Integer> getErrorPaths() {
    return errorPaths;
  }
  
  /**
   * @return how many paths are need to be deleted because they are not possible for the
   * action sequence.
   */
  public int getErrorPathsCount() {
    return errorPaths.size();
  }

  /**
   * @param errorPaths the errorPaths to set
   */
  public void setErrorPaths(ArrayList<Integer> errorPaths) {
    this.errorPaths = errorPaths;
  }
  
  /**
   * @param value the path that needs to be deleted because is not valid.
   */
  public void addErrorPath(Integer value) {
    errorPaths.add(value);
  }
  
  /**
   * Resets the errorPaths array
   */
  public void resetErrorPaths() {
    errorPaths = new ArrayList<Integer>();
  }

  
  /**
   * @return Returns the previousState.
   */
  public State getPreviousState() {
    return previousState;
  }
  
  /**
   * @param previousState The previousState to set.
   */
  public void setPreviousState(State previousState) {
    this.previousState = previousState;
  }
  
  
  /**
   * @return true if previous action form is forAll, else false
   */
  public Boolean isPreviousActionForAll() {
    return previousActionForAll;
  }
  
  /**
   * @return true if previous action form is forAny, else false
   */
  public Boolean isPreviousActionForAny() {
    return !previousActionForAll;
  }
  
  /**
   * @return true if previous action form is <b>null</b>, else false
   */
  public Boolean isPreviousActionNull() {
    return previousActionForAll == null;
  }

  /**
   * Sets the form of the previous action: forAll (true) or forAny (false).
   * @param previousActionForm the action form to set
   */
  public void setPreviousActionForm(Boolean previousActionForm) {
    this.previousActionForAll = previousActionForm;
  }

  
  /**
   * @return Returns the status.
   */
  public Boolean isStatusOK() {
    return status;
  }

  /**
   * @param status The status to set.
   */
  public void setStatus(Boolean status) {
    previousStatus = this.status;
    this.status = status;
  }
  

  /**
   * @return the previousStatus
   */
  public Boolean isPreviousStatusOK() {
    return previousStatus;
  }


  @Override
  public String toString() {
    return "State [currentNodesState=" + currentNodesState + ", errorPaths="
        + errorPaths + ", previousState=" + previousState
        + ", previousActionForAll=" + previousActionForAll + ", status="
        + status + ", previousStatus=" + previousStatus + "]";
  }

}
