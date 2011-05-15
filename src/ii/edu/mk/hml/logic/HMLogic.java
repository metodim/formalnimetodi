
package ii.edu.mk.hml.logic;

import ii.edu.mk.hml.hm.Action;
import ii.edu.mk.hml.utils.Node;

import java.util.ArrayList;

/**
 * Implementation of Hennessy-Milner logic. More precisely it implements the functions:
 * {@link HMLogic#ExecuteAction(Action) ExecuteAction}, 
 * {@link HMLogic#ExecuteTT() ExecuteTT} and 
 * {@link HMLogic#ExecuteFF() ExecuteFF}.
 */
public class HMLogic extends Logic {

  public HMLogic(Node startNode) {
    super(startNode);
  }

  /**
   * Executes the given {@link Action}.
   */
  @Override
  public void ExecuteAction(Action a) {
    if (currentState.isPreviousStatusOK()) {
      ArrayList<NodeState> currentNodesState = currentState.getCurrentNodesState();
      ArrayList<NodeState> crossedNodesState = new ArrayList<NodeState>();
      ArrayList<Integer> deletedStates = new ArrayList<Integer>();
      boolean status = currentState.isStatusOK();
      
      boolean foundAll = true, found;
      for (int j = 0; j < currentNodesState.size(); j++) {
        found = false;
        for (int i = 0; i < currentNodesState.get(j).getNode().getTransitionsCount(); i++) {
          if (currentNodesState.get(j).getNode().getTransition(i).getName().equals(a.getName())) {
            crossedNodesState.add(new NodeState(
                currentNodesState.get(j).getNode().getTransition(i).getEndNode(),
                currentNodesState.get(j).getPath() == null ? j : currentNodesState.get(j).getPath())
            );
            found = true;
          }
        }
        
        if (!found) {
          if (currentNodesState.get(j).getPath() != null &&  !deletedStates.contains(currentNodesState.get(j).getPath())) {
            deletedStates.add(currentNodesState.get(j).getPath());
          }
          else {
            deletedStates.add(j);
          }
        }
        
        foundAll = foundAll && found;
      }
      
      //check crossed nodes
      for (int i = deletedStates.size() - 1; i >= 0; i--) {
        for (NodeState nodeState : crossedNodesState) {
          if (deletedStates.get(i) == nodeState.getPath()) {
            deletedStates.remove(i);
            break;
          }
        }
      }
      
      
      if (!currentState.isPreviousActionNull()) {
        if (currentState.isPreviousActionForAll() && !foundAll) {
          status = false;
        }
        if (currentState.isPreviousActionForAny() && crossedNodesState.size() == 0) {
          status = false;
        }
      }
      
      currentState.setStatus(status);
      currentState.setPreviousActionForm(a.isForAll());
      currentState.setCurrentNodesState(crossedNodesState);
      currentState.setErrorPaths(deletedStates);
    }
//    System.out.println("Execute action: " + a.toString());
  }

  /**
   * Executes "tt" command.
   */
  @Override
  public boolean ExecuteTT() {
    boolean result = false;
    if (currentState.isPreviousStatusOK() && currentState.isStatusOK()) {
      if (currentState.isPreviousActionForAny() && currentState.getCurrentNodesStateCount() > 0) {
        result = true;
      }
      if (currentState.isPreviousActionForAll()) {
        result = true;
      }
    }
//    System.out.println("ExecuteTT = " + result);
    return result;
  }

  /**
   * Executes "ff" command.
   */
  @Override
  public boolean ExecuteFF() {
    boolean result = false;
    if (currentState.isPreviousStatusOK()) {
      if (currentState.isStatusOK() && currentState.isPreviousActionForAny()
          && currentState.getErrorPathsCount() > 0) {
        result = true;
      }
      if (currentState.isPreviousActionForAll()) {
        if (!currentState.isStatusOK()) {
          result = true;
        }
        else {
          result = currentState.getCurrentNodesStateCount() == 0;
        }
      }
    }
//    System.out.println("ExecuteFF = " + result);
    return result;
  }
  
}
