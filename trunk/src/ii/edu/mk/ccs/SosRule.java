package ii.edu.mk.ccs;

import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.ccs.domain.base.CcsOperation;

public class SosRule {

	final SosRuleType type;
	final CcsOperation ccsOpCurrent;
	final CcsOperation ccsOpNext;
	final CcsAction action;

	public SosRule(SosRuleType type, CcsOperation ccsOpCurrent, CcsOperation ccsOpNext, CcsAction action) {
		super();
		this.type = type;
		this.ccsOpCurrent = ccsOpCurrent;
		this.ccsOpNext = ccsOpNext;
		this.action = action;
	}

	public SosRuleType getType() {
		return type;
	}

	/**
	 * Returns the current CCS operation before the transition
	 */
	public CcsOperation getCcsOpCurrent() {
		return ccsOpCurrent;
	}

	/**
	 * Returns the next CCS operation produced from the transition
	 */
	public CcsOperation getCcsOpNext() {
		return ccsOpNext;
	}

	/**
	 * The action that is triggered for this SOS rule
	 */
	public CcsAction getAction() {
		return action;
	}

	/**
	 * Example: --[SUM,a]-->
	 */
	public String getSymbol() {
		return String.format("--[%s,%s]-->", type, action);
	}

	/**
	 * Example: a.A+B --[SUM,a]--> A
	 */
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s", ccsOpCurrent, getSymbol(), ccsOpNext);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((ccsOpCurrent == null) ? 0 : ccsOpCurrent.hashCode());
		result = prime * result + ((ccsOpNext == null) ? 0 : ccsOpNext.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SosRule other = (SosRule) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (ccsOpCurrent == null) {
			if (other.ccsOpCurrent != null)
				return false;
		} else if (!ccsOpCurrent.equals(other.ccsOpCurrent))
			return false;
		if (ccsOpNext == null) {
			if (other.ccsOpNext != null)
				return false;
		} else if (!ccsOpNext.equals(other.ccsOpNext))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
