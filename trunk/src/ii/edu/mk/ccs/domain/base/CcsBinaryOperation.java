package ii.edu.mk.ccs.domain.base;

public abstract class CcsBinaryOperation<LEFT extends CcsOperator, RIGHT extends CcsOperator>
		extends CcsOperation {

	private final LEFT left;
	private final RIGHT right;

	public CcsBinaryOperation(LEFT left, RIGHT right) {
		super();
		this.left = left;
		this.right = right;
	}

	public LEFT getLeft() {
		return left;
	}

	public RIGHT getRight() {
		return right;
	}

}
