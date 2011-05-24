package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Jane Jovanovski
 * @author Maja Siljanoska
 */

public class Graph {

	private LinkedList<Node> graph;
	private LinkedList<String> actions;
	private LinkedList<String> states;
	private Node initialNode;

	public Graph() {
		graph = new LinkedList<Node>();
		actions = new LinkedList<String>();
		states = new LinkedList<String>();
		initialNode = null;
	}

	public Graph(Graph g) {
		graph = new LinkedList<Node>();
		LinkedList<Node> nodes = g.getGraph();
		for (int i = 0; i < nodes.size(); i++)
			graph.add(new Node(nodes.get(i)));

		actions = g.getActions();
		states = g.getStates();
		initialNode = g.getInitialNode();
	}

	public LinkedList<Node> getGraph() {
		return graph;
	}

	public void setInitialNode(Node tmp) {
		if (initialNode == null)
			initialNode = tmp;
	}

	public Node getInitialNode() {
		return initialNode;
	}

	public void addAction(String action) {
		if (!actions.contains(action))
			actions.add(action);
	}

	public LinkedList<String> getActions() {
		return actions;
	}

	public LinkedList<String> getStates() {
		return states;
	}

	public void addNode(Node node) {
		graph.add(node);
		String st = node.getNodeName();
		if (!states.contains(st))
			states.add(st);
		LinkedList<PostTransition> postTransitions = node.getPostTransitions();
		for (int i = 0; i < postTransitions.size(); i++) {
			PostTransition pt = postTransitions.get(i);
			String act = pt.getAction();
			if (!actions.contains(act)) {
				actions.add(act);
			}
			String state = pt.getPostProcess();
			if (!states.contains(state))
				states.add(state);
		}
	}

	public Node getNode(int i) {
		return graph.get(i);
	}

	public Node getNodeByProcess(String process) {
		int i = 0;
		while (i < graph.size()) {
			Node tmp = graph.get(i);
			if (tmp.getNodeName().equals(process)) {
				return tmp;
			}
			i++;
		}
		return null;
	}

	public int size() {
		return this.graph.size();
	}

	public ListPairProcess findStrongBisimulationNaive() {
		ListPairProcess list0 = new ListPairProcess();

		for (int i = 0; i < graph.size()-1; i++) {
			for (int j = i+1; j < graph.size(); j++) {
				PairProcess pair = new PairProcess(this.getNode(i), this.getNode(j));
				list0.addPairProcess(pair);
			}
		}

		ListPairProcess list1 = new ListPairProcess();

		int k = 0;
		do {
			if (k != 0) {
				list0.resetList(list1);
			}

			k++;
			list1 = new ListPairProcess();

			ListIterator<PairProcess> itr = list0.getListPairProcess().listIterator();
			PairProcess tmp;
			while (itr.hasNext())
			{
				tmp = itr.next();				
				if(list0.containsPairProcessInGraph(tmp, this))
				{
					list1.addPairProcess(tmp);					
				}
			}			
		} while (!list0.equalsListPairProcess(list1));

		return list1;
	}

	public Block getInverseT(String action, Block B) {
		Block tmp = new Block();
		ListIterator<String> it = B.listIterator();
		while (it.hasNext()){
			String s = it.next();
			Node nd = getNodeByProcess(s);
			ListIterator<CoupleTransition> llct = nd.getCoupleInverseTransitions().listIterator();
			while(llct.hasNext()){
				CoupleTransition ct = llct.next();
				if (ct.getAction().equals(action)) {
					ListIterator<String> proc = ct.getProcesses().listIterator();
					while(proc.hasNext()) {
						String process = proc.next();
						if (!tmp.contains(process))
							tmp.addState(process);
					}
				}
			}
		}
		return tmp;
	}

	public int getInfoMap(Block B, String a, String s) {
		LinkedList<String> tr = new LinkedList<String>();
		ListIterator<CoupleTransition> ctit = getNodeByProcess(s).getCoupleTransitions().listIterator();
		while (ctit.hasNext()) {
			CoupleTransition ct = ctit.next();
			if (ct.getAction().equals(a))
				tr = ct.getProcesses();
		}
		int tmp = 0;
		ListIterator<String> itB = B.listIterator();
		while (itB.hasNext()) {
			if (tr.contains(itB.next()))
				tmp++;
		}
		return tmp;
	}

