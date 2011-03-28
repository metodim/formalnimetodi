package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsBinaryOperation;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsTrans extends CcsBinaryOperation<CcsAction, CcsOperation> {

	public CcsTrans(CcsAction left, CcsOperation right) {
		super(left, right);
	}

	public CcsAction getAction() {
		return getLeft();
	}

	@Override
	public OperatorType getType() {
		return OperatorType.TRANSITION;
	}
}
