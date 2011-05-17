package ii.edu.mk.bisimulation;

public class PostTransition implements Comparable<PostTransition> {
	private String postProcess;
	private String action;
	private String color;

	public PostTransition(String postProcess, String action) {
		this.postProcess = postProcess;
		this.action = action;
		color = "white";
	}

	public void setPostProcess(String postProcess) {
		this.postProcess = postProcess;
	}

	public String getPostProcess() {
		return postProcess;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	@Override
	public int compareTo(PostTransition pt1) {
		return this.getAction().compareTo(pt1.getAction());
	}

	public String toString() {
		return "(" + action + ", " + postProcess + ")";
	}
}