	public Partition findStrongBisimulationFernandez() {
		LinkedList<String> A = this.getActions();
		Block C = new Block();
		C.setStates(this.getStates());

		Partition P = new Partition();
		P.addBlock(C);
		LinkedList<Partition> W = new LinkedList<Partition>();
		Partition pom = new Partition();
		pom.addBlock(C);
		W.add(pom);

		while (W.size() > 0) {
			Partition S = W.get(0);

			// if S is a simple splitter, composed only of B
			if (S.size() == 1) {
				W.remove(S);
				ListIterator<String> it = A.listIterator();
				while (it.hasNext()){
					String a = it.next();
					Block pomB = new Block();
					pomB = S.get(0);

					Block inverseT = getInverseT(a, pomB);
					Partition I = P.constructI(inverseT);

					ListIterator<Block> it1 = I.listIterator();
					while(it1.hasNext()) {
						Block X = it1.next();
						Partition tmp = X.partitionate(inverseT);
						Block X1 = tmp.get(0);
						Block X2 = tmp.get(1);
						if (X1.size() > 0 && X2.size() > 0) {
							P.removeBlock(X);
							P.addBlock(X1);
							P.addBlock(X2);
							Partition xtmp = new Partition();
							xtmp.addBlock(X);
							if (X1.size() <= X2.size()) {
								xtmp.addBlock(X1);
								xtmp.addBlock(X2);
							} else {
								xtmp.addBlock(X2);
								xtmp.addBlock(X1);
							}
							W.add(xtmp);
						}
					}
				}
			}
			// if S is a compound splitter composed of (B, Bi, Bii), B = Bi
			// union Bii
			else if (S.size() > 1) {
				W.remove(S);
				ListIterator<String> it = A.listIterator();
				while (it.hasNext()) {
					String a = it.next();
					Block pomB = new Block();
					pomB = S.get(0);

					Block inverseT = getInverseT(a, pomB);
					Partition I = P.constructI2(inverseT);

					ListIterator<Block> it1 = I.listIterator();
					while(it1.hasNext()) {
						Block X = it1.next();
						Block X1 = new Block();
						Block X2 = new Block();
						Block X3 = new Block();
						ListIterator<String> it2 = X.listIterator();
						while(it2.hasNext()) {
							String s = it2.next();
							int info0 = getInfoMap(S.get(0), a, s);
							int info1 = getInfoMap(S.get(1), a, s);
							if (info0 == info1) {
								X1.addState(s);
							}
							if (info1 == 0) {
								X2.addState(s);
							}
							if (info1 > 0 && (info1 < info0)) {
								X3.addState(s);
							}
						}

						if (!X.equals(X1) && !X.equals(X2) && !X.equals(X3)) {
							if (X1.size() != 0 && X2.size() != 0 && X3.size() != 0) {
								Partition xtmp = new Partition();
								Partition xtmp1 = new Partition();
								Block X23 = new Block();
								Block X123 = new Block();

								X23.addAllStates(X2);
								ListIterator<String> it3 = X3.listIterator();
								while (it3.hasNext()) {
									String m = it3.next();
									if (!X23.contains(m))
										X23.addState(m);
								}

								X123.addAllStates(X23);
								ListIterator<String> it4 = X1.listIterator();
								while (it4.hasNext()) {
									String m = it4.next();
									if (!X123.contains(m))
										X123.addState(m);
								}

								xtmp.addBlock(X123);
								if (X1.size() <= X23.size()) {
									xtmp.addBlock(X1);
									xtmp.addBlock(X23);
								} else {
									xtmp.addBlock(X23);
									xtmp.addBlock(X1);
								}
								W.add(xtmp);

								xtmp1.addBlock(X23);
								if (X2.size() <= X3.size()) {
									xtmp1.addBlock(X2);
									xtmp1.addBlock(X3);
								} else {
									xtmp1.addBlock(X3);
									xtmp1.addBlock(X2);
								}
								W.add(xtmp1);

								P.removeBlock(X);
								if (X1.size() != 0) {
									P.addBlock(X1);
								}
								if (X2.size() != 0) {
									P.addBlock(X2);
								}
								if (X3.size() != 0) {
									P.addBlock(X3);
								}
							}
							else if (X1.size() != 0 || X2.size() != 0 || X3.size() != 0) {
								P.removeBlock(X);
								if (X1.size() != 0) {
									P.addBlock(X1);
								}
								if (X2.size() != 0) {
									P.addBlock(X2);
								}
								if (X3.size() != 0) {
									P.addBlock(X3);
								}

								Partition xtmp = new Partition();
								if (X1.size() != 0 && (X2.size() != 0 || X3.size() != 0) || X2.size() != 0 && (X1.size() != 0 || X3.size() != 0) || X3.size() != 0 && (X1.size() != 0 || X2.size() != 0))
								{
									xtmp.addBlock(X);
									if (X1.size() != 0 && X2.size() != 0) {
										if (X1.size() <= X2.size()) {
											xtmp.addBlock(X1);
											xtmp.addBlock(X2);
										} else {
											xtmp.addBlock(X2);
											xtmp.addBlock(X1);
										}
									}
									if (X1.size() != 0 && X3.size() != 0) {
										if (X1.size() <= X3.size()) {
											xtmp.addBlock(X1);
											xtmp.addBlock(X3);
										} else {
											xtmp.addBlock(X3);
											xtmp.addBlock(X1);
										}
									}
									if (X2.size() != 0 && X3.size() != 0) {
										if (X2.size() <= X3.size()) {
											xtmp.addBlock(X2);
											xtmp.addBlock(X3);
										} else {
											xtmp.addBlock(X3);
											xtmp.addBlock(X2);
										}
									}
								}
								else if (X1.size() != 0)
								{
									xtmp.addBlock(X1);
								}
								else if (X2.size() != 0)
								{
									xtmp.addBlock(X2);
								}
								else if (X3.size() != 0)
								{
									xtmp.addBlock(X3);
								}
								W.add(xtmp);
							}
						}
					}
				}
			}
		}
		return P;
	}

