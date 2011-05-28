package ii.edu.mk.io;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vladimir Carevski
 */
public class AldebaranFile {

	private static final Pattern pattern 
			= Pattern.compile("\\(\\s*([0-9]+)\\s*,\\s*(.*?)\\s*,\\s*([0-9]+)\\s*\\)");
	
	private Integer firstState;
	private Integer numberOfTransitions;
	private Integer numberOfStates;

	private List<AldebaranFileLine> lines = new LinkedList<AldebaranFileLine>();
	
	public void setFirstState(Integer firstState) {
		this.firstState = firstState;
	}

	public Integer getFirstState() {
		return firstState;
	}

	public void setNumberOfTransitions(Integer numberOfTransitions) {
		this.numberOfTransitions = numberOfTransitions;
	}

	public Integer getNumberOfTransitions() {
		return numberOfTransitions;
	}

	public void setNumberOfStates(Integer numberOfStates) {
		this.numberOfStates = numberOfStates;
	}

	public Integer getNumberOfStates() {
		return numberOfStates;
	}

	public void setLines(List<AldebaranFileLine> lines) {
		this.lines = lines;
	}

	public List<AldebaranFileLine> getLines() {
		return lines;
	}

	public void readDescriptor(String desc) {
		if (desc == null || !desc.startsWith("des") || desc.isEmpty())
			throw new IllegalArgumentException("Illegal argument for aldebaran descriptor");

		String lines[] = desc.split(",+");
		firstState = Integer.parseInt(lines[0].split("\\(")[1].replaceAll(" +", ""));
		numberOfTransitions = Integer.parseInt(lines[1].replaceAll(" +", ""));
		numberOfStates = Integer.parseInt(lines[2].split("\\)")[0].replaceAll(" +", ""));
	}

	public String getDescriptor() {
		return "des (0, " + numberOfTransitions + ", " + numberOfStates + ")";
	}

	public void parseLine(String line) {
		if (line == null || line.isEmpty())
			throw new IllegalArgumentException("Illegal argument for aldebaran descriptor");

		lines.add(AldebaranFileLine.fromString(line));
	}

	public void addLine(int startState, String label, int endState) {
		lines.add(new AldebaranFileLine(startState, label, endState));
	}

	public void addLine(String startState, String label, String endState) {
		addLine(Integer.parseInt(startState), label, Integer.parseInt(endState));
	}

	public void addLine(Integer startState, String label, Integer endState) {
		lines.add(new AldebaranFileLine(startState, label, endState));
	}

	public static class AldebaranFileLine {
		private Integer startState;
		private Integer endState;
		private String label;

		public AldebaranFileLine(Integer startState, String label, Integer endState) {
			this.startState = startState;
			this.label = label;
			this.endState = endState;
		}

		public Integer getStartState() {
			return startState;
		}

		public Integer getEndState() {
			return endState;
		}

		public String getLabel() {
			return label;
		}

		public String toString() {
			return "(" + startState + ", " + label + ", " + endState + ")";
		}

		public static AldebaranFileLine fromString(String line) {
			Matcher matcher = pattern.matcher(line);
			if(!matcher.matches()) {throw new IllegalArgumentException("illegal format for aldebaran file line");};
			Integer start = Integer.parseInt(matcher.group(1));
			String label = matcher.group(2).replaceAll(" ", "");
			Integer end = Integer.parseInt(matcher.group(3));
			if(label.trim().isEmpty()){throw new IllegalArgumentException("can not have empty labels in transitions");}
			return new AldebaranFileLine(start, label, end);
		}
	}
}