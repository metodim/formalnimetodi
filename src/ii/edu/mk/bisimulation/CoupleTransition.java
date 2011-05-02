package ii.edu.mk.bisimulation;

import java.util.LinkedList;

public class CoupleTransition {
	private String action;
	private LinkedList<String> processes;

	public CoupleTransition(String action) {
		this.action = action;
		processes = new LinkedList<String>();
	}

	public CoupleTransition(String action, String process) {
		this.action = action;
		if (processes == null)
			processes = new LinkedList<String>();
		if (!processes.contains(process))
			processes.add(process);
	}

	public CoupleTransition(String action, LinkedList<String> processes) {
		this.action = action;
		this.processes = processes;
	}

	public void addProcess(String process) {
		processes.add(process);
	}

	public String getAction() {
		return action;
	}

	public LinkedList<String> getProcesses() {
		return processes;
	}

	public String toString() {
		String s = action + ", ";
		for (int i = 0; i < processes.size(); i++)
			s += processes.get(i) + " ";
		return s;
	}
}
