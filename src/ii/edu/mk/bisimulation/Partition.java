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
	
	public static Partition createPartitionFromList(ListPairProcess list)
	{
		Partition partition = new Partition();
		Block startBlock = new Block();
		String state1 = list.getPairProcess(0).getNode1().getNodeName();
		String state2 = list.getPairProcess(0).getNode2().getNodeName();
		startBlock.addState(state1);
		startBlock.addState(state2);
		partition.addBlock(startBlock);
		
		ListIterator<PairProcess> itr = list.getListPairProcess().listIterator();
		PairProcess tmp;
		
		while (itr.hasNext())
		{
			tmp = itr.next();
			state1 = tmp.getNode1().getNodeName();
			state2 = tmp.getNode2().getNodeName();
			
			for(int j = 0; j < partition.size(); j++)
			{
				boolean flag1 = partition.getPartition().get(j).contains(state1);
				boolean flag2 = partition.getPartition().get(j).contains(state2);
				if(flag1 && flag2)
					break;
				if(flag1 && flag2 == false)
				{
					partition.getPartition().get(j).addState(state2);
					break;
				}
				
				if(flag1 == false && flag2)
				{
					partition.getPartition().get(j).addState(state1);
					break;
				}
				
				if(j + 1 == partition.size())
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
		ListIterator<Block> it = partition.listIterator();
		Block tmp;
		while (it.hasNext())
		{
			tmp = it.next();
			//if (tmp.size()>1){
			sb.append(tmp);
			//}
			if (it.hasNext())
				sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
