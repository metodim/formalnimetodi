package ii.edu.mk.bisimulation;

import java.util.Comparator;

public class SortPostTransition implements Comparator<PostTransition> {

	public int compare(PostTransition arg0, PostTransition arg1) {
		return arg0.getAction().compareTo(arg1.getAction());
	}
}