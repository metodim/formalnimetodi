package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

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
	private int listPairProcessSize;

	public ListPairProcess() {
		listPairProcess = new LinkedList<PairProcess>();
		listPairProcessSize = 0;
	}

	public void resetList(ListPairProcess l) {
		listPairProcess = new LinkedList<PairProcess>();
		listPairProcess = l.getListPairProcess();
		listPairProcessSize = listPairProcess.size();
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
		if (this.size() != l2.size()) {
			return false;
		}
		return true;
	}

	public void addPairProcess(PairProcess pair) {
		listPairProcess.add(pair);
		listPairProcessSize++;
	}

	public PairProcess getPairProcess(int i) {
		return listPairProcess.get(i);
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
		if((pair.getNode2().getNodeName()).equals(pair.getNode1().getNodeName()))
		{
			return true;
		}
		
		LinkedList<PairProcess> listaPairProces = getListPairProcess();
		String node11, node12, node21, node22;
				
		node21 = pair.getNode1().getNodeName();
		node22 = pair.getNode2().getNodeName();
		
		ListIterator<PairProcess> itr = listaPairProces.listIterator();	
		while (itr.hasNext())
		{
			PairProcess pairProcesTekovna = itr.next();
			node11 = pairProcesTekovna.getNode1().getNodeName();
			node12 = pairProcesTekovna.getNode2().getNodeName();
		
			if ((node11.equals(node21) && node12.equals(node22)) || (node11.equals(node22) && node12.equals(node21)))			
			{
				return true;
			}
		}
		
		return false;
	}

	public int size() {
		return listPairProcessSize;
	}

	public boolean containsPairProcessInGraph(PairProcess pair, Graph g) {
		if (!pair.doSameActions()) {
			return false;
		} else {
			LinkedList<String> transitions = pair.getNode1().getActions();
			LinkedList<PostTransition> node1Transitions = g.getNodeFromGraph(pair.getNode1().getNodeName()).getPostTransitions();
			LinkedList<PostTransition> node2Transitions = g.getNodeFromGraph(pair.getNode2().getNodeName()).getPostTransitions();
			boolean flagMain = true;
			
			ListIterator<String> it = transitions.listIterator();
			
			String tmp;
			while (it.hasNext())
			{
				tmp = it.next();
				
				LinkedList<String> node1Processes = new LinkedList<String>();
				LinkedList<String> node2Processes = new LinkedList<String>();			
				
				for (int j = 0; j < node1Transitions.size(); j++) {
					if (node1Transitions.get(j).getAction().equals(tmp)) {
						node1Processes.add(node1Transitions.get(j).getPostProcess());
					}
				}				

				for (int j = 0; j < node2Transitions.size(); j++) {
					if (node2Transitions.get(j).getAction().equals(tmp)) {
						node2Processes.add(node2Transitions.get(j).getPostProcess());
					}
				}	
				
				boolean firstCheckTmp = false;
				boolean firstCheck = true;
				
				ListIterator<String> iterator1 = node1Processes.listIterator();
				ListIterator<String> iterator2;
				String process1, process2;
				PairProcess pairs;
				while (iterator1.hasNext())
				{
					process1 = iterator1.next();
					iterator2 = node2Processes.listIterator();
					firstCheckTmp = false;
					while (iterator2.hasNext()) {
						process2 = iterator2.next();
						pairs = new PairProcess(g.getNodeFromGraph(process1), g.getNodeFromGraph(process2));
						if (containsPair(pairs)) {
							firstCheckTmp = true;
							break;							
						}					
					}
					firstCheck = firstCheck && firstCheckTmp;
					
					if(!firstCheck) break;
				}
				
				boolean secondCheckTmp = false;
				boolean secondCheck = true;
				
				iterator1 = node2Processes.listIterator();				
				while (iterator1.hasNext())				
				{	
					process1 = iterator1.next();
					iterator2 = node1Processes.listIterator();
					secondCheckTmp = false;					
					while (iterator2.hasNext()) {
						process2 = iterator2.next();
						pairs = new PairProcess(g.getNodeFromGraph(process2), g.getNodeFromGraph(process1));
						if (containsPair(pairs)) {
							secondCheckTmp = true;
							break;	
						}					
					}
					secondCheck = secondCheck && secondCheckTmp;
					
					if(!secondCheck) break;
				}
				
				flagMain = flagMain && firstCheck && secondCheck;			
				
				if(!flagMain) 
					return false;
			}			
		}

		return true;	
	}

	public void setListPairProcess(LinkedList<PairProcess> listPairs) {
		this.listPairProcess = listPairs;
		listPairProcessSize = listPairs.size();
	}

	public LinkedList<PairProcess> getListPairProcess() {
		return listPairProcess;
	}
	
	public Partition createPartition()
	{		
		Partition partition = new Partition();
		if(this.size() == 0) 
		{
			return partition;
		}
		Block startBlock = new Block();
		String state1 = this.getPairProcess(0).getNode1().getNodeName();
		String state2 = this.getPairProcess(0).getNode2().getNodeName();
		startBlock.addState(state1);
		startBlock.addState(state2);
		partition.addBlock(startBlock);
		
		ListIterator<PairProcess> itr = this.getListPairProcess().listIterator();
		PairProcess tmp;
		
		while (itr.hasNext())
		{
			tmp = itr.next();
			state1 = tmp.getNode1().getNodeName();
			state2 = tmp.getNode2().getNodeName();
			
			for(int j = 0; j < partition.size(); j++)
			{
				boolean flag1 = partition.get(j).contains(state1);
				boolean flag2 = partition.get(j).contains(state2);
				if(flag1 && flag2)
					break;
				if(flag1 && flag2 == false)
				{
					partition.get(j).addState(state2);
					break;
				}
				
				if(flag1 == false && flag2)
				{
					partition.get(j).addState(state1);
					break;
				}
				
				if(j+1 == partition.size())
				{
					if(flag1 == false && flag2 == false)
					{
						state1 = tmp.getNode1().getNodeName();
						state2 = tmp.getNode2().getNodeName();
						startBlock = new Block();
						startBlock.addState(state1);
						startBlock.addState(state2);
						partition.addBlock(startBlock);
						break;
					}
				}
			}
		}
		
		return partition;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		ListIterator<PairProcess> it = listPairProcess.listIterator();
		PairProcess tmp;
		while (it.hasNext())
		{
			tmp = it.next();
			sb.append(tmp.toString());
			if (it.hasNext())
				sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
