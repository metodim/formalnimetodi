package ii.edu.mk.bisimulation;

import java.util.LinkedList;

public class Partition {
	private LinkedList<Block> partition;

	public Partition() {
		partition = new LinkedList<Block>();
	}

	public void setPartition(LinkedList<Block> blocks) {
		partition = blocks;
	}

	public LinkedList<Block> getPartition() {
		return partition;
	}

	public void addBlock(Block block) {
		partition.add(block);
	}

	public Partition constructI(Block B) {
		Partition tmp = new Partition();
		for (int i = 0; i < this.partition.size(); i++) {
			Block X = this.partition.get(i);
			boolean found = false;
			int j = 0;
			// presek pomegju block i inverseT
			while (!found && j < X.getStates().size()) {
				String s = X.getStates().get(j);
				if (B.getStates().contains(s)) {
					found = true;
				}
				j++;
			}
			if (found)
				tmp.addBlock(X);
		}
		return tmp;
	}

	public Partition constructI2(Block B) {
		Partition tmp = new Partition();
		for (int i = 0; i < this.partition.size(); i++) {
			Block X = this.partition.get(i);
			boolean subset = true;
			for (int j = 0; j < X.getStates().size(); j++) {
				if (!B.getStates().contains(X.getStates().get(j))) {
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

	public String toString() {
		String s = "";
		for (int i = 0; i < partition.size(); i++) {
			s += partition.get(i);
			if (i != partition.size() - 1)
				s += ", ";
		}
		return s;
	}
}
