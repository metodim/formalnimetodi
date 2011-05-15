package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.CcsUnaryOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

import java.util.List;

public class CcsRestrict extends CcsUnaryOperation<CcsOperation> {

	private final List<CcsAction> restrictedActions;

	public CcsRestrict(CcsOperation operand, List<CcsAction> restrictedActions) {
		super(operand);
		this.restrictedActions = restrictedActions;
	}

	public List<CcsAction> getRestrictedActions() {
		return restrictedActions;
	}

	@Override
	public OperatorType getType() {
		return OperatorType.RESTRICTION;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(getOperand().toString());
		sb.append(")");
		sb.append("\\{");
		for (CcsAction action : restrictedActions) {
			sb.append(action.toString());
			sb.append(",");
		}
		
		sb.replace(sb.length() - 1, sb.length(), "");
		sb.append("}");
		return sb.toString();
	}
}
