package ii.edu.mk.saturation;

import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranFile.AldebaranFileLine;
import ii.edu.mk.io.AldebaranUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Petar Gjorchevski
 * @author Metodi Micev
 * @author Vladimir Carevski - rafactoring
 */
public class Saturator {

	private final static Logger LOG = LogManager.getLogger(Saturator.class);
	private static final String tau = "tau";

	/**
	 * Grafot e vsusnost mnozestvo od tranzicii, koe za ovaa potreba ke go
	 * podelime na disjunktni 2*BrojNaSostojbi podmnozestva Kade za sekoja
	 * sostojba kreirame dve mnozestva - Site tranzicii koi zavrsuvaat vo
	 * dadenata sostojba so akcija Tau, i - Site tranzicii koi zavrsuvaat vo
	 * dadenata sostojba so akcija razlicna od Tau
	 **/
	ArrayList<HashSet<Transition>> trEndTau;
	ArrayList<HashSet<Transition>> trEndOthers;

	ArrayList<HashSet<Transition>> trStartTau;
	ArrayList<HashSet<Transition>> trStartOthers;

	private Integer numberOfStates;

	private Saturator() {
		trEndTau = new ArrayList<HashSet<Transition>>();
		trEndOthers = new ArrayList<HashSet<Transition>>();
		trStartTau = new ArrayList<HashSet<Transition>>();
		trStartOthers = new ArrayList<HashSet<Transition>>();
		numberOfStates = null;
	}
	
	public static final Saturator getInstance(){
		return new Saturator();
	}
	
	public AldebaranFile saturate(AldebaranFile aldebaranFile){
		clean();
		loadLts(aldebaranFile);
		saturateLts();
		return extractLts();
	}
	
	private void clean(){
		trEndTau.clear();
		trEndOthers.clear();
		trStartTau.clear();
		trStartOthers.clear();
		numberOfStates = null;
	}
	
	private void saturateLts() {
		LOG.debug("Saturating....");
		
		// Prv cekor : Refleksivnost na Tau
		for (int i = 0; i < numberOfStates; i++) {
			trEndTau.get(i).add(Transition.fromTriple(i, tau, i));
		}

		// Vtor cekor : Tranzitivnost na Tau
		ArrayList<Transition> workerList = new ArrayList<Transition>();
		for (int i = 0; i < numberOfStates; i++) {
			for (Transition transition : trEndTau.get(i)) {
				workerList.add(transition);
			}

			int itemsCount = workerList.size();
			int currentPos = 0;
			while (currentPos < itemsCount) {
				int through = workerList.get(currentPos).getStartState();
				for (Transition transition : trEndTau.get(through)) {
					if (trEndTau.get(i).add(Transition.fromTriple(transition.getStartState(), tau, i))) {
						workerList.add(Transition.fromTriple(transition.getStartState(), tau, i));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}

		// Tret cekor : PaQ, Q#R -> PaR
		for (int i = 0; i < numberOfStates; i++) {
			for (Transition transition : trEndOthers.get(i)) {
				workerList.add(transition);
			}

			int itemsCount = workerList.size();
			int currentPos = 0;
			while (currentPos < itemsCount) {
				int through = workerList.get(currentPos).getStartState();
				String currentLabel = workerList.get(currentPos).getLabel();
				for (Transition transition : trEndTau.get(through)) {
					if (trEndOthers.get(i).add(Transition.fromTriple(transition.getStartState(), currentLabel, i))) {
						workerList.add(Transition.fromTriple(transition.getStartState(), currentLabel, i));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}

		// Cetvrt cekor : P#Q, QaR -> PaR
		// Prvo ke gi stavime vo drugi mnozestva koi se "bucket"-i, ama po
		// pocetniot element
		trStartOthers.clear();
		trStartTau.clear();

		for (int i = 0; i < numberOfStates; i++) {
			HashSet<Transition> setTau = new HashSet<Transition>();
			trStartTau.add(setTau);
			HashSet<Transition> setOthers = new HashSet<Transition>();
			trStartOthers.add(setOthers);
		}

		for (int i = 0; i < numberOfStates; i++) {
			for (Transition transition : trEndTau.get(i)) {
				trStartTau.get(transition.getStartState()).add(transition);
			}
			trEndTau.get(i).clear();
			for (Transition transition : trEndOthers.get(i)) {
				trStartOthers.get(transition.getStartState()).add(transition);
			}
			trEndOthers.get(i).clear();
		}

		for (int i = 0; i < numberOfStates; i++) {
			for (Transition transition : trStartOthers.get(i)) {
				workerList.add(transition);
			}

			int itemsCount = workerList.size();
			int currentPos = 0;
			while (currentPos < itemsCount) {
				int through = workerList.get(currentPos).getEndState();
				String currentLabel = workerList.get(currentPos).getLabel();
				for (Transition transition : trStartTau.get(through)) {
					if (trStartOthers.get(i).add(Transition.fromTriple(i, currentLabel, transition.getEndState()))) {
						workerList.add(Transition.fromTriple(i, currentLabel, transition.getEndState()));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}
	}
	
	/**
	 * Initializes structures with LTS data contained in aldebaran file.
	 */
	private void loadLts(AldebaranFile alFile){
		numberOfStates = alFile.getNumberOfStates();
		
		// clear lists, safe to remove?
		trEndTau.clear();
		trEndOthers.clear();

		for (int i = 0; i < numberOfStates; i++) {
			trEndTau.add(new HashSet<Transition>());
			trEndOthers.add(new HashSet<Transition>());
		}

		for(AldebaranFileLine line : alFile.getLines()){
			Transition edge = Transition.fromTriple(line.getStartState(), line.getLabel(), line.getEndState());

			if (edge.getLabel().equals(tau)) {
				trEndTau.get(edge.getEndState()).add(edge);
			} else {
				trEndOthers.get(edge.getEndState()).add(edge);
			}
		}
	}
	
	/**
	 * Extracts saturated LTS from structures and returns them in aldebaran file. 
	 */
	private AldebaranFile extractLts(){
		AldebaranFile alFile = new AldebaranFile();

		int numberOfTransitions = 0;
		for (int i = 0; i < numberOfStates; i++) {
			numberOfTransitions = numberOfTransitions + trStartOthers.get(i).size() + trStartTau.get(i).size();
		}
		
		alFile.setFirstState(0);
		alFile.setNumberOfStates(numberOfStates);
		alFile.setNumberOfTransitions(numberOfTransitions);
		for (int i = 0; i < numberOfStates; i++) {
			for (Transition transition : trStartOthers.get(i)) {
				alFile.addLine(transition.getStartState(), transition.getLabel(), transition.getEndState());
			}
			for (Transition transition : trStartTau.get(i)) {
				alFile.addLine(transition.getStartState(), transition.getLabel(), transition.getEndState());
			}
		}
		
		return alFile;
	}
	
	//for testing purposes
	public static void main(String[] args) throws IOException {
		
		File inFile = new File("test/ii/resources/Aldebaran_Graf.aut");
		File outFile = new File("test/ii/resources/Aldebaran_Graf_saturated.aut");
		
		AldebaranFile alFile = AldebaranUtils.readFile(inFile);
		Saturator saturator = Saturator.getInstance();
		alFile = saturator.saturate(alFile);
		AldebaranUtils.writeFile(alFile, outFile);
	}
}
