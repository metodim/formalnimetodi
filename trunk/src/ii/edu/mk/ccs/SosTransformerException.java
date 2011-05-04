package ii.edu.mk.ccs;

@SuppressWarnings("serial")
public class SosTransformerException extends Exception{

	public SosTransformerException() {
		super("Error while creating LTS graph");
	}
	
	public SosTransformerException(String message) {
		super(message);
	}
}
