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

	public CcsOperation getCcsOpCurrent() {
		return ccsOpCurrent;
	}

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
}
