package ii.edu.mk.ccs;

import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsSynch;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SosTransformer {

	/**
	 * Returns an {@link SosGraphNode} oriented graph, from a
	 * {@link CcsOperation} tree.
	 * 
	 * @param root
	 *            the root of the tree
	 */
	public SosGraphNode buildSosGraph(SosGraphNode graph) {

		int i = 1;
		for (SosRule rule : applySosTransformations(graph.ccsTree))
			graph.getTransitions().put(rule, new SosGraphNode(graph.name + "." + i++, rule.getCcsOpNext()));

		buildGraph(graph);

		return graph;
	}

	private void buildGraph(SosGraphNode graph) {
		for (SosGraphNode next : graph.transitions.values()) {
			int i = 1;
			for (SosRule rule : applySosTransformations(next.ccsTree)) {
				SosGraphNode nextNode = new SosGraphNode(next.name + "." + i++, rule.getCcsOpNext());
				next.getTransitions().put(rule, nextNode);
				buildSosGraph(nextNode);
			}
		}
	}

	private List<SosRule> applySosTransformations(CcsOperation tree) {

		switch (tree.getType()) {

		case ADDITION:
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
						synchRules.add(new SosRule(SosRuleType.COM3, tree, new CcsSynch(ruleLeft.ccsOpNext, ruleRight.ccsOpNext), CcsAction.TAU));

			return synchRules;

		case TRANSITION:
			final CcsTrans trans = (CcsTrans) tree;
			// ACT: a.A -> A
			return Arrays.asList(new SosRule(SosRuleType.ACT, trans, trans.getRight(), trans.getAction()));

		case PROCESS:
			final CcsProcess process = (CcsProcess) tree;
			// TODO: Implement this
			return Collections.emptyList();

		default:
			throw new IllegalArgumentException(String.format("tree.getType()=%s is not recognized !", tree.getType().toString()));
		}
	}
}
