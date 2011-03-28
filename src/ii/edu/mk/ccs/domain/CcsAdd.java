package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsBinaryOperation;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsAdd extends CcsBinaryOperation<CcsOperation, CcsOperation> {

	public CcsAdd(CcsOperation left, CcsOperation right) {
		super(left, right);
	}

	@Override
	public OperatorType getType() {
		return OperatorType.ADDITION;
	}
}
