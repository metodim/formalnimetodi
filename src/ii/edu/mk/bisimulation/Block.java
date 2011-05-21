package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Maja Siljanoska
 */

public class Block {
	private LinkedList<String> states;
	private int statesSize;

	public Block() {
		states = new LinkedList<String>();
		statesSize = 0;
	}

	public void addState(String st) {
		states.add(st);
		statesSize++;
	}

	public void setStates(LinkedList<String> B) {
		states = B;
		statesSize = B.size();
	}

	public LinkedList<String> getStates() {
		return states;
	}

	public Partition partitionate(Block B) {
		Partition tmp = new Partition();
		Block tmp1 = new Block(); // intersection
		Block tmp2 = new Block(); // complement
		
		ListIterator<String> it = states.listIterator();
		String s;
		while(it.hasNext())
		{
			s = it.next();
			if (B.contains(s))
				tmp1.addState(s);
			else
				tmp2.addState(s);
		}
		tmp.addBlock(tmp1);
		tmp.addBlock(tmp2);
		return tmp;
	}

	public int size() {
		return statesSize;
	}

	public String get(int i) {
		return states.get(i);
	}

	public void addAllStates(Block B) {
		ListIterator<String> it = B.listIterator();
		String state;
		while (it.hasNext())
		{
			state = it.next();
			states.add(state);
		}
	}	
	
	public ListIterator<String> listIterator()
	{
		return states.listIterator();
	}
	
	public boolean contains(String action)
	{
		return states.contains(action);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		ListIterator<String> it = states.listIterator();
		String tmp;
		while (it.hasNext())
		{
			tmp = it.next();
			sb.append(tmp);
			if (it.hasNext())
				sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
