package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.CcsUnaryOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.Map;

public class CcsRename extends CcsUnaryOperation<CcsOperation> {

	/**
	 * <Action,String> pairs where Action.name is be changed with the map value.
	 */
	private final Map<CcsAction, CcsAction> renameMap;

	public CcsRename(CcsOperation operand, Map<CcsAction, CcsAction> renameMap) {
		super(operand);
		this.renameMap = renameMap;
	}

	public Map<CcsAction, CcsAction> getRenameMap() {
		return renameMap;
	}

	@Override
	public OperatorType getType() {
		return OperatorType.RENAMING;
	}
}
