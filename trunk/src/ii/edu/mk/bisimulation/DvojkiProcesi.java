package ii.edu.mk.bisimulation;

import java.util.LinkedList;
//Dvojki od procesi e vazen klasa vo koja se cuvaat dvojkite od procesi. Na pocetokot, pocnuvame
//so dekartov proizvod od dvojki na procesi i edena po edna gi elminirame. Znaci celo vreme rabotime 
//so pomosh na niza od dvojki od procesi, taa niza e implementirana vo ListaDvojkiProcesi.
//Treba da napomeneme deka razvojot na ovaa lista ide se dodeka pose dve poslednovatelni iteracii taa
//ne se promeni.
public class DvojkiProcesi {
	private Node Node1;
	private Node Node2;
	
	public DvojkiProcesi(Node node1, Node node2)	
	{
		setNode1(node1);
		setNode2(node2);
	}

	public void setNode1(Node node1) {
		Node1 = node1;
	}

	public Node getNode1() {
		return Node1;
	}

	public void setNode2(Node node2) {
		Node2 = node2;
	}

	public Node getNode2() {
		return Node2;
	}
	
	//Ova e funkcija koja pokazuvaa dali dali pocesot odnzacen kako Node1 i procesot oznacen
	//kako Node2 pravat isti tranzicii. Dokolku pravat insti trnzicii se pravi ponatamoshna analiza
	//dokolku pak ako ne pravat isti tranzicii ragledvuanata dvojka od procesi se otfrla.
	public boolean IstiTranzicii()
	{
		LinkedList<String> tranzicii1 = Node1.TranziciiNode();
		LinkedList<String> tranzicii2 = Node2.TranziciiNode();		
		
		if (tranzicii1.size() != tranzicii2.size())
		{
			return false;
		}
		else
		{
			for(int i = 0; i < tranzicii1.size(); i++)
			{
				if(!tranzicii2.contains(tranzicii1.get(i)))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
}
