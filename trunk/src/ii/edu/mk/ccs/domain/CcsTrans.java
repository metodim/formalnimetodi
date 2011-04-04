package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsBinaryOperation;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.ArrayList;
import java.util.Iterator;

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

	@Override
	public Iterator<CcsOperation> iterator() {
		return new ArrayList<CcsOperation>().iterator();
	}

	@Override
	public String toString() {
		return String.format("%s.(%s)", getAction(), getRight());
	}
}
