package ii.edu.mk.ccs.domain;

import java.util.Arrays;
import java.util.Iterator;

import ii.edu.mk.ccs.domain.base.CcsBinaryOperation;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsDefinition extends CcsBinaryOperation<CcsProcess, CcsOperation> {

	public CcsDefinition(CcsProcess left, CcsOperation right) {
		super(left, right);
	}

	@Override
	public OperatorType getType() {
		return OperatorType.DEFINITION;
	}

	@Override
	public Iterator<CcsOperation> iterator() {
		return Arrays.asList(getLeft(), getRight()).iterator();
	}

}
