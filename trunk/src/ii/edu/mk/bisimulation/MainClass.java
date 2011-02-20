package ii.edu.mk.bisimulation;

import java.util.LinkedList;

public class MainClass {
	
	// primer 1	
	public static Graph GenerateGraph()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "b"));
		node1.SetTransition(new Dvojki(3, "a"));		
		
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(4, "c"));
		
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(4, "c"));
		
		graf.addNode(node3);
		
		Node node4 = new Node(4);
		node4.SetTransition(new Dvojki(2, "b"));
		node4.SetTransition(new Dvojki(3, "a"));
		node4.SetTransition(new Dvojki(1, "a"));		
		
		graf.addNode(node4);
		
		return graf;
	}
	
	//	 primer 2
	public static Graph GenerateGraph1()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(1, "a"));		
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(2, "a"));
		node3.SetTransition(new Dvojki(4, "a"));		
		graf.addNode(node3);
		
		Node node4 = new Node(4);
		node4.SetTransition(new Dvojki(3, "b"));
		node4.SetTransition(new Dvojki(5, "a"));
		graf.addNode(node4);
		
		Node node5 = new Node(5);		
		graf.addNode(node5);
		
		return graf;
	}
	
	//	 primer 3
	public static Graph GenerateGraph2()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));
		node1.SetTransition(new Dvojki(3, "a"));
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(4, "b"));		
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(4, "c"));				
		graf.addNode(node3);
		
		Node node4 = new Node(4);		
		graf.addNode(node4);
		
		return graf;
	}
	
	//	 primer 4	
	public static Graph GenerateGraph3()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));		
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(3, "b"));
		node2.SetTransition(new Dvojki(4, "c"));
		graf.addNode(node2);
		
		Node node3 = new Node(3);						
		graf.addNode(node3);
		
		Node node4 = new Node(4);		
		graf.addNode(node4);
		
		return graf;
	}
	
	//	 primer 5	
	public static Graph GenerateGraph4()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));
		node1.SetTransition(new Dvojki(3, "a"));
		graf.addNode(node1);
		
		Node node2 = new Node(2);		
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(4, "b"));
		graf.addNode(node3);
		
		Node node4 = new Node(4);		
		graf.addNode(node4);
		
		return graf;
	}
	
	//	 primer 6	
	public static Graph GenerateGraph5()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));		
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(3, "b"));
		graf.addNode(node2);
		
		Node node3 = new Node(3);		
		graf.addNode(node3);		
		
		return graf;
	}

	//	 primer 7
	public static Graph GenerateGraph6()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));
		node1.SetTransition(new Dvojki(4, "a"));
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(2, "b"));
		node2.SetTransition(new Dvojki(4, "b"));
		node2.SetTransition(new Dvojki(3, "c"));
		graf.addNode(node2);
		
		Node node3 = new Node(3);		
		graf.addNode(node3);
		
		Node node4 = new Node(4);
		node4.SetTransition(new Dvojki(2, "b"));
		node4.SetTransition(new Dvojki(5, "c"));
		graf.addNode(node4);
		
		Node node5 = new Node(5);		
		graf.addNode(node5);
		
		return graf;
	}
	
	//	 primer 8	
	public static Graph GenerateGraph7()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));
		node1.SetTransition(new Dvojki(3, "a"));
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(4, "b"));		
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(5, "c"));
		graf.addNode(node3);
		
		Node node4 = new Node(4);		
		graf.addNode(node4);
		
		Node node5 = new Node(5);		
		graf.addNode(node5);
		
		return graf;
	}
	
	//	 primer 9
	public static Graph GenerateGraph8()
	{
		Graph graf = new Graph();
		
		Node node1 = new Node(1);
		node1.SetTransition(new Dvojki(2, "a"));		
		graf.addNode(node1);
		
		Node node2 = new Node(2);
		node2.SetTransition(new Dvojki(3, "b"));
		node2.SetTransition(new Dvojki(4, "b"));
		graf.addNode(node2);
		
		Node node3 = new Node(3);
		node3.SetTransition(new Dvojki(5, "d"));
		node3.SetTransition(new Dvojki(6, "c"));
		graf.addNode(node3);
		
		Node node4 = new Node(4);
		node4.SetTransition(new Dvojki(7, "d"));
		node4.SetTransition(new Dvojki(6, "c"));
		graf.addNode(node4);
		
		Node node5 = new Node(5);		
		graf.addNode(node5);
		
		Node node6 = new Node(6);		
		graf.addNode(node6);
		
		Node node7 = new Node(7);		
		graf.addNode(node7);
		
		return graf;
	}
	
	public static void main(String[] args) {
		
		Graph graf = new Graph();
		graf = GenerateGraph8();	
		System.out.println(graf);
		
		LinkedList<Integer> procesi = new LinkedList<Integer>();		
		for (int i = 0; i < graf.size(); i++)
		{
			procesi.add(graf.getNodeName(i));			
		}
		
		ListaDvojkiProcesi listaR0 = new ListaDvojkiProcesi();
		
		for (int i = 0; i < graf.size(); i++)
		{
			for (int j = 0; j < graf.size(); j++)
			{
				if (i < j)
				{
					DvojkiProcesi dvojka = new DvojkiProcesi(graf.getNode(i), graf.getNode(j));
					listaR0.addDvojkiProces(dvojka);
				}
			}
		}		
		
		ListaDvojkiProcesi listaR1 = new ListaDvojkiProcesi();
		
		int k= 0;
		
		do
		{		
			if (k != 0)
			{
				listaR0.ResetLista(listaR1);
			}			
			
			k++;
			
			listaR1 = new ListaDvojkiProcesi();
			
			for (int i = 0; i < listaR0.size(); i++)
			{					
				if(listaR0.Sodrzi(listaR0.getDvojkiProcesi(i), graf))
				{
					listaR1.addDvojkiProces(listaR0.getDvojkiProcesi(i));
				}
			}			
		} while (!listaR0.Ednakvi(listaR1));
		
		System.out.println(listaR1);
	}
}
