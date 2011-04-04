package ii.edu.mk.ccs.domain;

import java.util.Arrays;
import java.util.Iterator;

import ii.edu.mk.ccs.domain.base.CcsBinaryOperation;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsSynch extends CcsBinaryOperation<CcsOperation, CcsOperation> {

	public CcsSynch(CcsOperation left, CcsOperation right) {
		super(left, right);
	}

	@Override
	public OperatorType getType() {
		return OperatorType.SYNCHRONIZATION;
	}

	@Override
	public Iterator<CcsOperation> iterator() {
		return Arrays.asList(getLeft(), getRight()).iterator();
	}

	@Override
	public String toString() {
		return String.format("(%s)|(%s)", getLeft(), getRight());
	}
}
