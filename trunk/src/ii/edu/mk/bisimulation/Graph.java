package ii.edu.mk.bisimulation;

import java.util.LinkedList;

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

			for (int i = 0; i < list0.size(); i++) {
				if (list0.containsPairProcessInGraph(list0.getPairProcess(i), this)) {
					list1.addPairProcess(list0.getPairProcess(i));
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
			W.remove(0);

			// if S is a simple splitter, composed only of B
			if (S.size() == 1) {
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
			else if (S.size() == 3) {
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
							P.removeBlock(X);
							if (X1.size() != 0 && X2.size() != 0 && X3.size() != 0) {
								Partition xtmp = new Partition();
								Partition xtmp1 = new Partition();
								Block X23 = new Block();
								X23.addAllStates(X2);
								for (int m = 0; m < X3.size(); m++) {
									if (!X23.getStates().contains(X3.get(m)))
										X23.addState(X3.get(m));
								}
								xtmp.addBlock(X);
								if (X1.size() < X23.size()) {
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
							} else if (X1.size() != 0 || X2.size() != 0 || X3.size() != 0) {
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

	public void minimizationGraphForBisimulationPair(PairProcess ob) {
		String process1 = ob.getNode1().getNodeName();
		String process2 = ob.getNode2().getNodeName();

		if (process1.compareTo(process2) > 0) {
			String temp = process2;
			process2 = process1;
			process1 = temp;
		}

		Node nodeProcess1 = null;
		Node nodeProcess2 = null;
		int indexProcess2 = 0;

		for (int i = 0; i < this.size(); i++) {
			Node node = this.getNode(i);
			LinkedList<PostTransition> transitions = node.getPostTransitions();
			for (int j = 0; j < transitions.size(); j++) {
				if (equalSpecificString(transitions.get(j).getPostProcess(), process1)) {
					if (!process1.equals(process2)) {
						transitions.get(j).setPostProcess(process2 + "|" + process1);
					} else {
						transitions.get(j).setPostProcess(process2);
					}
				}

				if (equalSpecificString(transitions.get(j).getPostProcess(), process2)) {
					if (!process1.equals(process2)) {
						transitions.get(j).setPostProcess(process2 + "|" + process1);
					} else {
						transitions.get(j).setPostProcess(process2);
					}
				}
			}

			LinkedList<PostTransition> transitionsReduce = new LinkedList<PostTransition>();

			for (int k = 0; k < transitions.size(); k++) {
				PostTransition o2 = transitions.get(k);
				boolean exists = false;

				for (int kk = 0; kk < transitionsReduce.size(); kk++) {
					PostTransition o1 = transitionsReduce.get(kk);

					if (equalSpecificString(o1.getAction(), o2.getAction()) && equalSpecificString(o1.getPostProcess(), o2.getPostProcess())) {
						exists = true;
						break;
					}
				}

				if (!exists) {
					transitionsReduce.add(o2);
				}
			}

			node.setPostTransitions(transitionsReduce);

			if (equalSpecificString(node.getNodeName(), process1)) {
				nodeProcess1 = node;
			}

			if (equalSpecificString(node.getNodeName(), process2)) {
				indexProcess2 = i;
				nodeProcess2 = node;
			}
		}

		if (!process1.equals(process2)) {
			nodeProcess2.setNode(process2 + "|" + process1);
		} else {
			nodeProcess2.setNode(process2);
		}

		if (!process1.equals(process2)) {
			nodeProcess1.setNode(process2 + "|" + process1);
		} else {
			nodeProcess1.setNode(process2);
		}

		for (int i = 0; i < nodeProcess2.getPostTransitions().size(); i++) {
			if (!nodeProcess1.containsPostTransition(nodeProcess2.getPostTransitions().get(i))) {
				nodeProcess1.addPostTransition(nodeProcess2.getPostTransitions().get(i));
			}
		}

		if (!process1.equals(process2)) {
			this.graph.remove(indexProcess2);
		}
	}

	public void minimizationGraph(ListPairProcess list1) {
		for (int i = 0; i < list1.size(); i++) {
			PairProcess ob = list1.getPairProcess(i);
			String process1 = ob.getNode1().getNodeName();
			String process2 = ob.getNode2().getNodeName();

			if (process1.compareTo(process2) > 0) {
				String temp = process2;
				process2 = process1;
				process1 = temp;
			}

			for (int j = i + 1; j < list1.size(); j++) {
				PairProcess ob1 = list1.getPairProcess(j);

				if (equalSpecificString(ob1.getNode1().getNodeName(), process1)) {
					if (!process1.equals(process2)) {
						ob1.setNode1(new Node(process2 + "|" + process1));
					}
				}

				if (equalSpecificString(ob1.getNode2().getNodeName(), process1)) {
					if (!process1.equals(process2)) {
						ob1.setNode2(new Node(process2 + "|" + process1));
					}
				}

				if (equalSpecificString(ob1.getNode1().getNodeName(), process2)) {
					if (!process1.equals(process2)) {
						ob1.setNode1(new Node(process2 + "|" + process1));
					}
				}

				if (equalSpecificString(ob1.getNode2().getNodeName(), process2)) {
					if (!process1.equals(process2)) {
						ob1.setNode2(new Node(process2 + "|" + process1));
					}
				}
			}

			minimizationGraphForBisimulationPair(ob);
		}
	}

	public void minimizationGraph(Partition P) {
		for (int i = 0; i < P.size(); i++) {
			Block block = P.get(i);
			if (block.size() > 1) {
				for (int j = 0; j < block.size() - 1; j++) {
					String process1 = block.get(j);
					Node tmp1 = this.getNodeFromGraph(process1);
					for (int k = j + 1; k < block.size(); k++) {
						String process2 = block.get(k);
						Node tmp2 = this.getNodeFromGraph(process2);
						minimizationGraphForBisimulationPair(new PairProcess(tmp1, tmp2));
					}
				}
			}
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
		if (!(n1.equalEdge(n2))) {
			return false;
		} else {
			LinkedList<PostTransition> ob1 = n1.getPostTransitions();
			for (int i = 0; i < ob1.size(); i++) {
				boolean flag = false;
				boolean isLoop = false;
				LinkedList<PostTransition> ob2 = n2.getPostTransitionsByAction(ob1.get(i).getAction());

				for (int j = 0; j < ob2.size(); j++) {
					if (!ob1.get(i).getColor().equals("black") && !ob2.get(j).getColor().equals("black")) {
						Node n11 = this.getNodeFromGraph(ob1.get(i).getPostProcess());
						Node n22 = g.getNodeFromGraph(ob2.get(j).getPostProcess());

						ob1.get(i).setColor("black");
						ob2.get(j).setColor("black");

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

		String[] s1A = s1.split("\\|");
		String[] s2A = s2.split("\\|");

		if (!s1.contains("|")) {
			s1A[0] = s1;
		} else {
			s1A = s1.split("\\|");
		}

		if (!s2.contains("|")) {
			s2A[0] = s2;
		} else {
			s2A = s2.split("\\|");
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

	public String toString() {
		String s = "";
		for (int i = 0; i < graph.size(); i++) {
			s += graph.get(i) + "\n";
		}
		return s;
	}
}
