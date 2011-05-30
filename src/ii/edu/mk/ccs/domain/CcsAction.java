package ii.edu.mk.ccs.domain;

import ii.edu.mk.ccs.domain.base.CcsOperator;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsAction extends CcsOperator {

	private final String name;

	private final boolean tau;

	private final boolean isReverseAction;

	public static final CcsAction TAU = new CcsAction("tau", true, false);

	public static final String REVERSE_ACTION_PREFIX = "_";

	public static CcsAction newTau(String name) {
		return new CcsAction(name, true, false);
	}

	public CcsAction(String name) {
		this(name, false);
	}

	public CcsAction(String name, boolean isReverseAction) {
		this(name, false, isReverseAction);
	}

	private CcsAction(String name, boolean tau, boolean isReverseAction) {
		super();
		this.name = name;
		this.tau = tau;
		this.isReverseAction = isReverseAction;
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

	public boolean isReverseAction() {
		return isReverseAction;
	}

	public CcsAction getReverseAction() {
		if (!isReverseAction)
			return new CcsAction(REVERSE_ACTION_PREFIX + name, false);

		return new CcsAction(name.substring(REVERSE_ACTION_PREFIX.length()), false);
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean canSynchWith(CcsAction action) {
		if (this.isReverseAction == action.isReverseAction)
			return false;

		if (!this.isReverseAction)
			return this.name.equals(action.name.substring(REVERSE_ACTION_PREFIX.length()));

		return action.name.equals(this.name.substring(REVERSE_ACTION_PREFIX.length()));
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