	public Node getNodeFromGraph(String nameGraph) {
		ListIterator<Node> it = graph.listIterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if (equalSpecificString(tmp.getNodeName(), nameGraph)) {
				return tmp;
			}
		}
		return null;
	}

	public void minimizationGraphForBisimilarClass(Block B)
	{
		ListIterator<String> it = B.listIterator();
		String process = it.next();
		Node node = this.getNodeByProcess(process);
		LinkedList<PostTransition> pt = node.getPostTransitions();
		StringBuilder sb = new StringBuilder(process);
		while (it.hasNext())
		{
			String pr = it.next();
			sb.append("$");
			sb.append(pr);
		}
		node.setProcess(sb.toString());

		ListIterator<Node> it1 = graph.listIterator();
		while (it1.hasNext())
		{
			Node node2 = it1.next();
			ListIterator<PostTransition> it2 = node2.getPostTransitions().listIterator();
			while (it2.hasNext())
			{
				PostTransition pp = it2.next();
				if(B.contains(pp.getPostProcess()))
				{
					pp.setPostProcess(node.getNodeName());
				}
			}
		}

		it = B.listIterator();
		process = it.next();

		LinkedList<PostTransition> nodePostTransitions = new LinkedList<PostTransition>();
		ListIterator<PostTransition> itpt = pt.listIterator();
		while (itpt.hasNext())
		{
			PostTransition tmp = itpt.next();
			if (!nodePostTransitions.contains(tmp))
				nodePostTransitions.add(tmp);
		}

		while (it.hasNext())
		{
			String process1 = it.next();
			Node node1 = this.getNodeByProcess(process1);
			ListIterator<PostTransition> it2 = node1.getPostTransitions().listIterator();
			while (it2.hasNext())
			{
				PostTransition pt2 = it2.next();
				if(!nodePostTransitions.contains(pt2))
					nodePostTransitions.add(pt2);
			}
			graph.remove(node1);
		}

		node.setPostTransitions(nodePostTransitions);
	}

	public void minimizationGraph(Partition P)
	{
		ListIterator<Block> it = P.listIterator();
		while (it.hasNext())
		{
			Block B = it.next();
			minimizationGraphForBisimilarClass(B);
		}

		ListIterator<Node> it1 = this.graph.listIterator();
		while (it1.hasNext())
		{
			Node node = it1.next();
			LinkedList<PostTransition> ptNew = new LinkedList<PostTransition>();
			ListIterator<PostTransition> ptit = node.getPostTransitions().listIterator();
			while (ptit.hasNext())
			{
				PostTransition tmp = ptit.next();
				if (!ptNew.contains(tmp))			
					ptNew.add(tmp);
			}
			node.setPostTransitions(ptNew);			
		}

		initialNode = getNodeFromGraph(initialNode.getNodeName());
	}

	public Graph mergeWithGraph(Graph g1)
	{
		Graph mergedGraph = new Graph(this);
		LinkedList<String> actions = mergedGraph.getActions();

		ListIterator<String> it1 = g1.getActions().listIterator();
		while (it1.hasNext())
		{
			String tmp = it1.next();
			if (!actions.contains(tmp))
				mergedGraph.addAction(tmp);
		}

		int n1 = this.getNumberOfStates();

		for (int i=0; i<g1.size(); i++)
		{
			Node node = g1.getNode(i);
			int st = Integer.parseInt(node.getNodeName());
			ListIterator<PostTransition> it = node.getPostTransitions().listIterator();
			
			Node node1 = mergedGraph.getNodeByProcess(Integer.toString(st+n1));
			if (node1 == null)
			{
				node1 = new Node(Integer.toString(st+n1));
				mergedGraph.addNode(node1);
			}
			
			while (it.hasNext())
			{
				PostTransition tmp = it.next();
				String action = tmp.getAction();
				int state = Integer.parseInt(tmp.getPostProcess());
				if (state < n1)
					state = state + n1;
				String process = Integer.toString(state);
				node1.addPostTransition(new PostTransition(process, action));
				
				Node node2 = mergedGraph.getNodeByProcess(process);
				if (node2 == null)
				{
					node2 = new Node(process);
					mergedGraph.addNode(node2);
				}
				node2.addCoupleInverseTransition(new CoupleTransition(action, node1.getNodeName()));
			}
		}

		mergedGraph.setInitialNode(mergedGraph.getNodeByProcess(Integer.toString(0)));

		return mergedGraph;
	}

	public boolean equalGraph(Graph g1, String equivalence)
	{
		Graph mergedGraph;
		String n;
		if (this.size() >= g1.size())
		{
			n = Integer.toString(this.size());
			mergedGraph = this.mergeWithGraph(g1);
		}
		else
		{
			n = Integer.toString(g1.size());
			mergedGraph = g1.mergeWithGraph(this);
		}
		String initialState1 = mergedGraph.getInitialNode().getNodeName();
		String initialState2 = mergedGraph.getNodeByProcess(n).getNodeName();

		Partition P = new Partition();
		if (equivalence.equals("naive"))
		{
			ListPairProcess L = mergedGraph.findStrongBisimulationNaive();
			P = L.createPartition();
		}
		else if (equivalence.equals("fernandez"))
		{
			P = mergedGraph.findStrongBisimulationFernandez();
		}
		System.out.println(P);
		if (P.inSameBlock(initialState1, initialState2))
			return true;
		else
			return false;
	}

	private boolean equalSpecificString(String s1, String s2) {
		boolean flag = false;

		String[] s1A = s1.split("\\$");
		String[] s2A = s2.split("\\$");

		if (!s1.contains("$")) {
			s1A[0] = s1;
		} else {
			s1A = s1.split("\\$");
		}

		if (!s2.contains("$")) {
			s2A[0] = s2;
		} else {
			s2A = s2.split("\\$");
		}

		for (int i = 0; i < s1A.length; i++) {
			for (int j = 0; j < s2A.length; j++) {
				if (s1A[i].equals(s2A[j])) {
					flag = true;
					return flag;
				}
			}
		}

		return flag;
	}

	public int getNumberOfStates()
	{
		return this.size();
	}

	public int getNumberOfTransitions()
	{
		int cnt = 0;
		ListIterator<Node> it = graph.listIterator();
		while (it.hasNext())
		{
			Node tmp = it.next();
			cnt += tmp.size();
		}
		return cnt;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListIterator<Node> it = graph.listIterator();
		Node tmp;
		while (it.hasNext())
		{
			tmp = it.next();
			sb.append(tmp);
			sb.append("\n");
		}
		return sb.toString();
	}
}
