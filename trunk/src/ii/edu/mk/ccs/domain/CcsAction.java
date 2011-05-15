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

	@Override
	public String toString() {
		return name;
	}

	public boolean canSynchWith(CcsAction action) {
		return this.coLabel == !action.coLabel && this.name.equals(action.name.substring(1));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CcsAction other = (CcsAction) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
