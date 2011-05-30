package ii.edu.mk.ccs;

import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsDefinition;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsRestrict;
import ii.edu.mk.ccs.domain.CcsSynch;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SosTransformer {

	private static final Logger LOG = LogManager.getLogger(SosTransformer.class);

	public static SosTransformer getInstance() {
		return new SosTransformer();
	}

	private Map<String, SosGraphNode> graphNodeNamesToGraphNodes;
	private int graphNodeOrderNo;
	
	public SosTransformer() {
		graphNodeNamesToGraphNodes = new LinkedHashMap<String, SosGraphNode>();
	}

	public SosGraphNode generateLtsGraph(CcsOperation ccsOperation) throws SosTransformerException {
		return generateLtsGraph(Arrays.asList(ccsOperation)).get(0);
	}

	public List<SosGraphNode> generateLtsGraph(CcsOperation... ccsOperations) throws SosTransformerException {
		return generateLtsGraph(Arrays.asList(ccsOperations));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SosGraphNode> generateLtsGraph(List<CcsOperation> ccsOperations) throws SosTransformerException {
		if (ccsOperations.size() > 1 && !checkCcsDefinitions(ccsOperations))
			throw new SosTransformerException("ccsOperations must be with size 1 or all operations must be CcsDefinitions");

		graphNodeOrderNo = 0;
		return buildSosGraph((List) ccsOperations);
	}

	private boolean checkCcsDefinitions(List<CcsOperation> ccsOperations) {
		for (CcsOperation rootOperation : ccsOperations) {
			if (!(rootOperation instanceof CcsDefinition))
				return false;
		}
		return true;
	}

	private List<SosGraphNode> buildSosGraph(List<CcsDefinition> ccsDefinitions) {
		List<SosGraphNode> forrest = new ArrayList<SosGraphNode>();
		for (CcsDefinition ccsDefinition : ccsDefinitions)
			forrest.add(createSosGraph(ccsDefinition));

		List<SosGraphNode> graphsToBuild = new ArrayList<SosGraphNode>();
		graphsToBuild.addAll(graphNodeNamesToGraphNodes.values());
		for (SosGraphNode graph : graphsToBuild) {
			// the graph may have been built in some previous builds
			if (!graph.isBuilt)
				buildGraph(graph);
		}

		fixOrderNumber(forrest.get(0));

		return forrest;
	}

	/**
	 * Fix the order number of the given graph starting from zero and
	 * incrementing for each chid.
	 */
	private void fixOrderNumber(SosGraphNode graph) {
		graph.setOrderNumberToGraphNode(new LinkedHashMap<Integer, SosGraphNode>());
		Set<SosGraphNode> visited = new HashSet<SosGraphNode>();
		Queue<SosGraphNode> toVisit = new LinkedList<SosGraphNode>();
		toVisit.add(graph);
		int order = 0;
		while (toVisit.size() > 0) {
			SosGraphNode current = toVisit.remove();
			visited.add(current);
			graph.getOrderNumberToGraphNode().put(order, current);
			current.setOrderNo(order++);
			for (SosGraphNode child : current.getChildNodes())
				if (!visited.contains(child)) {
					boolean found = false;
					for (SosGraphNode v : toVisit)
						if (v.getName().equals(child.getName())) {
							found = true;
							break;
						}
					if (!found)
						toVisit.add(child);
				}
		}
		graph.setTotalNodesInGraph(order);
	}



	/**
	 * Returns an {@link SosGraphNode} oriented graph, from a
	 * {@link CcsOperation} tree. The graph is not yet built
	 * 
	 * @param processName
	 *            the name of the process
	 * @param ccsTree
	 *            the CCS expression tree
	 */
	private SosGraphNode createSosGraph(CcsOperation ccsOperation) {
		SosGraphNode graph;
		graphNodeOrderNo = 0;
		if (ccsOperation instanceof CcsDefinition) {
			CcsDefinition ccsDefinition = (CcsDefinition) ccsOperation;
			graph = new SosGraphNode(ccsDefinition.getLeft().getName(), ccsDefinition.getRight(), graphNodeOrderNo++, true);
			// put the process name
			graphNodeNamesToGraphNodes.put(ccsDefinition.getLeft().getName(), graph);
			// put the ccs expression definition
			graphNodeNamesToGraphNodes.put(ccsDefinition.getRight().toString(), graph);
		} else {
			graph = new SosGraphNode("A", ccsOperation, graphNodeOrderNo++, true);
			graphNodeNamesToGraphNodes.put(ccsOperation.toString(), graph);
		}

		return graph;
	}

	/**
	 * Builds the {@link SosGraphNode}.
	 */
	private void buildGraph(SosGraphNode graph) {

		/**
		 * graph.build must be set to true before the actual built of the graph
		 * in the case the graph will reference itself in the build process,
		 * which can lead to infinite recursion.
		 */
		graph.setBuilt(true);

		int i = 1;
		for (SosRule rule : applySosTransformations(graph.ccsTree)) {
			SosGraphNode next = createNewNode(graph, i++, rule);
			// if is already an existing SosGraphNode than don't do anything
			if (!graphNodeNamesToGraphNodes.containsKey(rule.ccsOpNext.toString())) {
				graphNodeNamesToGraphNodes.put(rule.ccsOpNext.toString(), next);
				buildGraph(next);
			}
		}
	}

	/**
	 * Creates a new graph node or returns an existing SosGraphNode if the CCS
	 * expression after the transition is present in an existing SosGraphNode
	 * 
	 * @param graph
	 *            the previous graph node before the transition
	 * @param level
	 *            the level of the node
	 * @param rule
	 *            the role that is triggered
	 * @return SosGraphNode after the triggered transition
	 */
	private SosGraphNode createNewNode(SosGraphNode graph, int level, SosRule rule) {
		if (graphNodeNamesToGraphNodes.containsKey(rule.getCcsOpNext().toString())) {
			SosGraphNode n = graphNodeNamesToGraphNodes.get(rule.getCcsOpNext().toString());
			graph.getTransitions().put(rule, n);
			return n;
		}

		SosGraphNode n = new SosGraphNode(graph.name + "." + level, rule.getCcsOpNext(), graphNodeOrderNo++, false);
		graph.getTransitions().put(rule, n);
		return n;
	}

	/**
	 * Returns the possible {@link SosRule}s that can be triggered from the
	 * given {@link CcsOperation} tree
	 */
	private List<SosRule> applySosTransformations(CcsOperation tree) {

		switch (tree.getType()) {

		case ADDITION:
			LOG.debug("ADDITION");
			final CcsAdd add = (CcsAdd) tree;
			List<SosRule> addRules = new ArrayList<SosRule>();

			for (SosRule r : applySosTransformations(add.getLeft()))
				// SUM: a.A + b.B -> A
				addRules.add(new SosRule(SosRuleType.SUM, tree, r.getCcsOpNext(), r.getAction()));

			for (SosRule r : applySosTransformations(add.getRight()))
				// SUM: a.A + b.B -> B
				addRules.add(new SosRule(SosRuleType.SUM, tree, r.getCcsOpNext(), r.getAction()));

			return addRules;

		case SYNCHRONIZATION:
			LOG.debug("SYNC");
			final CcsSynch synch = (CcsSynch) tree;
			List<SosRule> synchRules = new ArrayList<SosRule>();

			for (SosRule r : applySosTransformations(synch.getLeft()))
				// COM1: a.A | b.B -> A | b.B
				synchRules.add(new SosRule(SosRuleType.COM1, tree, new CcsSynch(r.getCcsOpNext(), synch.getRight()), r.getAction()));

			for (SosRule r : applySosTransformations(synch.getRight()))
				// COM2: a.A | b.B -> a.A | B
				synchRules.add(new SosRule(SosRuleType.COM2, tree, new CcsSynch(synch.getLeft(), r.getCcsOpNext()), r.getAction()));

			for (SosRule ruleLeft : applySosTransformations(synch.getLeft()))
				for (SosRule ruleRight : applySosTransformations(synch.getRight()))
					// COM3: a.A | b.B (tau)-> A | B
					if (ruleLeft.action.canSynchWith(ruleRight.action))
						synchRules.add(new SosRule(SosRuleType.COM3, tree, new CcsSynch(ruleLeft.ccsOpNext, ruleRight.ccsOpNext), CcsAction.newTau("tau on " + ruleLeft.action.getName())));

			return synchRules;

		case TRANSITION:
			LOG.debug("TRANSITION");
			final CcsTrans trans = (CcsTrans) tree;
			// ACT: a.A -> A
			return Arrays.asList(new SosRule(SosRuleType.ACT, trans, trans.getRight(), trans.getAction()));

		case RESTRICTION:
			LOG.debug("RESTRICTION");
			final CcsRestrict restrict = (CcsRestrict) tree;
			List<SosRule> restrictRules = new ArrayList<SosRule>();

			for (SosRule ruleLeft : applySosTransformations(restrict.getOperand()))
				if (!restrict.getRestrictedActions().contains(ruleLeft.getAction())

				&& !restrict.getRestrictedActions().contains(ruleLeft.getAction().getReverseAction()))

					restrictRules.add(new SosRule(SosRuleType.RES, tree, new CcsRestrict(ruleLeft.ccsOpNext, restrict.getRestrictedActions()), ruleLeft.getAction()));

			return restrictRules;

		case PROCESS:
			LOG.debug("PROCESS");
			final CcsProcess process = (CcsProcess) tree;

			if (!graphNodeNamesToGraphNodes.containsKey(process.getName()))
				Collections.emptyList();

			List<SosRule> processRules = new ArrayList<SosRule>();
			SosGraphNode graph = graphNodeNamesToGraphNodes.get(process.getName());

			if (graph != null && !graph.isBuilt)
				buildGraph(graph);

			if (graph != null)
				processRules.addAll(graph.transitions.keySet());

			return processRules;

		case DEFINITION:
			LOG.debug("DEFINITION");
			throw new UnsupportedOperationException(OperatorType.DEFINITION + " cannot apear inside the CCS expression");

		default:
			throw new IllegalArgumentException(String.format("tree.getType()=%s is not recognized !", tree.getType().toString()));
		}
	}
}
