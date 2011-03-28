package ii.edu.mk.parser;

import static ii.edu.mk.parser.Ccs2Parser.ADD;
import static ii.edu.mk.parser.Ccs2Parser.PROCESS;
import static ii.edu.mk.parser.Ccs2Parser.CO_LABEL;
import static ii.edu.mk.parser.Ccs2Parser.LABEL;
import static ii.edu.mk.parser.Ccs2Parser.RENAME;
import static ii.edu.mk.parser.Ccs2Parser.RENAME_CLAUSE;
import static ii.edu.mk.parser.Ccs2Parser.RESTRICT;
import static ii.edu.mk.parser.Ccs2Parser.RESTRICT_LABELS;
import static ii.edu.mk.parser.Ccs2Parser.SYNC;
import static ii.edu.mk.parser.Ccs2Parser.TAU;
import static ii.edu.mk.parser.Ccs2Parser.TRANSITION;
import static ii.edu.mk.parser.Ccs2Parser.RENAME_SINGLE;
import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsRename;
import ii.edu.mk.ccs.domain.CcsRestrict;
import ii.edu.mk.ccs.domain.CcsSynch;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.CcsOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class ASTDomainBuilder {

	private CommonTree getAstFromExpression(String expression)
			throws RecognitionException {
		Ccs2Lexer lex = new Ccs2Lexer(new ANTLRStringStream(expression));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Ccs2Parser parser = new Ccs2Parser(tokens);
		return (CommonTree) parser.expr().getTree();
	}

	public CcsOperation getRoot(String expression) throws Exception {
		return (CcsOperation) getDomain(getAstFromExpression(expression));
	}

	private CcsOperator getDomain(Tree node) throws IllegalArgumentException {

		switch (node.getType()) {

		case ADD:
			return new CcsAdd((CcsOperation) getDomain(node.getChild(0)),
					(CcsOperation) getDomain((CommonTree) node.getChild(1)));

		case SYNC:
			return new CcsSynch((CcsOperation) getDomain(node.getChild(0)),
					(CcsOperation) getDomain(node.getChild(1)));

		case RESTRICT:
			return new CcsRestrict((CcsOperation) getDomain(node.getChild(0)),
					getRestrictActions(node.getChild(1)));

		case RENAME:
			return new CcsRename((CcsOperation) getDomain(node.getChild(0)),
					getRenameMap(node.getChild(1)));

			// Action = TAU | CO_LABEL | LABEL
		case TAU:
			return CcsAction.TAU;

		case LABEL:
			return new CcsAction(node.getText());

		case CO_LABEL:
			return new CcsAction(node.getText(), true);

		case TRANSITION:
			return new CcsTrans((CcsAction) getDomain(node.getChild(0)),
					(CcsOperation) getDomain(node.getChild(1)));

		case PROCESS:
			return new CcsProcess(node.getText());

		default:
			throw new IllegalArgumentException(
					"Should not be here node.getType()=" + node.getType());
		}
	}

	private List<CcsAction> getRestrictActions(Tree node) {

		if (node.getType() != RESTRICT_LABELS)
			throw new IllegalArgumentException(
					"node.type must be RESTRICT_LABELS !");

		List<CcsAction> restrictActions = new ArrayList<CcsAction>();

		for (int i = 0; i < node.getChildCount(); i++) {
			if (node.getChild(i).getType() != LABEL
					&& node.getChild(i).getType() != CO_LABEL
					&& node.getChild(i).getType() != TAU)
				throw new IllegalArgumentException(
						"node type must be LABEL, CO_LABEL or TAU !");

			restrictActions.add((CcsAction) getDomain(node.getChild(i)));
		}

		return restrictActions;
	}

	private Map<CcsAction, CcsAction> getRenameMap(Tree node) {

		if (node.getType() != RENAME_CLAUSE)
			throw new IllegalArgumentException(
					"node.type must be RENAME_CLAUSE !");

		Map<CcsAction, CcsAction> renameMap = new HashMap<CcsAction, CcsAction>();

		for (int i = 0; i < node.getChildCount(); i++) {
			Tree renameSingle = node.getChild(i);

			if (renameSingle.getType() != RENAME_SINGLE)
				throw new IllegalArgumentException(
						"renameSingle node type must be RENAME_SINGLE !");

			if (renameSingle.getChildCount() != 2)
				throw new IllegalArgumentException(
						"renameSingle node must have exactly 2 children !");

			renameMap.put((CcsAction) getDomain(renameSingle.getChild(0)),
					(CcsAction) getDomain(renameSingle.getChild(1)));
		}

		return renameMap;
	}
}
