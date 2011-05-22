package ii.edu.mk.saturation;

public class Transition {
	private int startState;
	private String label;
	private int endState;
	private volatile int hashCode = 0;

	private Transition(int startState, String label, int endState) {
		this.startState = startState;
		this.label = label;
		this.endState = endState;
	}
	
	public static Transition fromString(String line) {
		String[] comps = line.split(",+");
		int stState = Integer.parseInt(comps[0].split("\\(")[1].replaceAll(" +", ""));
		int enState = Integer.parseInt(comps[2].split("\\)")[0].replaceAll(" +", ""));
		String label = comps[1].replaceAll(" +", "");
		return new Transition(stState, label, enState);
	}

	public static Transition fromTriple(int startState, String label, int endState) {
		return new Transition(startState, label, endState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Transition)) {
			return false;
		}
		Transition edge = (Transition) obj;
		return startState == edge.startState && 
					endState == edge.endState && label.equals(edge.label);
	}

	@Override
	public int hashCode() {
		final int multiplier = 23;
		if (hashCode == 0) {
			int code = 133;
			code = multiplier * code + startState;
			code = multiplier * code + endState;
			code = multiplier * code + label.hashCode();
			hashCode = code;
		}
		return hashCode;
	}

	public int getStartState() {
		return startState;
	}

	public void setStartState(int startState) {
		this.startState = startState;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getEndState() {
		return endState;
	}

	public void setEndState(int endState) {
		this.endState = endState;
	}
	
}
