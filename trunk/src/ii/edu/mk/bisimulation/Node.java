package ii.edu.mk.bisimulation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Node {
	public String process;
	private LinkedList<PostTransition> postTransitions;
	private LinkedList<CoupleTransition> coupleTransitions;
	private LinkedList<CoupleTransition> coupleInverseTransitions;
	private int postTransitionsSize;

	public Node(String process) {
		this.process = process;
		postTransitions = new LinkedList<PostTransition>();
		coupleTransitions = new LinkedList<CoupleTransition>();
		coupleInverseTransitions = new LinkedList<CoupleTransition>();
		postTransitionsSize = 0;
	}

	public Node(Node n) {
		process = n.getNodeName();
		postTransitions = n.getPostTransitions();
		coupleTransitions = n.getCoupleTransitions();
		coupleInverseTransitions = n.getCoupleInverseTransitions();
		postTransitionsSize = 0;
	}

	public String getNodeName() {
		return process;
	}

	public void addPostTransition(PostTransition postTransition) {
		postTransitionsSize++;
		postTransitions.add(postTransition);
		String act = postTransition.getAction();
		int i = coupleTransitionsForAction(act);
		if (i == -1) {
			CoupleTransition tmp = new CoupleTransition(act);
			tmp.addProcess(postTransition.getPostProcess());
			coupleTransitions.add(tmp);
		} else {
			CoupleTransition tmp = coupleTransitions.get(i);
			tmp.addProcess(postTransition.getPostProcess());
		}
	}

	public void setPostTransitions(LinkedList<PostTransition> listPostTransitions) {
		postTransitions = listPostTransitions;
		postTransitionsSize = listPostTransitions.size();
	}

	public LinkedList<PostTransition> getPostTransitions() {
		return postTransitions;
	}

	public void addCoupleInverseTransition(CoupleTransition ct) {
		String act = ct.getAction();
		int i = coupleInverseTransitionsForAction(act);
		if (i == -1) {
			CoupleTransition tmp = new CoupleTransition(act);
			tmp.addProcess(ct.getProcesses().get(0));
			coupleInverseTransitions.add(tmp);
		} else {
			CoupleTransition tmp = coupleInverseTransitions.get(i);
			tmp.addProcess(ct.getProcesses().get(0));
		}
	}

	public void setCoupleInverseTransitions(LinkedList<CoupleTransition> ctlist) {
		coupleInverseTransitions = ctlist;
	}

	private int coupleTransitionsForAction(String a) {
		int i = 0;
		while (i < coupleTransitions.size()) {
			CoupleTransition tmp = coupleTransitions.get(i);
			if (tmp.getAction().equals(a))
				return i;
			i++;
		}
		return -1;
	}

	public int coupleInverseTransitionsForAction(String a) {
		int i = 0;
		while (i < coupleInverseTransitions.size()) {
			CoupleTransition tmp = coupleInverseTransitions.get(i);
			if (tmp.getAction().equals(a))
				return i;
			i++;
		}
		return -1;
	}

	public LinkedList<CoupleTransition> getCoupleInverseTransitions() {
		return coupleInverseTransitions;
	}

	public LinkedList<CoupleTransition> getCoupleTransitions() {
		return coupleTransitions;
	}

	public void printCoupleTransitions() {
		String s = process + ":   ";
		for (int i = 0; i < coupleTransitions.size(); i++) {
			s += coupleTransitions.get(i) + "   ";
		}
		System.out.println(s);
	}

	public void printCoupleInverseTransitions() {
		String s = process + ":   ";
		for (int i = 0; i < coupleInverseTransitions.size(); i++) {
			s += coupleInverseTransitions.get(i) + "   ";
		}
		System.out.println(s);
	}

	public LinkedList<String> getActions() {
		LinkedList<String> array = new LinkedList<String>();
		
		ListIterator<PostTransition> it = postTransitions.listIterator();
		String action;
		while (it.hasNext())
		{
			action = it.next().getAction();
			if (!array.contains(action))
				array.add(action);
		}
		return array;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String toString() {
		String s = "";
		s = process + "->";
		//int n = postTransitions.size();
		for (int i = 0; i < postTransitionsSize; i++) {
			s += postTransitions.get(i).toString();
			if (i + 1 != postTransitionsSize) {
				s += ", ";
			}
		}
		return s;
	}


	public boolean containsPostTransition(PostTransition postTransition) {
		boolean con = false;
		String process1 = postTransition.getPostProcess();
		String action1 = postTransition.getAction();
		
		ListIterator<PostTransition> it = postTransitions.listIterator();
		String process2, action2;
		PostTransition tmp;
		while(it.hasNext())
		{
			tmp = it.next();
			process2 = tmp.getPostProcess();
			action2 = tmp.getAction();
			if (equalSpecificString(process2, process1) && equalSpecificString(action2, action1)) {
				con = true;
				break;
			}
		}
		return con;
	}

	public boolean equalEdge(Node n2) {
		LinkedList<PostTransition> p = this.getPostTransitions();
		Collections.sort(p);

		if (this.getPostTransitions().size() != n2.getPostTransitions().size()) {
			return false;
		} else {
			LinkedList<PostTransition> p1 = this.getPostTransitions();
			Collections.sort(p1);

			LinkedList<PostTransition> p2 = n2.getPostTransitions();
			Collections.sort(p2);

			for (int i = 0; i < p1.size(); i++) {
				if (!(p1.get(i).getAction().equals(p2.get(i).getAction()))) {
					return false;
				}
			}
		}
		return true;
	}

	public LinkedList<PostTransition> getPostTransitionsByAction(String action) {
		LinkedList<PostTransition> ob = new LinkedList<PostTransition>();

		for (int i = 0; i < this.getPostTransitions().size(); i++) {
			if (this.getPostTransitions().get(i).getAction().equals(action)) {
				ob.add(this.getPostTransitions().get(i));
			}
		}

		return ob;
	}
	
	public int size()
	{
		return postTransitionsSize;
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
}
