package ii.edu.mk.ccs.domain.base;

public abstract class CcsUnaryOperation<OPERAND extends CcsOperator> extends
		CcsOperation {

	private final OPERAND operand;

	public CcsUnaryOperation(OPERAND operand) {
		super();
		this.operand = operand;
	}

	public OPERAND getOperand() {
		return operand;
	}

}
