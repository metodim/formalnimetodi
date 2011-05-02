package ii.edu.mk.bisimulation;

import java.util.LinkedList;

/**
 * Tuka se cuva nizata (litata) od dvojki od pocesi koi treba da se reducira se
 * dodeka ne se dobie fiksna tocka. Fiksna tocka se dobia vo momentoto koga ovaa
 * niza vo i-tata i vo i+1-vata iteracija se isti. Vo toj moment ja ispishuvame
 * ovaa niza. Vo ovaa niza ne se cuvaat simetricnite dvojki, nitu pak
 * refleksivnite dvojki.
 */
public class ListPairProcess {
	private LinkedList<PairProcess> listPairProcess;

	public ListPairProcess() {
		setListPairProcess(new LinkedList<PairProcess>());
	}

	public void resetList(ListPairProcess l) {
		listPairProcess = new LinkedList<PairProcess>();
		listPairProcess = l.getListPairProcess();
	}

	/**
	 * Se proveruva dali dve listi od dve poslednovatelni iteracii se odnakvi.
	 * Tuka dovolno e da se proveri dolizinata na razgleduvanata lista, ne e
	 * potrebno da se ide element po element. Ova svojstvo poteknuva od samiot
	 * algoritam, vo sekoja iteracija se odzema barem po eden element vo
	 * iteracijata vo koja ne se odzema nitu eden element sme ja nashle fiksnata
	 * tocka.
	 */
	public boolean equalsListPairProcess(ListPairProcess l) {
		LinkedList<PairProcess> l2 = l.getListPairProcess();
		if (listPairProcess.size() != l2.size()) {
			return false;
		}
		return true;
	}

	public void addPairProcess(PairProcess pair) {
		getListPairProcess().add(pair);
	}

	public PairProcess getPairProcess(int i) {
		return getListPairProcess().get(i);
	}

	public void setPairProcess(PairProcess pair) {
		getListPairProcess().add(pair);
	}

	/**
	 * Se proveruva dali nekoja dvojka od procesi ja ima vo nizata. Ova nie
	 * potrebno vo momentot koga razgleduvame dvojka na procesi i koga trba da
	 * odlucime dali taa kje odi ponatamu ili treba da ja prekineme v taa
	 * iteracija. Za da go doneseme toj sum, treba da gi najdeme tranzicii na
	 * prviot proces, potoa site tranzicii na votriot proces. Treba da se
	 * proveri dali ove dve mnozstva se ednakvi, toa go pravime so pomosh na
	 * funkcijata IstiTranzicii() od klasata DvojkiProcesi, dokolku se ednakvi
	 * togash gi analizirame odnseuvanjata na procesite za sekoja od
	 * tranziciite. Na primer dokolku i dvata procesi imaat isto mnozestvo na
	 * tranzicii i tranzicijata a e del od toa mnozestvo, toga[ treba da gi
	 * najdeme site procesi vo koj shto moze da se stigne so tranzicijata a od
	 * prviot node, i site procesi vo koj shto moze da se stigne so pomosh na
	 * procesot a od vtoriot nod. Se pravi dekartov proizvod na ove dve listi i
	 * se proveruva dali taa dvojka od procesi e del od tekovnata niza od dvojki
	 * na procesi. So pomosh na ovaa funkcija samo se proveruva dali edna dvojka
	 * od procesi e del od nizata, a dopolnitelnata goreopishana logika e dadena
	 * vo funkcijata Sodrzi(DvojkiProcesi dvojka, Graph g).
	 */
	public boolean containsPair(PairProcess pair) {
		if (pair.getNode1().getNodeName() == pair.getNode2().getNodeName()) {
			return true;
		}

		for (int i = 0; i < getListPairProcess().size(); i++) {
			if ((getListPairProcess().get(i).getNode1().getNodeName() == pair.getNode1().getNodeName() && 
					getListPairProcess().get(i).getNode2().getNodeName() == pair.getNode2().getNodeName()) || 
					(getListPairProcess().get(i).getNode1().getNodeName() == pair.getNode2().getNodeName() && 
							getListPairProcess().get(i).getNode2().getNodeName() == pair.getNode1().getNodeName())) {
				return true;
			}
		}

		return false;
	}

	public int size() {
		return getListPairProcess().size();
	}

	public boolean containsPairProcessInGraph(PairProcess pair, Graph g) {
		if (!pair.doSameActions()) {
			return false;
		} else {
			LinkedList<String> transitions = pair.getNode1().getActions();
			LinkedList<PostTransition> node1Transitions = g.getNodeFromGraph(pair.getNode1().getNodeName()).getPostTransitions();
			LinkedList<PostTransition> node2Transitions = g.getNodeFromGraph(pair.getNode2().getNodeName()).getPostTransitions();

			for (int i = 0; i < transitions.size(); i++) {
				LinkedList<String> node1Processes = new LinkedList<String>();
				LinkedList<String> node2Processes = new LinkedList<String>();

				// System.out.println(tranzicii.get(i));
				for (int j = 0; j < node1Transitions.size(); j++) {
					if (node1Transitions.get(j).getAction().equals(transitions.get(i))) {
						node1Processes.add(node1Transitions.get(j).getPostProcess());
					}
				}

				// System.out.println("ova e 1 "+node1Procesi);

				for (int j = 0; j < node2Transitions.size(); j++) {
					if (node2Transitions.get(j).getAction().equals(transitions.get(i))) {
						node2Processes.add(node2Transitions.get(j).getPostProcess());
					}
				}

				// System.out.println("ova e 2 "+node2Procesi);

				for (int j = 0; j < node1Processes.size(); j++) {
					for (int k = 0; k < node2Processes.size(); k++) {
						if (j < k) {
							PairProcess pairs = new PairProcess(g.getNodeFromGraph(node1Processes.get(j)), g.getNodeFromGraph(node2Processes.get(k)));
							if (!containsPair(pairs)) {
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

	void setListPairProcess(LinkedList<PairProcess> listPairs) {
		this.listPairProcess = listPairs;
	}

	LinkedList<PairProcess> getListPairProcess() {
		return listPairProcess;
	}

	public String toString() {
		String s = "";

		for (int i = 0; i < getListPairProcess().size(); i++) {
			s += "(" + getListPairProcess().get(i).getNode1().getNodeName() + ", " + getListPairProcess().get(i).getNode2().getNodeName() + ")";
			if (i != getListPairProcess().size() - 1)
				s += ", ";
		}

		return s;
	}
}
