package ii.edu.mk.io;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;

import java.util.LinkedList;
import java.util.Map;

public class LtsAldebaranConverter {

	
	public static AldebaranFile convert(SosGraphNode rootNode){
		AldebaranFile aldebaranFile = new AldebaranFile();
		
		LinkedList<SosGraphNode> queue = new LinkedList<SosGraphNode>();
		LinkedList<SosGraphNode> visitedNodes = new LinkedList<SosGraphNode>();
//		LinkedList<SosRule> doneActions = new LinkedList<SosRule>();
		
		queue.addLast(rootNode);
		
		while(!queue.isEmpty()){
			SosGraphNode node = queue.removeFirst();
			
			for(Map.Entry<SosRule, SosGraphNode> entry : node.getTransitions().entrySet()){
				SosRule rule = entry.getKey();
				SosGraphNode toNode = entry.getValue();
				
				aldebaranFile.addLine(node.getName(), rule.getAction().getName(), toNode.getName());
				
				if(!visitedNodes.contains(toNode)){
					queue.addLast(toNode);
				}
			}
			
			
			visitedNodes.add(node);
		}
		
		return aldebaranFile;
		
	}
	
}
