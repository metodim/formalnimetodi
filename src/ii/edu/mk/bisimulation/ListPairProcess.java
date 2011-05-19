package ii.edu.mk.bisimulation;

import java.util.LinkedList;

/**
 * This class keeps the array (the list) of pairs of processes which needs to be
 * reduced until a fixed point is obtained. A fixed point is obtained in the moment
 * when this array in the i-th and i+1-th iteration is equal. Then we print this
 * array. This array doesn't keep the symmetric nor the reflexive pairs. 
 * 
 * @author Jane Jovanovski
 */
public class ListPairProcess {
	private LinkedList<PairProcess> listPairProcess;

	public ListPairProcess() {
		setListPairProcess(new LinkedList<PairProcess>());
	}

	public void resetList(ListPairProcess l) {
		listPairProcess = new LinkedList<PairProcess>();
		listPairProcess = l.getListPairProcess();
	}

	/**
	 * Check whether two lists of two consecutive iterations are equal.
	 * Here it's enough to check only the length of the list, it's not needed
	 * to do the check element by element. This property comes from the algorithm
	 * itself, in each iteration at least one element is removed, and in the
	 * iteration where no element is removed we have actually found the fixed 
	 * point.
	 */
	public boolean equalsListPairProcess(ListPairProcess l) {
		LinkedList<PairProcess> l2 = l.getListPairProcess();
		if (listPairProcess.size() != l2.size()) {
			return false;
		}
		return true;
	}

	public void addPairProcess(PairProcess pair) {
		getListPairProcess().add(pair);
	}

	public PairProcess getPairProcess(int i) {
		return getListPairProcess().get(i);
	}

	public void setPairProcess(PairProcess pair) {
		getListPairProcess().add(pair);
	}

	/**
	 * Checks whether a pair of processes is contained in the array. This is needed
	 * for the moment when we need to decide for a pair of processes whether the 
	 * iteration needs to continue or it needs to be stopped. In order to make that
	 * decision, we need to find the transitions of the first process and also the 
	 * transitions of the second process and then check if these two sets are equal.
	 * That is done with the function doSameActions() from the PairProcess class.
	 * If the two sets are equal, then we analyse the behaviour of the processes
	 * for each of the transitions. For example, if both processes have same set
	 * of transitions and the transition with the action "a" is part of that set,
	 * then we need to find all the states(processes) in which we can get with "a" from 
	 * the first node, and all the states(processes) in which we can get with "a"
	 * from the second node. Dekart product is computed out of these two lists and
	 * a check is conducted whether that pair of processes is part of the current
	 * array of pairs of processes. This function checks only if a certain pair of
	 * processes is part of the array, and the additional logic described above is
	 * given in the function containsPairProcessInGraph(PairProcess pair, Graph g)
	 */
	public boolean containsPair(PairProcess pair) {
		if (pair.getNode1().getNodeName() == pair.getNode2().getNodeName()) {
			return true;
		}

		for (int i = 0; i < getListPairProcess().size(); i++) {
			if ((getListPairProcess().get(i).getNode1().getNodeName() == pair.getNode1().getNodeName() && 
					getListPairProcess().get(i).getNode2().getNodeName() == pair.getNode2().getNodeName()) || 
					(getListPairProcess().get(i).getNode1().getNodeName() == pair.getNode2().getNodeName() && 
							getListPairProcess().get(i).getNode2().getNodeName() == pair.getNode1().getNodeName())) {
				return true;
			}
		}

		return false;
	}

	public int size() {
		return getListPairProcess().size();
	}

	public boolean containsPairProcessInGraph(PairProcess pair, Graph g) {
		if (!pair.doSameActions()) {
			return false;
		} else {
			LinkedList<String> transitions = pair.getNode1().getActions();
			LinkedList<PostTransition> node1Transitions = g.getNodeFromGraph(pair.getNode1().getNodeName()).getPostTransitions();
			LinkedList<PostTransition> node2Transitions = g.getNodeFromGraph(pair.getNode2().getNodeName()).getPostTransitions();

			for (int i = 0; i < transitions.size(); i++) {
				LinkedList<String> node1Processes = new LinkedList<String>();
				LinkedList<String> node2Processes = new LinkedList<String>();

				for (int j = 0; j < node1Transitions.size(); j++) {
					if (node1Transitions.get(j).getAction().equals(transitions.get(i))) {
						node1Processes.add(node1Transitions.get(j).getPostProcess());
					}
				}

				for (int j = 0; j < node2Transitions.size(); j++) {
					if (node2Transitions.get(j).getAction().equals(transitions.get(i))) {
						node2Processes.add(node2Transitions.get(j).getPostProcess());
					}
				}

				for (int j = 0; j < node1Processes.size(); j++) {
					for (int k = 0; k < node2Processes.size(); k++) {
						PairProcess pairs = new PairProcess(g.getNodeFromGraph(node1Processes.get(j)), g.getNodeFromGraph(node2Processes.get(k)));
						if (!containsPair(pairs)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	void setListPairProcess(LinkedList<PairProcess> listPairs) {
		this.listPairProcess = listPairs;
	}

	LinkedList<PairProcess> getListPairProcess() {
		return listPairProcess;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < getListPairProcess().size(); i++) {
			s += "(" + getListPairProcess().get(i).getNode1().getNodeName() + ", " + getListPairProcess().get(i).getNode2().getNodeName() + ")";
			if (i != getListPairProcess().size() - 1)
				s += ", ";
		}
		return s;
	}
}
