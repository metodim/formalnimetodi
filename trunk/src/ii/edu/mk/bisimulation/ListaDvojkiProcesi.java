package ii.edu.mk.bisimulation;

import java.util.LinkedList;
//Tuka se cuva nizata (litata) od dvojki od pocesi koi treba da se reducira se dodeka
//ne se dobie fiksna tocka. Fiksna tocka se dobia vo momentoto koga ovaa niza vo i-tata i vo i+1-vata
//iteracija se isti. Vo toj moment ja ispishuvame ovaa niza.
//Vo ovaa niza ne se cuvaat simetricnite dvojki, nitu pak refleksivnite dvojki.
public class ListaDvojkiProcesi {
	private LinkedList<DvojkiProcesi> listaDvojkiProcesi;
	
	public ListaDvojkiProcesi()
	{
		setListaDvojkiProcesi(new LinkedList<DvojkiProcesi>());
	}
	
	public void ResetLista(ListaDvojkiProcesi l)
	{
		listaDvojkiProcesi = new LinkedList<DvojkiProcesi>();
		listaDvojkiProcesi = l.getListaDvojkiProcesi();
	}	
	
	
	//Se proveruva dali dve listi od dve poslednovatelni iteracii se odnakvi.
	//Tuka dovolno e da se proveri dolizinata na razgleduvanata lista, ne e potrebno da se ide
	//element po element.
	//Ova svojstvo poteknuva od samiot algoritam, vo sekoja iteracija se odzema barem po eden element
	//vo iteracijata vo koja ne se odzema nitu eden element sme ja nashle fiksnata tocka.
	public boolean Ednakvi(ListaDvojkiProcesi l)
	{
		LinkedList<DvojkiProcesi> l2 = l.getListaDvojkiProcesi();
		if (listaDvojkiProcesi.size() != l2.size())
		{
			return false;
		}
		
		return true;
	}
	
	public void addDvojkiProces (DvojkiProcesi dvojka)
	{
		getListaDvojkiProcesi().add(dvojka);
	}
	
	public DvojkiProcesi getDvojkiProcesi(int i)
	{
		return getListaDvojkiProcesi().get(i);
	}
	
	public void setDvojkiProcesi(DvojkiProcesi d)
	{
		getListaDvojkiProcesi().add(d);
	}
	
	//Se proveruva dali nekoja dvojka od procesi ja ima vo nizata. Ova nie potrebno vo momentot
	//koga razgleduvame dvojka na procesi i koga trba da odlucime dali taa kje odi ponatamu
	//ili treba da ja prekineme v taa iteracija. Za da go doneseme toj sum, treba da gi najdeme
	//tranzicii na prviot proces, potoa site tranzicii na votriot proces. Treba da se proveri dali
	//ove dve mnozstva se ednakvi, toa go pravime so pomosh na funkcijata IstiTranzicii() od 
	//klasata DvojkiProcesi, dokolku se ednakvi togash gi analizirame odnseuvanjata na procesite za
	//sekoja od tranziciite. Na primer dokolku i dvata procesi imaat isto mnozestvo na tranzicii
	//i tranzicijata a e del od toa mnozestvo, toga[ treba da gi najdeme site procesi vo koj shto moze
	//da se stigne so tranzicijata a od prviot node, i site procesi vo koj shto moze da se stigne
	//so pomosh na procesot a od vtoriot nod. Se pravi dekartov proizvod na ove dve listi i se proveruva
	//dali taa dvojka od procesi e del od tekovnata niza od dvojki na procesi. 
	//So pomosh na ovaa funkcija samo se proveruva dali edna dvojka od procesi e del od nizata, a 
	//dopolnitelnata goreopishana logika e dadena vo funkcijata Sodrzi(DvojkiProcesi dvojka, Graph g).
	public boolean Contains(DvojkiProcesi dvojka)
	{
		if(dvojka.getNode2().getNode() == dvojka.getNode1().getNode())
		{
			return true;
		}
		
		for (int i = 0; i < getListaDvojkiProcesi().size(); i++)
		{
			if ((getListaDvojkiProcesi().get(i).getNode1().getNode() == dvojka.getNode1().getNode() &&
				getListaDvojkiProcesi().get(i).getNode2().getNode() == dvojka.getNode2().getNode()) || 
				(getListaDvojkiProcesi().get(i).getNode1().getNode() == dvojka.getNode2().getNode() &&
				getListaDvojkiProcesi().get(i).getNode2().getNode() == dvojka.getNode1().getNode()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int size()
	{
		return getListaDvojkiProcesi().size();
	}
	
	public boolean Sodrzi(DvojkiProcesi dvojka, Graph g)
	{
		if (!dvojka.IstiTranzicii())
		{
			return false;
		}
		else
		{
			LinkedList<String> tranzicii = dvojka.getNode1().TranziciiNode();
			LinkedList<Dvojki> node1Tranzicii = g.graph.get(dvojka.getNode1().getNode()-1).getTranzicii();
			LinkedList<Dvojki> node2Tranzicii = g.graph.get(dvojka.getNode2().getNode()-1).getTranzicii();
			
			for (int i = 0; i < tranzicii.size(); i++)
			{
				LinkedList<Integer> node1Procesi = new LinkedList<Integer>();			
				LinkedList<Integer> node2Procesi = new LinkedList<Integer>();
				
				// System.out.println(tranzicii.get(i));
				for (int j = 0; j < node1Tranzicii.size(); j++)
				{
					if (node1Tranzicii.get(j).getTrenzicija() == tranzicii.get(i))
					{
						node1Procesi.add(node1Tranzicii.get(j).getNode());
					}
				}
				
				// System.out.println("ova e 1 "+node1Procesi);
				
				for (int j = 0; j < node2Tranzicii.size(); j++)
				{
					if (node2Tranzicii.get(j).getTrenzicija() == tranzicii.get(i))
					{
						node2Procesi.add(node2Tranzicii.get(j).getNode());
					}
				}
				
				// System.out.println("ova e 2 "+node2Procesi);
				
				for (int j = 0; j < node1Procesi.size(); j++)
				{
					for (int k = 0; k < node2Procesi.size(); k++)
					{
						if (j < k)
						{
							DvojkiProcesi dvojki = new DvojkiProcesi(g.getNode(node1Procesi.get(j)-1), g.getNode(node2Procesi.get(k)-1));
							if(!Contains(dvojki))
							{
								return false;
							}
						}
					}
				}
			}
		}		
		
		return true;
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < getListaDvojkiProcesi().size(); i++)
		{
			s += "(" + getListaDvojkiProcesi().get(i).getNode1().getNode() + ", " + getListaDvojkiProcesi().get(i).getNode2().getNode() + ") ";
		}
		
		return s;
	}

	void setListaDvojkiProcesi(LinkedList<DvojkiProcesi> listaDvojkiProcesi) {
		this.listaDvojkiProcesi = listaDvojkiProcesi;
	}

	LinkedList<DvojkiProcesi> getListaDvojkiProcesi() {
		return listaDvojkiProcesi;
	}
}


