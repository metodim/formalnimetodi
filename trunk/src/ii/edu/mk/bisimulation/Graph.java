package ii.edu.mk.bisimulation;

import java.util.LinkedList;
public class Graph {
	
	public LinkedList<Node> graph;
	
	public Graph()
	{
		graph = new LinkedList<Node>();
	}
	
	public void addNode (Node node)
	{
		graph.add(node);
	}
	
	public Node getNode (int i)
	{
		return graph.get(i);
	}
	
	public int getNodeName(int i)
	{
		return graph.get(i).getNode();
	}
	
	public int size()
	{
		return graph.size();
	}
	
	public String toString()
	{
		String s= "";
		for (int i = 0; i < graph.size(); i++)
		{
			s += graph.get(i) + "\n";
		}
		
		return s;
	}	
}
