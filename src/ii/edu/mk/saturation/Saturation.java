package ii.edu.mk.saturation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class Saturation {

	/**
	 * @author Petar Gjorchevski
	 * @author Metodi Micev
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String tau = "#";       
		// Ja citame datotekata, pocnuvajci od headerot

		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream("test/ii/resources/Aldebaran_Graf.aut")));
		String line = bufReader.readLine();
		if(line == null || !line.startsWith("des") || line.isEmpty())
			throw new IllegalArgumentException("Illegal argument for aldebaran descriptor");
		String lines[] = line.split(",+");
		int numberOfStates = Integer.parseInt(lines[2].split("\\)")[0].replaceAll(" +", ""));

		// Grafot e vsusnost mnozestvo od tranzicii,
		// koe za ovaa potreba ke go podelime na disjunktni 2*BrojNaSostojbi podmnozestva
		// Kade za sekoja sostojba kreirame dve mnozestva
		//   - Site tranzicii koi zavrsuvaat vo dadenata sostojba so akcija Tau, i 
		//   - Site tranzicii koi zavrsuvaat vo dadenata sostojba so akcija razlicna od Tau

		ArrayList<HashSet<Transition>> trEndTau = new ArrayList<HashSet<Transition>>();
		ArrayList<HashSet<Transition>> trEndOthers = new ArrayList<HashSet<Transition>>();

		for (int i = 0; i < numberOfStates; i++)
		{
			HashSet<Transition> setTau = new HashSet<Transition>();
			trEndTau.add(setTau);
			HashSet<Transition> setOthers = new HashSet<Transition>();
			trEndOthers.add(setOthers);
		}

		while((line = bufReader.readLine()) != null)
		{
			Transition edge = new Transition();
			edge=Transition.FromString(line);

			if (edge.label.equals(tau))
			{
				trEndTau.get(edge.endState).add(edge);
			} 
			else 
			{ 
				trEndOthers.get(edge.endState).add(edge);
			}
		}
		bufReader.close();

		// Prv cekor : Refleksivnost na Tau

		for (int i = 0; i < numberOfStates; i++)
		{
			Transition rb = new Transition(); 
			rb.startState = i; 
			rb.label = tau; 
			rb.endState = i;
			trEndTau.get(i).add(rb);
		}

		// Vtor cekor : Tranzitivnost na Tau

		ArrayList<Transition> workerList = new ArrayList<Transition>();

		for (int i = 0; i < numberOfStates; i++)
		{
			for (Transition transition : trEndTau.get(i)) 
			{
				workerList.add(transition);
			}

			int itemsCount = workerList.size();
			int currentPos = 0;
			while(currentPos < itemsCount)
			{    
				int through = workerList.get(currentPos).startState;
				for (Transition transition : trEndTau.get(through))
				{   
					if (trEndTau.get(i).add(Transition.FromTriple(transition.startState, tau, i)))
					{
						workerList.add(Transition.FromTriple(transition.startState, tau, i));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}

		// Tret cekor : PaQ, Q#R -> PaR

		for (int i = 0; i < numberOfStates; i++)
		{
			for (Transition transition : trEndOthers.get(i)) 
			{
				workerList.add(transition);
			}

			int itemsCount = workerList.size();
			int currentPos = 0;
			while(currentPos < itemsCount)
			{    
				int through = workerList.get(currentPos).startState;
				String currentLabel = workerList.get(currentPos).label;
				for (Transition transition : trEndTau.get(through))
				{   
					if (trEndOthers.get(i).add(Transition.FromTriple(transition.startState, currentLabel, i)))
					{
						workerList.add(Transition.FromTriple(transition.startState, currentLabel, i));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}

		// Cetvrt cekor : P#Q, QaR -> PaR
		// Prvo ke gi stavime vo drugi mnozestva koi se "bucket"-i, ama po pocetniot element

		ArrayList<HashSet<Transition>> trStartTau = new ArrayList<HashSet<Transition>>();
		ArrayList<HashSet<Transition>> trStartOthers = new ArrayList<HashSet<Transition>>();

		for (int i = 0; i < numberOfStates; i++)
		{
			HashSet<Transition> setTau = new HashSet<Transition>();
			trStartTau.add(setTau);
			HashSet<Transition> setOthers = new HashSet<Transition>();
			trStartOthers.add(setOthers);
		}
		
		for (int i = 0; i < numberOfStates; i++)
		{
			for (Transition transition : trEndTau.get(i)) 
			{ 
				trStartTau.get(transition.startState).add(transition); 
			}
			trEndTau.get(i).clear();
			for (Transition transition : trEndOthers.get(i)) 
			{ 
				trStartOthers.get(transition.startState).add(transition); 
			}
			trEndOthers.get(i).clear();
		}
		
		for (int i = 0; i < numberOfStates; i++)
		{
			for (Transition transition : trStartOthers.get(i)) 
			{
				workerList.add(transition);
			}
		
			int itemsCount = workerList.size();
			int currentPos = 0;
			while(currentPos < itemsCount)
			{    
				int through = workerList.get(currentPos).endState;
				String currentLabel = workerList.get(currentPos).label;
				for (Transition transition : trStartTau.get(through))
				{   
					if (trStartOthers.get(i).add(Transition.FromTriple(i, currentLabel, transition.endState)))
					{
						workerList.add(Transition.FromTriple(i, currentLabel, transition.endState));
						itemsCount++;
					}
				}
				currentPos++;
			}
			workerList.clear();
		}

		int numberOfTransitions=0;
		for (int i = 0; i < numberOfStates; i++)
		{ 
			numberOfTransitions = numberOfTransitions + trStartOthers.get(i).size() + trStartTau.get(i).size();
		}

		BufferedWriter bufWriter = new BufferedWriter(new FileWriter("test/ii/resources/Aldebaran_Graf_saturated.aut"));
		bufWriter.write(String.format("des (0, %s, %s)", numberOfTransitions,numberOfStates));
		bufWriter.newLine();

		for (int i = 0; i < numberOfStates; i++)
		{   
			for (Transition transition : trStartOthers.get(i))
				bufWriter.write(String.format("(%s, %s, %s)%n", transition.startState, transition.label, transition.endState));
			for (Transition transition : trStartTau.get(i))
				bufWriter.write(String.format("(%s, %s, %s)%n", transition.startState, transition.label, transition.endState));
		}
		
		bufWriter.flush();
		bufWriter.close();
		System.out.println("Datotekata test/ii/resources/Aldebaran_Graf_saturated.aut e uspesno snimena.");
	}
}
