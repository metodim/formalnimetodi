package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Jane Jovanovski
 */

public class PairProcess {
	private Node node1;
	private Node node2;

	public PairProcess(Node node1, Node node2) {
		setNode1(node1);
		setNode2(node2);
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}

	public Node getNode2() {
		return node2;
	}

	public boolean doSameActions() {
		LinkedList<String> actions1 = node1.getActions();
		LinkedList<String> actions2 = node2.getActions();

		if (actions1.size() != actions2.size()) {
			return false;
		} else {
			ListIterator<String> it = actions1.listIterator();
			String tmp;
			while (it.hasNext())
			{
				tmp = it.next();
				if (!actions2.contains(tmp)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("(");
		sb.append(node1.getNodeName());
		sb.append(", ");
		sb.append(node2.getNodeName());
		sb.append(")");
		return sb.toString();
	}
}
