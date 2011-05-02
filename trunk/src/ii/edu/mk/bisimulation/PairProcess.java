package ii.edu.mk.bisimulation;

import java.util.LinkedList;

public class PairProcess {
	private Node Node1;
	private Node Node2;

	public PairProcess(Node node1, Node node2) {
		setNode1(node1);
		setNode2(node2);
	}

	public void setNode1(Node node1) {
		Node1 = node1;
	}

	public Node getNode1() {
		return Node1;
	}

	public void setNode2(Node node2) {
		Node2 = node2;
	}

	public Node getNode2() {
		return Node2;
	}

	public boolean doSameActions() {
		LinkedList<String> tranzicii1 = Node1.getActions();
		LinkedList<String> tranzicii2 = Node2.getActions();

		if (tranzicii1.size() != tranzicii2.size()) {
			return false;
		} else {
			for (int i = 0; i < tranzicii1.size(); i++) {
				if (!tranzicii2.contains(tranzicii1.get(i))) {
					return false;
				}
			}
		}
		return true;
	}

}
