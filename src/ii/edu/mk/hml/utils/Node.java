
package ii.edu.mk.hml.utils;

import java.util.ArrayList;

import ii.edu.mk.hml.utils.Node;
import ii.edu.mk.hml.utils.Transition;


/**
 * <p>Each node have a name and a list with transitions. This list keeps all
 * the transitions where this node is start node.</p>
 * <p>Example:
 * <br />If you have this graph with n1 node as start node:
 * <ul>
 * <li>n1 -a-> n2
 * <li>n2 -b-> n3
 * <li>n3 -c-> n1
 * </ul>
 * You can create it with this commands:
 * <code>
 * <ul>
 * <li>Node n1 = new Node("n1");<br />
 * Node n2 = new Node("n2");<br />
 * Node n3 = new Node("n3");
 * <li>n1.{@link Node#connectWithNode(Node, String) connectWithNode}(n2, "a");
 * <br />n2.{@link Node#connectWithNode(Node, String) connectWithNode}(n3, "b");
 * <br />n3.{@link Node#connectWithNode(Node, String) connectWithNode}(n1, "c");
 * </ul>
 * </code>
 * </p>
 * <p>This way you can easily move thru nodes with a transition (action).
 * </p>
 */
public class Node {
  private String name;
  private ArrayList<Transition> transitions;
  
  /**
   * Creates new node with the given name.
   * @param name Node's name
   */
  public Node(String name) {
    this.name = name;
    transitions = new ArrayList<Transition>();
  }
  
  
  /**
   * Connects this node with the given node by creating new
   * {@link Transition} with the given node and transitionName as parameters.
   * @param node Node to be connected to
   * @param transitionName The name of the transition that will be created.
   */
  public void connectWithNode(Node node, String transitionName) {
    transitions.add(new Transition(transitionName, node));
  }
  
  
  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }
  
  /**
   * @param index The index of {@link Transition} in transition list.
   * @return The {@link Transition} at the given index. If the index is not
   * valid then it will return <b>null</b>.
   */
  public Transition getTransition(int index) {
    if (index < 0 || index >= transitions.size()) {
      return null;
    }
    return transitions.get(index);
  }
  
  /**
   * @return The number of transitions in the list.
   */
  public int getTransitionsCount() {
    return transitions.size();
  }


  @Override
  public String toString() {
    return "Node [name=" + name + ", transitions=" + transitions + "]";
  }
  
  @Override
  public boolean equals(Object obj) {
    return getName().equals(((Node)obj).getName());
  }
  
  @Override
  public int hashCode() {
    return getName().hashCode();
  }
    
}
