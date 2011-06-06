package ii.edu.mk.io;

import ii.edu.mk.bisimulation.CoupleTransition;
import ii.edu.mk.bisimulation.Graph;
import ii.edu.mk.bisimulation.Node;
import ii.edu.mk.bisimulation.PostTransition;
import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.io.AldebaranFile.AldebaranFileLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AldebaranUtils {

	private final static Logger LOG = LogManager.getLogger(AldebaranUtils.class);
	
	public static AldebaranFile readFile(File file) throws IOException {
		AldebaranFile aldebaranFile = new AldebaranFile();

		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

		String line = bufReader.readLine(); // aldebaran descriptor
		aldebaranFile.readDescriptor(line);
		while ((line = bufReader.readLine()) != null) {
			aldebaranFile.parseLine(line);
		}

		bufReader.close();
		return aldebaranFile;
	}

	public static void writeFile(AldebaranFile aldebaranFile, File file) throws IOException {
		if(file.createNewFile()){
			LOG.debug("Created a new file: " + file.getName());
		} else {
			LOG.debug("Rewriting existing file: " + file.getName());
		}

		BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, false));

		bufWriter.write(aldebaranFile.getDescriptor());
		for (AldebaranFileLine line : aldebaranFile.getLines()) {
			bufWriter.newLine();
			bufWriter.write(line.toString());
		}
		bufWriter.write("\n");
		bufWriter.flush();
		bufWriter.close();
	}

	public static AldebaranFile convert(SosGraphNode rootNode) {
		AldebaranFile aldebaranFile = new AldebaranFile();

		LinkedList<SosGraphNode> queue = new LinkedList<SosGraphNode>();
		LinkedList<SosGraphNode> visitedNodes = new LinkedList<SosGraphNode>();
		// LinkedList<SosRule> doneActions = new LinkedList<SosRule>();

		int numberOfStates = 0;
		int numberOfTransitions = 0;
		queue.addLast(rootNode);

		while (!queue.isEmpty()) {
			SosGraphNode node = queue.removeFirst();
			if (visitedNodes.contains(node))
				continue;
			numberOfStates++;

			for (Map.Entry<SosRule, SosGraphNode> entry : node.getTransitions().entrySet()) {
				SosRule rule = entry.getKey();
				SosGraphNode toNode = entry.getValue();

				aldebaranFile.addLine(node.getOrderNo(), rule.getAction().getName(), toNode.getOrderNo());
				numberOfTransitions++;

				if (!visitedNodes.contains(toNode)) {
					queue.addLast(toNode);
				}
			}

			visitedNodes.add(node);
		}
		aldebaranFile.setFirstState(rootNode.getOrderNo());
		aldebaranFile.setNumberOfStates(numberOfStates);
		aldebaranFile.setNumberOfTransitions(numberOfTransitions);
		return aldebaranFile;
	}

	public static Graph generateGraph(File file) {
		try {
			return generateGraphFromAldebaranFile(AldebaranUtils.readFile(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Graph generateGraphFromAldebaranFile(AldebaranFile alFile) {
		Graph graph = new Graph();

		String start = alFile.getFirstState().toString();

		Node nodes[] = new Node[alFile.getNumberOfStates()];
		nodes[0] = new Node(start);
		graph.addNode(nodes[0]);

		for (AldebaranFileLine line : alFile.getLines()) {
			String node1 = line.getStartState().toString();
			String action = line.getLabel();
			String node2 = line.getEndState().toString();

			graph.addAction(action);

			int state1 = Integer.parseInt(node1);
			int state2 = Integer.parseInt(node2);

			if (nodes[state1] == null) {
				nodes[state1] = new Node(node1);
				nodes[state1].addPostTransition(new PostTransition(node2, action));
				graph.addNode(nodes[state1]);
			} else {
				Node n1 = graph.getNodeByProcess(node1);
				n1.addPostTransition(new PostTransition(node2, action));
			}

			if (nodes[state2] == null) {
				nodes[state2] = new Node(node2);
				nodes[state2].addCoupleInverseTransition(new CoupleTransition(action, node1));
				graph.addNode(nodes[state2]);
			} else {
				Node n2 = graph.getNodeByProcess(node2);
				n2.addCoupleInverseTransition(new CoupleTransition(action, node1));
			}
		}

		Node tmp = graph.getNodeByProcess(start);
		graph.setInitialNode(tmp);

		return graph;
	}

	// sync writeFile and toString to work with a stream ??
	public static String toString(AldebaranFile aldebaranFile, boolean newline) {
		StringWriter writer = new StringWriter();
		writer.write(aldebaranFile.getDescriptor());
		if (newline)
			writer.write("\n");
		for (AldebaranFileLine line : aldebaranFile.getLines()) {
			writer.write(line.toString());
			if (newline)
				writer.write("\n");
		}
		writer.flush();
		return writer.getBuffer().toString();
	}

}
