
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
		String Tau = "#";       
        // Ja citame datotekata, pocnuvajci od headerot

		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream("Aldebaran_Graf.txt")));
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
		
        ArrayList<HashSet<Transition>> TrEndTau = new ArrayList<HashSet<Transition>>();
        ArrayList<HashSet<Transition>> TrEndDrugi = new ArrayList<HashSet<Transition>>();

        for (int i = 0; i < numberOfStates; i++)
        {
        	HashSet<Transition> MnozestvoTau = new HashSet<Transition>();
            TrEndTau.add(MnozestvoTau);
            HashSet<Transition> MnozestvoDrugi = new HashSet<Transition>();
            TrEndDrugi.add(MnozestvoDrugi);
        }

        while((line = bufReader.readLine()) != null)
        {
        	Transition rebro = new Transition();
        	rebro=Transition.FromString(line);
        //    System.out.printf("%s %s %s %n", rebro.startState, rebro.label, rebro.endState);
       
            if (rebro.label.equals(Tau))
            {
            	TrEndTau.get(rebro.endState).add(rebro);

            	//System.out.printf("tau %sT %s %s %s %n", Tau, rebro.startState, rebro.label, rebro.endState);
            } 
               else { TrEndDrugi.get(rebro.endState).add(rebro);
               //System.out.printf("Bu %sT %s %s %s %n", Tau, rebro.startState, rebro.label, rebro.endState);
               }
        }
        bufReader.close();
        //  System.out.printf("-----%n");
       
        // Prv cekor : Refleksivnost na Tau

        for (int i = 0; i < numberOfStates; i++)
        {
        	Transition rb = new Transition(); 
        	rb.startState = i; 
            rb.label = Tau; 
            rb.endState = i;
            //if (!TrEndTau.get(i).contains(rb))
            TrEndTau.get(i).add(rb);
        }
        /* Debug
        for (int i = 0; i < numberOfStates; i++){
        	for (Transition transition : TrEndTau.get(i))
        		System.out.printf("%s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
        
        //for (int i = 0; i < numberOfStates; i++)
        	for (Transition transition : TrEndDrugi.get(i))
        		System.out.printf("%s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
        }
        System.out.printf("-----%n");
        */
        
        // Vtor cekor : Tranzitivnost na Tau

        ArrayList<Transition> WorkerList = new ArrayList<Transition>();
        
        for (int i = 0; i < numberOfStates; i++)
        {
        	 for (Transition transition : TrEndTau.get(i)) 
        	 {
				WorkerList.add(transition);
			 }
        	 //for (Transition transition : WorkerList){
        		 //System.out.printf("worker %s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
                  
        	 //}
        	 //System.out.printf("dotua-----%n");
        	
            int ItemsCount=WorkerList.size();
            int CurrentPos = 0;
            while(CurrentPos<ItemsCount)
            {    
            	//System.out.printf("while %s %s %s %n", i, CurrentPos, ItemsCount);
            	   int preku = WorkerList.get(CurrentPos).startState;
            	   //System.out.println(preku);
            	//   if (preku!=i) 
	            	   for (Transition transition : TrEndTau.get(preku))
	                   {   
	            		   //if ((transition.startState!=preku)&&(transition.startState!=i))
	            		   //{
	            		   if (TrEndTau.get(i).add(Transition.FromTriple(transition.startState, Tau, i)))
	                       {
	                    	   WorkerList.add(Transition.FromTriple(transition.startState, Tau, i));
	                           ItemsCount++;
	                           //System.out.printf("tau %s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
	                           //System.out.printf("rb %s %s %s %s %n", i, rb.startState, rb.label, rb.endState);
	                       }
	            		   //}
					    }
                    CurrentPos++;
            }
            WorkerList.clear();
        }
        //System.out.printf("Cekor 2zavr %n");
        // console_Debug
       /* for (int i = 0; i < numberOfStates; i++){
        	for (Transition transition : TrEndTau.get(i))
        		System.out.printf("%s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
        }*/
        
        // Tret cekor : PaQ, Q#R -> PaR
        
        for (int i = 0; i < numberOfStates; i++)
        {
        	 for (Transition transition : TrEndDrugi.get(i)) 
        	 {
				WorkerList.add(transition);
			 }
        	 //for (Transition transition : WorkerList){
        		 //System.out.printf("worker %s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
        	 //}
        	 //System.out.printf("dotua-----%n");
            int ItemsCount=WorkerList.size();
            int CurrentPos = 0;
            while(CurrentPos<ItemsCount)
            {    
            	//System.out.printf("while %s %s %s %n", i, CurrentPos, ItemsCount);
            	   int preku = WorkerList.get(CurrentPos).startState;
            	   String CurLabel=WorkerList.get(CurrentPos).label;
            	   //System.out.println(preku);
            	  // if (preku!=i) 
	            	   for (Transition transition : TrEndTau.get(preku))
	                   {   
	            		//   if (transition.startState!=preku)
	            		  // {
	            		   if (TrEndDrugi.get(i).add(Transition.FromTriple(transition.startState, CurLabel, i)))
	                       {
	                    	   WorkerList.add(Transition.FromTriple(transition.startState, CurLabel, i));
	                           ItemsCount++;
	                           //System.out.printf("drugidrugi %s %s %s %s %n", i, transition.startState, CurLabel, transition.endState);
	                           //System.out.printf("rb %s %s %s %s %n", i, rb.startState, rb.label, rb.endState);
	                       }
	            		   //}
	                   }
            	   CurrentPos++;
            }
            WorkerList.clear();
        }
        //System.out.printf("Cekor 3zavr %n");
        
        // Cetvrt cekor : P#Q, QaR -> PaR
        // Prvo ke gi stavime vo drugi mnozestva koi se "bucket"-i, ama po pocetniot element

        ArrayList<HashSet<Transition>> TrStartTau = new ArrayList<HashSet<Transition>>();
        ArrayList<HashSet<Transition>> TrStartDrugi = new ArrayList<HashSet<Transition>>();

        for (int i = 0; i < numberOfStates; i++)
        {
        	HashSet<Transition> MnozestvoTau = new HashSet<Transition>();
        	TrStartTau.add(MnozestvoTau);
            HashSet<Transition> MnozestvoDrugi = new HashSet<Transition>();
            TrStartDrugi.add(MnozestvoDrugi);
        }
        for (int i = 0; i < numberOfStates; i++)
        {
        	for (Transition transition : TrEndTau.get(i)) { TrStartTau.get(transition.startState).add(transition); }
        	TrEndTau.get(i).clear();
        	for (Transition transition : TrEndDrugi.get(i)) { TrStartDrugi.get(transition.startState).add(transition); }
        	TrEndDrugi.get(i).clear();
        }
        for (int i = 0; i < numberOfStates; i++)
        {
        	 for (Transition transition : TrStartDrugi.get(i)) 
        	 {
				WorkerList.add(transition);
			 }
        	 //for (Transition transition : WorkerList){
        		 //System.out.printf("worker %s %s %s %s %n", i, transition.startState, transition.label, transition.endState);
                  
        	 //}
        	 //System.out.printf("dotua-----%n");
        	
            int ItemsCount=WorkerList.size();
            int CurrentPos = 0;
            while(CurrentPos<ItemsCount)
            {    
           	   int preku = WorkerList.get(CurrentPos).endState;
            	   String CurLabel=WorkerList.get(CurrentPos).label;
            	  // if (preku!=i) 
	            	   for (Transition transition : TrStartTau.get(preku))
	                   {   
	            	//	   if (transition.endState!=preku)
	            		  // {
	            		   if (TrStartDrugi.get(i).add(Transition.FromTriple( i,CurLabel,transition.endState)))
	                       {
	                    	   WorkerList.add(Transition.FromTriple(i, CurLabel, transition.endState));
	                           ItemsCount++;
	                       }
	            		//   }
					    }
                    CurrentPos++;
            }
            WorkerList.clear();
        }
        int numberOfTransitions=0;
        for (int i = 0; i < numberOfStates; i++){ numberOfTransitions=numberOfTransitions+TrStartDrugi.get(i).size()+TrStartTau.get(i).size();}
        
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter("Aldebaran_Graf_saturated.txt"));
		bufWriter.write(String.format("des (0, %s, %s)", numberOfTransitions,numberOfStates));
		bufWriter.newLine();
		
        for (int i = 0; i < numberOfStates; i++)
        {   for (Transition transition : TrStartDrugi.get(i))
        		bufWriter.write(String.format("(%s, %s, %s)%n", transition.startState, transition.label, transition.endState));
        	for (Transition transition : TrStartTau.get(i))
            	bufWriter.write(String.format("(%s, %s, %s)%n", transition.startState, transition.label, transition.endState));
        }
		bufWriter.flush();
		bufWriter.close();
	}
}
