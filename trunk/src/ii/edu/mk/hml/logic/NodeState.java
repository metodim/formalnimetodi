package ii.edu.mk.hml.logic;

import ii.edu.mk.hml.logic.NodeState;
import ii.edu.mk.hml.utils.Node;

public class NodeState {
  private Node node;
  private Integer path;
  
  
  /**
   * @param node
   * @param path
   */
  public NodeState(Node node, Integer path) {
    this.node = node;
    this.path = path;
  }


  /**
   * @return the node
   */
  public Node getNode() {
    return node;
  }

  /**
   * @param node the node to set
   */
  public void setNode(Node node) {
    this.node = node;
  }


  /**
   * @return the path
   */
  public Integer getPath() {
    return path;
  }

  /**
   * @param path the path to set
   */
  public void setPath(Integer path) {
    this.path = path;
  }


  @Override
  public String toString() {
    return "NodeState [node=" + node + ", path=" + path + "]";
  }
  
  @Override
  public boolean equals(Object obj) {
    return getNode().equals(((NodeState)obj).getNode());
  }
  
  @Override
  public int hashCode() {
    return getNode().hashCode();
  }
  
}
