package ii.edu.mk.utils;

import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsDefinition;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsRename;
import ii.edu.mk.ccs.domain.CcsRestrict;
import ii.edu.mk.ccs.domain.CcsSynch;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperator;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.LinkedList;
import java.util.Map;

/**
 * Playground
 * 
 * @author Vladimir Carevski
 */
public class ASTMarshaler {

	private static final CcsPar openPar = new CcsPar("(");
	private static final CcsPar closePar = new CcsPar(")");

	public static String marshal(CcsOperator root) {
		LinkedList<CcsOperator> stack = new LinkedList<CcsOperator>();
		stack.addLast(closePar);
		stack.addLast(root);
		stack.addLast(openPar);

		StringBuilder builder = new StringBuilder();

		while (!stack.isEmpty()) {
			CcsOperator node = stack.removeLast();

			if (openPar.equals(node)) {
				builder.append(openPar.getPar());
				continue;
			}

			if (closePar.equals(node)) {
				builder.append(closePar.getPar());
				continue;
			}

			if (node instanceof CcsAction) {
				builder.append(cast(node, CcsAction.class).getName());
				continue;
			}

			if (node instanceof CcsProcess) {
				builder.append(cast(node, CcsProcess.class).getName());
				continue;
			}

			if (node instanceof CcsDefinition) {
				builder.append("=");
				stack.addLast(closePar);
				stack.addLast(cast(node, CcsDefinition.class).getLeft());
				stack.addLast(openPar);

				stack.addLast(closePar);
				stack.addLast(cast(node, CcsDefinition.class).getRight());
				stack.addLast(openPar);
				continue;
			}

			if (node instanceof CcsAdd) {
				builder.append("+");
				stack.addLast(closePar);
				stack.addLast(cast(node, CcsAdd.class).getLeft());
				stack.addLast(openPar);

				stack.addLast(closePar);
				stack.addLast(cast(node, CcsAdd.class).getRight());
				stack.addLast(openPar);
				continue;
			}

			if (node instanceof CcsSynch) {
				builder.append("|");
				stack.addLast(closePar);
				stack.addLast(cast(node, CcsSynch.class).getLeft());
				stack.addLast(openPar);

				stack.addLast(closePar);
				stack.addLast(cast(node, CcsSynch.class).getRight());
				stack.addLast(openPar);
				continue;
			}

			if (node instanceof CcsTrans) {
				builder.append(".");
				stack.addLast(closePar);
				stack.addLast(cast(node, CcsTrans.class).getLeft());
				stack.addLast(openPar);

				stack.addLast(closePar);
				stack.addLast(cast(node, CcsTrans.class).getRight());
				stack.addLast(openPar);
				continue;
			}

			if (node instanceof CcsRename) {
				builder.append("*");
				for (Map.Entry<CcsAction, CcsAction> entry : cast(node, CcsRename.class).getRenameMap().entrySet()) {
					stack.addLast(closePar);
					stack.addLast(entry.getKey());
					stack.addLast(entry.getValue());
					stack.addLast(openPar);
				}
				continue;
			}

			if (node instanceof CcsRestrict) {
				builder.append("//");
				stack.addLast(closePar);
				stack.addLast(cast(node, CcsRestrict.class).getOperand());
				stack.addLast(openPar);

				stack.addLast(closePar);
				for (CcsAction ccsAction : cast(node, CcsRestrict.class).getRestrictedActions()) {
					stack.addLast(ccsAction);
				}
				stack.addLast(openPar);
			}

		}

		return builder.toString();
	}

	// mock object
	private static class CcsPar extends CcsOperator {
		String par;

		public CcsPar(String par) {
			this.par = par;
		}

		@Override
		public OperatorType getType() {
			return null;
		}

		public String getPar() {
			return par;
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends CcsOperator> T cast(Object o, Class<T> clazz) {
		return (T) o;
	}

}
