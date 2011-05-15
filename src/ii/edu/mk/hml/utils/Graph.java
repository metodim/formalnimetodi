
package ii.edu.mk.hml.utils;

import java.util.ArrayList;

import ii.edu.mk.hml.exceptions.NodeIsNull;
import ii.edu.mk.hml.exceptions.NodeNotInTheGraph;


/**
 * Class representing a graph. You must first add nodes into the graph with
 * {@link Graph#addNode(Node) addNode} function, and at the end
 * you must call {@link Graph#setStartNode(Node) setStartNode} function.
 */
public class Graph {
  private Node startNode;
  private ArrayList<Node> nodes;
  
  /**
   * Create new graph.
   */
  public Graph(){
    nodes = new ArrayList<Node>();
    startNode = null;
  }

  
  /**
   * @param startNode Graph's start {@link Node}.
   * @throws NodeIsNull if the start node is <b>null</b>.
   * @throws NodeNotInTheGraph if the start node is not added into the graph.
   */
  public void setStartNode(Node startNode)
      throws NodeIsNull, NodeNotInTheGraph {
    if (startNode == null) {
      throw new NodeIsNull("The start node is null");
    }
    if (!nodes.contains(startNode)) {
      throw new NodeNotInTheGraph();
    }
    this.startNode = startNode;
  }
  
  /**
   * Add new node in the graph.
   * @param node the node to be added
   * @throws NodeIsNull if the node is <b>null</b>
   */
  public void addNode(Node node) throws NodeIsNull {
    if (node == null) {
      throw new NodeIsNull("The node is null");
    }
    if(!isContainNode(node))
    	nodes.add(node);
  }


  /**
   * @return Returns the startNode.
   * @throws NodeIsNull if the start node is <b>null</b>
   */
  public Node getStartNode() throws NodeIsNull {
    if (startNode == null) {
      throw new NodeIsNull("Start node is null. I can't return it.");
    }
    return startNode;
  }
  
  /**
   * @param index The index of {@link Node} in node list.
   * @return The {@link Node} at the given index. If the index is not
   * valid then it will return <b>null</b>.
   */
  public Node getNode(int index) {
    if (index < 0 || index >= nodes.size()) {
      return null;
    }
    return nodes.get(index);
  }
  
  /**
   * @return The number of nodes in the list.
   */
  public int getNodesCount() {
    return nodes.size();
  }

  
  /**
   * 
   * @param node
   * @return is node already exist
   */
  public boolean isContainNode(Node node)
  {
	  if(nodes.contains(node))
		  return true;
	  
	  if(findNodeByName(node.getName()) != null)
		  return true;
	  
	  return false;
  }
  
  public void connectNodes(Node n1, Node n2, String trasition) throws NodeIsNull
  {
	  Node node1 = findNodeByName(n1.getName());
	  if(node1 == null)
	  {
		  addNode(n1);
		  node1 = n1;
	  }
	  
	  Node node2 = findNodeByName(n2.getName());
	  if(node2 == null)
	  {
		  addNode(n2);
		  node2 = n2;
	  }
	  
	  node1.connectWithNode(node2, trasition);
  }
  
  public Node findNodeByName(String name)
  {
	  for(Node n: nodes)
		  if(n.getName().compareTo(name)==0)
			  return n;
	  
	  return null;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Graph [startNode=" + startNode + ",\n nodes=" + nodes + "]";
  }
  
}
