package ii.edu.mk.bisimulation;

import java.util.LinkedList;

//Klasa so cija pomosh se definira jazol vo grafot, koj potoa se analizira i vrz osnova na nego
//se odrdeuva fiksnata tocka vo koja se krie minimalnata bisimulacija. Treba da se napomene deka 
//jazlite kje dobivaat vrednosti od mnozestvoto na prirodni broevi N. Taka na primer dokolku gi
//slednite tranzicii 1 -> (a)2, 1 ->(a)3, 1 ->(b)4, togash za nodot oznacen kako 1 kje ja imame
//slednava reprezentacija Node: 1, Tranzicii: (2,a),(3,a),(4,b).
//Nodovite mora da bidat oznaceni po redeloste od mnozetvoto na prirodni broevi, toa kje znaci deka
//dokolku kazeme deka ne interesira noto so broj 5 mnogu ednostavno mozeme da gi izvelceme podatocite
//povrzan so nego.

public class Node {
	private int Node;
	private LinkedList<Dvojki> Tranzicii;
	
	public void SetTransition(Dvojki tranzicija)
	{
		Tranzicii.add(tranzicija);
	}
	
	public LinkedList<String> TranziciiNode()
	{
		LinkedList<String> niza = new LinkedList<String>();
		
		for (int i = 0; i < Tranzicii.size(); i++)
		{
			if(!niza.contains(Tranzicii.get(i).getTrenzicija()))
			{
				niza.add(Tranzicii.get(i).getTrenzicija());
			}
		}
		
		return niza;		
	}
	
	public String toString()
	{
		String s = "";
		s = Node + "->";
		int n = Tranzicii.size();
		for (int i = 0; i < n; i++)
		{
			s += Tranzicii.get(i).toString();
			
			if (i + 1 != n)
			{
				s+= ", ";
			}			
		}
		
		return s;
	}
	
	public Node(int node)
	{
		Node = node;
		Tranzicii = new LinkedList<Dvojki>();
	}
	
	public void setNode(int node) {
		Node = node;
	}
	
	public int getNode() {
		return Node;
	}
	
	public void setTranzicii(LinkedList<Dvojki> tranzicii) {
		Tranzicii = tranzicii;
	}
	
	public LinkedList<Dvojki> getTranzicii() {
		return Tranzicii;
	}	
}
