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

	public String getNodeName(int i) {
		return this.graph.get(i).getNodeName();
	}

	public int size() {
		return this.graph.size();
	}

	public ListPairProcess findStrongBisimulationNaive() {
		ListPairProcess list0 = new ListPairProcess();

		for (int i = 0; i < graph.size(); i++) {
			for (int j = i + 1; j < graph.size(); j++) {
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
		for (int i = 0; i < B.size(); i++) {
			Node nd = getNodeByProcess(B.get(i));
			LinkedList<CoupleTransition> llct = nd.getCoupleInverseTransitions();
			for (int j = 0; j < llct.size(); j++) {
				CoupleTransition ct = llct.get(j);
				if (ct.getAction().equals(action)) {
					LinkedList<String> proc = ct.getProcesses();
					for (int k = 0; k < proc.size(); k++) {
						if (!tmp.getStates().contains(proc.get(k)))
							tmp.addState(proc.get(k));
					}
				}
			}
		}
		return tmp;
	}

	public int getInfoMap(Block B, String a, String s) {
		LinkedList<CoupleTransition> ctlist = getNodeByProcess(s).getCoupleTransitions();
		LinkedList<String> tr = new LinkedList<String>();
		for (int i = 0; i < ctlist.size(); i++) {
			CoupleTransition ct = ctlist.get(i);
			if (ct.getAction().equals(a))
				tr = ct.getProcesses();
		}
		int tmp = 0;
		for (int i = 0; i < B.size(); i++) {
			if (tr.contains(B.get(i)))
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
				for (int i = 0; i < A.size(); i++) {
					String a = A.get(i);
					Block pomB = new Block();
					pomB = S.get(0);

					Block inverseT = getInverseT(a, pomB);
					Partition I = P.constructI(inverseT);

					for (int j = 0; j < I.size(); j++) {
						Block X = I.get(j);
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
			// unija Bii
			else if (S.size() > 1) {
				W.remove(S);
				for (int i = 0; i < A.size(); i++) {
					String a = A.get(i);
					Block pomB = new Block();
					pomB = S.get(0);

					Block inverseT = getInverseT(a, pomB);
					Partition I = P.constructI2(inverseT);

					for (int j = 0; j < I.size(); j++) {
						Block X = I.get(j);
						Block X1 = new Block();
						Block X2 = new Block();
						Block X3 = new Block();
						for (int k = 0; k < X.size(); k++) {
							String s = X.get(k);
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
								for (int m = 0; m < X3.size(); m++) {
									if (!X23.getStates().contains(X3.get(m)))
										X23.addState(X3.get(m));
								}

								X123.addAllStates(X23);
								for (int m = 0; m < X1.size(); m++) {
									if (!X123.getStates().contains(X1.get(m)))
										X123.addState(X1.get(m));
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

	public Node getNodeFromGraph(String NameGraph) {
		for (int i = 0; i < this.graph.size(); i++) {
			if (equalSpecificString(this.getNode(i).getNodeName(), NameGraph)) {
				return this.getNode(i);
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
		
		for (int i=0; i<pt.size(); i++)
		{
			if (!nodePostTransitions.contains(pt.get(i)))			
				nodePostTransitions.add(pt.get(i));
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
		Block B;
		while (it.hasNext())
		{
			B = it.next();
			minimizationGraphForBisimilarClass(B);
		}	
		
		for(int i = 1; i < this.size(); i++)
		{
			LinkedList<PostTransition> o = this.getNode(i).getPostTransitions();
			LinkedList<PostTransition> oNew = new LinkedList<PostTransition>();
			for(int j = 0; j < o.size(); j++)
			{
				if (!oNew.contains(o.get(j)))			
					oNew.add(o.get(j));
			}
			
			this.getNode(i).setPostTransitions(oNew);			
		}
	}	

	public LinkedList<Node> getAllNodeFromGraph(String NameGraph) {
		LinkedList<Node> nodes = new LinkedList<Node>();
		for (int i = 0; i < this.graph.size(); i++) {
			if (equalSpecificString(this.getNode(i).getNodeName(), NameGraph)) {
				nodes.add(this.getNode(i));
			}
		}
		return nodes;
	}

	public boolean equalGraph(Node n1, Graph g, Node n2) {
		//se proveruva dali imaat isti rebra, dokolku ne se prekinuva tuka
		if (!(n1.equalEdge(n2))) {
			return false;
		} else {
			//se zemaat site posttranzicii od prvoto teme i se otkriva rebro po rebro 
			LinkedList<PostTransition> ob1 = n1.getPostTransitions();
			
			//za sekoe izlezno rebro od prvata sostojba
			for (int i = 0; i < ob1.size(); i++) {
				boolean flag = false;
				boolean isLoop = false;
				
				//se zemaat soodvetnite procesi od vtoroto rebro koi ja pravat istst taa kacija
				
				LinkedList<PostTransition> ob2 = n2.getPostTransitionsByAction(ob1.get(i).getAction());

				//se pominuva niz niv se dodeka ne se najde soodvetnoto proces koj odgovara na sledniot
				for (int j = 0; j < ob2.size(); j++) {
					if (!ob1.get(i).getColor().equals("black") && !ob2.get(j).getColor().equals("black")) {						
						
						Node n11 = this.getNodeFromGraph(ob1.get(i).getPostProcess());
						Node n22 = g.getNodeFromGraph(ob2.get(j).getPostProcess());

						//ob1.get(i).setColor("black");
						//ob2.get(j).setColor("black");

						flag = flag || equalGraph(n11, g, n22);
					} else {
						isLoop = true;
					}

					if (flag == false && !isLoop) {
						return false;
					}

					ob1.get(i).setColor("black");
					ob2.get(j).setColor("black");
				}
			}
		}

		return true;
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
