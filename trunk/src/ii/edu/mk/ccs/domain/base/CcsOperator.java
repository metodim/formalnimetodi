package ii.edu.mk.ccs.domain.base;

public abstract class CcsOperator {

	public abstract OperatorType getType();

	public String getName() {
		return getType().name();
	}
}
