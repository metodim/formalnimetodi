package ii.edu.mk.saturation;

public class Transition {
        public int startState;
        public String label;
        public int endState;
        private volatile int hashCode = 0;
        
        public static Transition FromString(String line)
        {
        	 Transition rebro = new Transition();
             
             String[] comps = line.split(",+");
             rebro.startState = Integer.parseInt(comps[0].split("\\(")[1].replaceAll(" +", ""));
             rebro.endState = Integer.parseInt(comps[2].split("\\)")[0].replaceAll(" +", ""));
             rebro.label = comps[1].replaceAll(" +", "");
             return rebro;
 			   ///return new AldebaranFileLine(start, comps[1].replaceAll(" +", ""), end);
        }
        public static Transition FromTriple(int ss, String l, int es)
        { 
        	Transition rebro = new Transition();
        	rebro.startState=ss;
        	rebro.label=l;
        	rebro.endState=es;
        	return rebro;
        }
     @Override
    public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    	 if ( this == obj)
    	 {
    		 return true;
    	 }
    	 if ( ! (obj instanceof Transition))
    			 {
    		 		return false;
    			 }
    	 Transition rebro = (Transition) obj;
    	 return startState == rebro.startState && endState == rebro.endState && label.equals(rebro.label);
    //return super.equals(arg0);
    	 }
    	     @Override 
    	    public int hashCode() {
    	    // TODO Auto-generated method stub
    	    	 final int multiplier=23;
    	    	 if (hashCode == 0)
    	    	 {
    	    		 int code = 133;
    	    		 code = multiplier * code + startState;
    	    		 code = multiplier * code + endState;
    	    		 code = multiplier * code + label.hashCode();
    	    		 hashCode = code;
    	    	 }
    	    return hashCode;
    	    }
}
