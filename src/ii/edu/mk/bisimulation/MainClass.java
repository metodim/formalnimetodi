package ii.edu.mk.bisimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//remove this class when this test are converted into unit tests
public class MainClass {

	public static void main(String[] args) {

		System.out.println("=====/ EXAMPLE 1 /=====\n");

		System.out.println("dining3_schedule.aut");
		Graph graph1 = generateGraph("dining3_schedule.aut");

		Graph graph11 = new Graph(graph1);
		Graph graph12 = new Graph(graph1);

		System.out.println("\n1) Minimisation using naive bisimulation algorithm\n");

		long start1 = System.currentTimeMillis();
		ListPairProcess L1 = graph11.findStrongBisimulationNaive();
		long end1 = System.currentTimeMillis();
		System.out.println("Execution time: " + (end1-start1) + " ms");
		System.out.println("Pairs of bisimilar states in Graph1: " + L1);
		System.out.println();
		
		Partition P = L1.createPartition();
		System.out.println("Sets of mutually bisimilar states in Graph1: " + P);
		graph11.minimizationGraph(P);
		System.out.println("Minimal graph has " + graph11.getNumberOfStates() + " states");
		System.out.println("Minimal graph has " + graph11.getNumberOfTransitions() + " transitions");
		//System.out.println(graph11);
		
		System.out.println("\n\n2) Minimisation using Fernandez bisimulation algorithm\n");		
		
		long start2 = System.currentTimeMillis();
		Partition P1 = graph12.findStrongBisimulationFernandez();
		long end2 = System.currentTimeMillis();
		System.out.println("Execution time: " + (end2-start2) + " ms");
		System.out.println("Sets of mutually bisimilar states in Graph1: " + P1);
		System.out.println();
		
		graph12.minimizationGraph(P1);
		System.out.println("Minimal graph has " + graph12.getNumberOfStates() + " states");
		System.out.println("Minimal graph has " + graph12.getNumberOfTransitions() + " transitions");
		//System.out.println(graph12);
		System.out.println();
		
		//System.out.println(graph11.equalGraph(graph11.getInitialNode(), graph12, graph12.getInitialNode()));

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

			String[] desElements = des.split(",");
			String start = desElements[0].trim();
			int numberTransitions = Integer.parseInt(desElements[1].trim());
			int numberStates = Integer.parseInt(desElements[2].trim());				
			Node nodes[] = new Node[numberStates];
			nodes[0] = new Node(start);
			graph.addNode(nodes[0]);

			for (int i = 1; i <= numberTransitions; i++) {
				String edge = scanner.nextLine();
				String ed = edge.substring(1, edge.length()-1);

				String[] edgeElements = ed.split(",");//split("\"");
				String node1 = edgeElements[0].trim();//.substring(0, edgeElements[0].length()-1)
				String action = "";
				if(edgeElements.length == 3)
				{
					action = edgeElements[1].trim();
				}
				else
				{
					for(int j = 1; j <= edgeElements.length - 2; j++)
					{
						action = action + edgeElements[j].trim();
					}
				}
				String node2 = edgeElements[edgeElements.length - 1].trim();//.substring(1, edgeElements[2].length())

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
