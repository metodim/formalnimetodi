package ii.edu.mk.bisimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//remove this class when this test are converted into unit tests
public class MainClass {

	public static void main(String[] args) {

		System.out.println("\n####################################################");
		System.out.println("#                                                  #");
		System.out.println("# STRONG BISIMULATION MINIMISATION AND EQUIVALENCE #");
		System.out.println("#                                                  #");
		System.out.println("####################################################\n");

		System.out.println("=====/ EXAMPLE 1 /=====\n");

		System.out.println("Graph1:");
		Graph graph1 = generateGraph("lts002.aut");
		System.out.println(graph1);

		Graph graph11 = new Graph(graph1);
		Graph graph12 = new Graph(graph1);

		System.out.println("Graph2:");
		Graph graph2 = generateGraph("lts007.aut");
		System.out.println(graph2);

		Graph graph21 = new Graph(graph2);
		Graph graph22 = new Graph(graph2);

		System.out.println("\n1) Minimisation using standard bisimulation algorithm\n");

		ListPairProcess L1 = graph11.findMaximumBisimulationNaive();
		System.out.println("Pairs of bisimilar states in Graph1: " + L1);
		System.out.println();
		graph11.minimizationGraph(L1);
		System.out.println("Minimised Graph1:");
		System.out.println(graph11);

		ListPairProcess L2 = graph21.findMaximumBisimulationNaive();
		System.out.println("Pairs of bisimilar states in Graph2: " + L2);
		System.out.println();
		graph21.minimizationGraph(L2);
		System.out.println("Minimised Graph2:");
		System.out.println(graph21);

		System.out.println("Are the two graphs strongly bisimilar?");
		System.out.println(graph11.equalGraph(graph11.getInitialNode(), graph21, graph21.getInitialNode()));

		System.out.println("\n\n2) Minimisation using Fernandez bisimulation algorithm\n");

		Partition P1 = graph12.findMaximumBisimulationFernandez();
		System.out.println("Sets of mutually bisimilar states in Graph1: " + P1);
		System.out.println();
		graph12.minimizationGraph(P1);
		System.out.println("Minimised Graph1:");
		System.out.println(graph12);

		Partition P2 = graph22.findMaximumBisimulationFernandez();
		System.out.println("Sets of mutually bisimilar states in Graph2: " + P2);
		System.out.println();
		graph22.minimizationGraph(P2);
		System.out.println("Minimised Graph2:");
		System.out.println(graph22);

		System.out.println("Are the two graphs strongly bisimilar?");
		System.out.println(graph12.equalGraph(graph12.getInitialNode(), graph22, graph22.getInitialNode()));

		System.out.println("\n***********************\n");

		System.out.println("=====/ EXAMPLE 2 /=====\n");

		System.out.println("Graph3:");
		Graph graph3 = generateGraph("lts006.aut");
		System.out.println(graph3);

		Graph graph31 = new Graph(graph3);
		Graph graph32 = new Graph(graph3);

		System.out.println("Graph4:");
		Graph graph4 = generateGraph("lts008.aut");
		System.out.println(graph4);

		Graph graph41 = new Graph(graph4);
		Graph graph42 = new Graph(graph4);

		System.out.println("\n1) Minimisation using standard bisimulation algorithm\n");

		ListPairProcess L3 = graph31.findMaximumBisimulationNaive();
		System.out.println("Pairs of bisimilar states in Graph3: " + L3);
		System.out.println();
		graph31.minimizationGraph(L3);
		System.out.println("Minimised Graph3:");
		System.out.println(graph31);

		ListPairProcess L4 = graph41.findMaximumBisimulationNaive();
		System.out.println("Pairs of bisimilar states in Graph4: " + L4);
		System.out.println();
		graph41.minimizationGraph(L4);
		System.out.println("Minimised Graph4:");
		System.out.println(graph41);

		System.out.println("Are the two graphs strongly bisimilar?");
		System.out.println(graph31.equalGraph(graph31.getInitialNode(), graph41, graph41.getInitialNode()));

		System.out.println("\n\n2) Minimisation using Fernandez bisimulation algorithm\n");

		Partition P3 = graph32.findMaximumBisimulationFernandez();
		System.out.println("Sets of mutually bisimilar states in Graph3: " + P3);
		System.out.println();
		graph32.minimizationGraph(P3);
		System.out.println("Minimised Graph3:");
		System.out.println(graph32);

		Partition P4 = graph42.findMaximumBisimulationFernandez();
		System.out.println("Sets of mutually bisimilar states in Graph4: " + P4);
		System.out.println();
		graph42.minimizationGraph(P4);
		System.out.println("Minimised Graph4:");
		System.out.println(graph42);

		System.out.println("Are the two graphs strongly bisimilar?");
		System.out.println(graph32.equalGraph(graph32.getInitialNode(), graph42, graph42.getInitialNode()));

		System.out.println("\n***********************\n");

	}

	//should only be used for testing purposes
	public static Graph generateGraph(String filename) {
		return generateGraphFromFile(new File("test/ii/resources/"+filename));
	}
	
	public static Graph generateGraphFromFile(File file){
		Graph graph = new Graph();
		try {
			Scanner scanner = new Scanner(file);

			String descriptor = scanner.nextLine();
			String des = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));

			String[] desElements = des.split(", ");
			String start = desElements[0];
			int numberTransitions = Integer.parseInt(desElements[1]);
			int numberStates = Integer.parseInt(desElements[2]);

			Node nodes[] = new Node[numberStates];
			nodes[0] = new Node(start);
			graph.addNode(nodes[0]);

			for (int i = 1; i <= numberTransitions; i++) {
				String edge = scanner.nextLine();
				String ed = edge.substring(edge.indexOf('(') + 1, edge.indexOf(')'));

				String[] edgeElements = ed.split(", ");
				String node1 = edgeElements[0];
				String action = edgeElements[1];
				String node2 = edgeElements[2];

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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return graph;
	}
	

}
