package ii.edu.mk.saturation;

public class Transition {
	public int startState;
	public String label;
	public int endState;
	private volatile int hashCode = 0;

	public static Transition FromString(String line)
	{
		Transition edge = new Transition();
		String[] comps = line.split(",+");
		edge.startState = Integer.parseInt(comps[0].split("\\(")[1].replaceAll(" +", ""));
		edge.endState = Integer.parseInt(comps[2].split("\\)")[0].replaceAll(" +", ""));
		edge.label = comps[1].replaceAll(" +", "");
		return edge;
		///return new AldebaranFileLine(start, comps[1].replaceAll(" +", ""), end);
	}
	public static Transition FromTriple(int ss, String l, int es)
	{ 
		Transition edge = new Transition();
		edge.startState=ss;
		edge.label=l;
		edge.endState=es;
		return edge;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if ( this == obj)
		{
			return true;
		}
		if ( ! (obj instanceof Transition))
		{
			return false;
		}
		Transition edge = (Transition) obj;
		return startState == edge.startState && endState == edge.endState && label.equals(edge.label);
	}
	
	@Override 
	public int hashCode() {
		// TODO Auto-generated method stub
		final int multiplier=23;
		if (hashCode == 0)
		{
			int code = 133;
			code = multiplier * code + startState;
			code = multiplier * code + endState;
			code = multiplier * code + label.hashCode();
			hashCode = code;
		}
		return hashCode;
	}
}
