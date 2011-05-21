package ii.edu.mk.bisimulation;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Maja Siljanoska
 */

public class CoupleTransition {
	private String action;
	private LinkedList<String> processes;
	private int processesSize;

	public CoupleTransition(String action) {
		this.action = action;
		processes = new LinkedList<String>();
		processesSize = 0;
	}

	public CoupleTransition(String action, String process) {
		this.action = action;
		if (processes == null)
		{
			processes = new LinkedList<String>();
			processesSize = 0;
		}
		if (!processes.contains(process))
		{
			processes.add(process);
			processesSize++;
		}
	}

	public CoupleTransition(String action, LinkedList<String> processes) {
		this.action = action;
		this.processes = processes;
		processesSize = processes.size();
	}

	public void addProcess(String process) {
		processes.add(process);
		processesSize++;
	}

	public String getAction() {
		return action;
	}

	public LinkedList<String> getProcesses() {
		return processes;
	}
	
	public int size()
	{
		return processesSize;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		sb.append(action);
		sb.append(", ");
		ListIterator<String> it = processes.listIterator();
		String tmp;
		sb.append("{");
		while (it.hasNext())
		{
			tmp = it.next();
			sb.append(tmp);
			if (it.hasNext())
				sb.append(", ");
		}
		sb.append("}}");
		return sb.toString();
	}
}
