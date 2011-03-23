package ii.edu.mk.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;


public class BaseTest {
	
	public static Ccs2Parser getCcs2Parser(String expression){
	    Ccs2Lexer lex = new Ccs2Lexer(new ANTLRStringStream(expression));
	    CommonTokenStream tokens = new CommonTokenStream(lex);
	    return new Ccs2Parser(tokens);
	}
	
	public static String ts(String str){
		return str.toString();
	}
	
}
