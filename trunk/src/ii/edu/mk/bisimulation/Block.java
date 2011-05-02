package ii.edu.mk.bisimulation;

import java.util.LinkedList;

public class Block {
	private LinkedList<String> states;

	public Block() {
		states = new LinkedList<String>();
	}

	public void addState(String st) {
		states.add(st);
	}

	public void setStates(LinkedList<String> B) {
		states = B;
	}

	public LinkedList<String> getStates() {
		return states;
	}

	public Partition partitionate(Block B) {
		Partition tmp = new Partition();
		Block tmp1 = new Block(); // presek
		Block tmp2 = new Block(); // razlika
		for (int i = 0; i < this.states.size(); i++) {
			String s = this.states.get(i);
			if (B.getStates().contains(s))
				tmp1.addState(s);
			else
				tmp2.addState(s);
		}
		tmp.addBlock(tmp1);
		tmp.addBlock(tmp2);
		return tmp;
	}

	public int size() {
		return states.size();
	}

	public String get(int i) {
		return states.get(i);
	}

	public void addAllStates(Block B) {
		for (int i = 0; i < B.size(); i++)
			states.add(B.get(i));
	}

	public String toString() {
		return states.toString();
	}
}
