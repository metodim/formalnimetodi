package ii.edu.mk.ccs;

public enum SosRuleType {

	/**
	 * a.A -> A
	 */
	ACT,

	/**
	 * a.A + b.B -> A or a.A + b.B -> B
	 */
	SUM,

	/**
	 * a.A | b.B -> A | b.B
	 */
	COM1,

	/**
	 * a.A | b.B -> a.A | B
	 */
	COM2,

	/**
	 * a.A | b.B (tau) -> A | B
	 */
	COM3,

	RES,

	REL,

	/**
	 * A -a-> B, if A = a.B
	 */
	CON

}
