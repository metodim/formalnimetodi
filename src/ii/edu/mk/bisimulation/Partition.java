package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Maja Siljanoska
 */

public class Partition {
	private LinkedList<Block> partition;
	private int partitionSize;

	public Partition() {
		partition = new LinkedList<Block>();
		partitionSize = 0;
	}

	public void setPartition(LinkedList<Block> blocks) {
		partition = blocks;
		partitionSize = blocks.size();
	}

	public LinkedList<Block> getPartition() {
		return partition;
	}

	public void addBlock(Block block) {
		partition.add(block);
		partitionSize++;
	}

	public Partition constructI(Block B) {
		Partition tmp = new Partition();
		ListIterator<Block> it = partition.listIterator();
		Block X;
		while (it.hasNext())
		{
			X = it.next();
			boolean found = false;
			ListIterator<String> it1 = X.listIterator();
			String s;
			while (it1.hasNext() && !found)
			{
				s = it1.next();
				if (B.contains(s)){
					found = true;
				}
			}
			if (found)
				tmp.addBlock(X);
		}
		return tmp;
	}

	public Partition constructI2(Block B) {
		Partition tmp = new Partition();
		ListIterator<Block> it = partition.listIterator();
		Block X;
		while (it.hasNext())
		{
			X = it.next();
			boolean subset = true;
			ListIterator<String> it1 = X.listIterator();
			String s;
			while (it1.hasNext())
			{
				s = it1.next();
				if (!B.contains(s)){
					subset = false;
					break;
				}
			}
			if (subset)
				tmp.addBlock(X);
		}
		return tmp;
	}

	public int size() {
		return partition.size();
	}

	public Block get(int i) {
		return partition.get(i);
	}

	public void removeBlock(Block x) {
		partition.remove(x);
	}
	
	public boolean contains(String st){
		ListIterator<Block> it = partition.listIterator();
		Block B;
		while (it.hasNext())
		{
			B = it.next();
			if (B.contains(st))
				return true;
		}
		return false;
	}

	public ListIterator<Block> listIterator()
	{
		return partition.listIterator();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		ListIterator<Block> it = partition.listIterator();
		Block tmp = new Block();
		while (tmp.size()<2 && it.hasNext())
		{
			tmp = it.next();
		}
		sb.append(tmp);
		while (it.hasNext())
		{
			tmp = it.next();
			if (tmp.size()>1){
				sb.append(", ");
				sb.append(tmp);
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public boolean inSameBlock(String state1, String state2) {
		ListIterator<Block> it = partition.listIterator();
		Block tmp;
		while (it.hasNext())
		{
			tmp = it.next();
			if (tmp.contains(state1) && tmp.contains(state2))
				return true;
		}
		return false;
	}
}
