
package ii.edu.mk.hml.exceptions;


@SuppressWarnings("serial")
public class NodeNotInTheGraph extends Exception
{
	public NodeNotInTheGraph()
	{
		super("The node is not in the graph. "
				+ "You need to call: addNode function, in Graph class.");
	}
}
