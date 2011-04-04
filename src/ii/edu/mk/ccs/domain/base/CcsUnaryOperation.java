package ii.edu.mk.ccs.domain.base;

import java.util.Arrays;
import java.util.Iterator;

public abstract class CcsUnaryOperation<OPERAND extends CcsOperation> extends
		CcsOperation {

	private final OPERAND operand;

	public CcsUnaryOperation(OPERAND operand) {
		super();
		this.operand = operand;
	}

	public OPERAND getOperand() {
		return operand;
	}

	@Override
	public Iterator<CcsOperation> iterator() {
		return Arrays.asList((CcsOperation) getOperand()).iterator();
	}
}
