package ii.edu.mk.io;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vladimir Carevski
 */
public class AldebaranFile {

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
	
	public void readDescriptor(String desc){
		if(desc == null || !desc.startsWith("des") || desc.isEmpty())
			throw new IllegalArgumentException("Illegal argument for aldebaran descriptor");
		
		String lines[] = desc.split(",+");
		System.out.println(lines[0]);
		firstState = Integer.parseInt(lines[0].split("\\(")[1].replaceAll(" +", ""));
		numberOfTransitions = Integer.parseInt(lines[1].replaceAll(" +", ""));
		numberOfStates = Integer.parseInt(lines[2].split("\\)")[0].replaceAll(" +", ""));
	}
	
	public String getDescriptor(){
		return "des (0, " + numberOfTransitions + ", " + numberOfStates + ")";
	}
	
	public void parseLine(String line){
		if(line == null || line.isEmpty())
			throw new IllegalArgumentException("Illegal argument for aldebaran descriptor");
		
		lines.add(AldebaranFileLine.fromString(line));
	}
	
	public void addLine(String startState, String label, String endState){
		lines.add(new AldebaranFileLine(Integer.parseInt(startState), label, Integer.parseInt(endState)));
	}
	
	public void addLine(Integer startState, String label, Integer endState){
		lines.add(new AldebaranFileLine(startState, label, endState));
	}
	
	public static class AldebaranFileLine{
		private Integer startState;
		private Integer endState;
		private String label;
		
		public AldebaranFileLine(Integer startState, String label, Integer endState) {
			this.startState = startState;this.label = label;this.endState = endState;
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
		
		public String toString(){
			return "("+startState+", "+label+", "+endState+")";
		}
		
		public static AldebaranFileLine fromString(String line){
			String[] comps = line.split(",+");
			Integer start = Integer.parseInt(comps[0].split("\\(")[1].replaceAll(" +", ""));
			Integer end = Integer.parseInt(comps[2].split("\\)")[0].replaceAll(" +", ""));
			return new AldebaranFileLine(start, comps[1].replaceAll(" +", ""), end);
		}
	}
}