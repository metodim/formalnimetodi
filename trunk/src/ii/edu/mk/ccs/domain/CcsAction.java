package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsOperator;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsAction extends CcsOperator {

	private final String name;

	private final boolean tau;

	private final boolean coLabel;

	public static final CcsAction TAU = new CcsAction("tau", true, false);

	public CcsAction(String name) {
		this(name, false);
	}

	public CcsAction(String name, boolean coLabel) {
		this(name, false, coLabel);
	}

	private CcsAction(String name, boolean tau, boolean coLabel) {
		super();
		this.name = name;
		this.tau = tau;
		this.coLabel = coLabel;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OperatorType getType() {
		return OperatorType.ACTION;
	}

	public boolean isTau() {
		return tau;
	}

	public boolean isCoLabel() {
		return coLabel;
	}

}
