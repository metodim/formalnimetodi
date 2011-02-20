package ii.edu.mk.bisimulation;

//So pomosh na ovaa klasa se definira dvojka koja e karakteristicna za akcija od tipot p -> q.
//Odnosno deka procesot p tranzitira vo procesot q so pomosh na tranzicijata a.
//Taka na primr dokolku 1 -> 2 so transakcija a, kje ja imame dvojkata (2,a) koja pak kje bide
//element na nodot oznacen so 1.
public class Dvojki {
	private int Node;
	private String Trenzicija;
	
	public Dvojki(int node, String tranzicija)
	{
		Node = node;
		Trenzicija = tranzicija;
	}
	
	public String toString()
	{
		return "(" + Node + ", " + Trenzicija + ")";
	}
	
	public void setNode(int node) {
		Node = node;
	}
	
	public int getNode() {
		return Node;
	}
	
	public void setTrenzicija(String trenzicija) {
		Trenzicija = trenzicija;
	}
	
	public String getTrenzicija() {
		return Trenzicija;
	}
}
