
package ii.edu.mk.hml.utils;

/**
 * <p>Each transition has a name and end {@link Node}.
 * <br /></p>
 * <p>Examples:<br />
 * <ul>
 * <li>Transition: n1 -a-> n2, can be created with: new Transition("a", n2)
 * <li>Transition: n1 <-a- n2, can be created with: new Transition("a", n1) 
 * </ul>
 * As you can see, there is no way to find start node. This is created in this
 * way because every {@link Node} keeps a list with all transitions where he
 * is a start node.
 * <br /><i>View the class {@link Node} and you will get it right.</i>
 * </p>
 */
public class Transition {
  private String name;
  private Node endNode;
  
  /**
   * Creates new Transition.
   * @param name Transition's name
   * @param endNode Transition's end {@link Node}
   */
  public Transition(String name, Node endNode) {
    this.name = name;
    this.endNode = endNode;
  }
  
  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }
  
  /**
   * @return Returns the end {@link Node}.
   */
  public Node getEndNode() {
    return endNode;
  }
  

  /**
   * Example: -a-> n1
   * @return Transition representation
   */
  @Override
  public String toString() {
    return " -" + name + "-> " + endNode.getName();
  }
}
