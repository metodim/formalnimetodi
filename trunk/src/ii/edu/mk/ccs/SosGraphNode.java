package ii.edu.mk.ccs;

import ii.edu.mk.ccs.domain.base.CcsOperation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents an oriented graph of transitions between {@link CcsOperation}s. A
 * node is a {@link CcsOperation} and an edge is a transition representing the
 * execution of an {@link SosRule} between the current and the next node.
 * 
 * <br/>
 * <br/>
 * 
 * A transition means that some action from the ccsTree is triggered with a
 * certain SOS rule. The action, the sos rule type and the operation on which
 * the action is activated are in {@link SosRule} which is the map key. <br/>
 * The value of the map is another {@link SosGraphNode} with a new
 * {@link CcsOperation} that is produced after the action is executed on the
 * current {@link CcsOperation} (in the current {@link SosGraphNode}).
 * 
 * @author dragan
 * 
 */
public class SosGraphNode {

	final Map<SosRule, SosGraphNode> transitions;

	final CcsOperation ccsTree;
	final String ccsTreeHash;
	final String name;
	int orderNo;
	final boolean isForestRoot;

	// beware mutable state
	boolean isBuilt;

	public SosGraphNode(String name, CcsOperation ccsTree, int orderNo, boolean isForestRoot) {
		super();
		this.ccsTree = ccsTree;
		this.ccsTreeHash = null; // TODO compute this
		this.name = name;
		this.orderNo = orderNo;
		this.isForestRoot = isForestRoot;
		isBuilt = false;

		/**
		 * We use a linked hash map to keep the order of the keys and values in
		 * the map that other methods like getTransitions() use.
		 */
		this.transitions = new LinkedHashMap<SosRule, SosGraphNode>();
	}

	/**
	 * Returns a map of <{@link SosRule}, {@link SosGraphNode}> key and value
	 * pairs. The map represents the edges between the nodes in the oriented
	 * graph.
	 */
	public Map<SosRule, SosGraphNode> getTransitions() {
		return transitions;
	}

	public Collection<SosGraphNode> getChildNodes() {
		return getTransitions().values();
	}

	public String getName() {
		return name;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public CcsOperation getCcsTree() {
		return ccsTree;
	}

	public String getCcsTreeHash() {
		return ccsTreeHash;
	}

	public boolean isForestRoot() {
		return isForestRoot;
	}

	public boolean isBuilt() {
		return isBuilt;
	}

	public void setBuilt(boolean isBuilt) {
		this.isBuilt = isBuilt;
	}
}
