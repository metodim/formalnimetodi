package ii.edu.mk.bisimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//remove this class when this test are converted into unit tests
public class MainClass {

	protected static String[] aldebaranFilenames = {    
		"scheduler.aut", "trains.aut", "abp.aut", "par.aut", "abp_bw.aut", 
		"dining3.aut", "mpsu.aut", "leader.aut", "tree.aut", "cabp.aut", 
		"parallel.aut", "onebit.aut"
	};  

	public static void main(String[] args) {

		System.out.println("Graph1:");
        Graph graph1 = generateGraph("parallel_min.aut");
        //System.out.println(graph1);

        //Graph graph11 = new Graph(graph1);
       

        System.out.println("Graph2:");
        Graph graph2 = generateGraph("parallel.aut");
        //Graph graph12 = new Graph(graph2);
        //System.out.println(graph2);

        /*
        Graph graph21 = new Graph(graph2);
        Graph graph22 = new Graph(graph2);

        System.out.println("\n1) Minimisation using standard bisimulation algorithm\n");

        ListPairProcess L1 = graph11.findStrongBisimulationNaive();
        System.out.println("Pairs of bisimilar states in Graph1: " + L1);
        System.out.println();
        Partition P1 = L1.createPartition();
        graph11.minimizationGraph(P1);
        System.out.println("Minimised Graph1:");
        //System.out.println(graph11);

        ListPairProcess L2 = graph21.findStrongBisimulationNaive();
        System.out.println("Pairs of bisimilar states in Graph2: " + L2);
        System.out.println();
        Partition P2 = L2.createPartition();
        graph21.minimizationGraph(P2);
        System.out.println("Minimised Graph2:");
        //System.out.println(graph21);
         * 
         */

        System.out.println("Are the two graphs strongly bisimilar?");
        //System.out.println(graph11.equalGraph(graph11.getInitialNode(), graph21, graph21.getInitialNode()));
        System.out.println(graph1.equalGraph(graph2, "fernandez"));

        /*
        System.out.println("\n\n2) Minimisation using Fernandez bisimulation algorithm\n");

        Partition P1 = graph12.findStrongBisimulationFernandez();
        System.out.println("Sets of mutually bisimilar states in Graph1: " + P1);
        System.out.println();
        graph12.minimizationGraph(P1);
        System.out.println("Minimised Graph1:");
        System.out.println(graph12);

        Partition P2 = graph22.findStrongBisimulationFernandez();
        System.out.println("Sets of mutually bisimilar states in Graph2: " + P2);
        System.out.println();
        graph22.minimizationGraph(P2);
        System.out.println("Minimised Graph2:");
        System.out.println(graph22);

        System.out.println("Are the two graphs strongly bisimilar?");
        System.out.println(graph12.equalGraph(graph12.getInitialNode(), graph22, graph22.getInitialNode()));

        System.out.println("\n***********************\n");
		
		/*
		for (int i=0; i<aldebaranFilenames.length-2; i++)
		{
			String filename = aldebaranFilenames[i];
			System.out.println("\n ************* " + filename + " ************ ");
			Graph graph = generateGraph(filename);
			//Graph graph = generateGraph("goback.aut");

			Graph graph1 = new Graph(graph);
			Graph graph2 = new Graph(graph);

			System.out.println("\n1) Minimisation using naive bisimulation algorithm\n");
			long avgTime1 = 0;
			ListPairProcess L1 = new ListPairProcess();
			System.out.print("Execution time: ");
			for (int j=0; j < 10; j++)
			{
				Graph graph11 = new Graph(graph1);
				long start1 = System.currentTimeMillis();
				L1 = graph11.findStrongBisimulationNaive();
				long end1 = System.currentTimeMillis();
				long tmp1 = end1-start1;
				System.out.print (tmp1 + " ms");
				if (i != 9)
					System.out.print(", ");
				else
					System.out.println("\n");
				avgTime1 += tmp1;
			}
			System.out.println("\nAverage executiion time = " + avgTime1/10);
			
			System.out.println("Pairs of bisimilar states in Graph1: " + L1);
			//System.out.println();

			Partition P = L1.createPartition();
			System.out.println("Sets of bisimilar states in Graph1: " + P);
			//graph1.minimizationGraph(P);
			//System.out.println("Minimal graph has " + graph1.getNumberOfStates() + " states");
			//System.out.println("Minimal graph has " + graph1.getNumberOfTransitions() + " transitions");
			
			System.out.println("\n\n2) Minimisation using Fernandez bisimulation algorithm\n");		

			long avgTime2 = 0;
			Partition P1 = new Partition();
			System.out.print("Execution time: ");
			for (int j=0; j < 10; j++)
			{
				Graph graph12 = new Graph(graph2);
				long start2 = System.currentTimeMillis();
				P1 = graph12.findStrongBisimulationFernandez();
				long end2 = System.currentTimeMillis();
				long tmp2 = end2-start2;
				System.out.print(tmp2 + " ms");
				if (i != 9)
					System.out.print(", ");
				avgTime2 += tmp2;
			}
			System.out.println("\nAverage execution time = " + avgTime2/10);
				
			System.out.println("Sets of bisimilar states in Graph1: " + P1);
		}
		*/
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
