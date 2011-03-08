package ii.edu.mk.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;


public class BaseTest {
	
	public static CcsParser getCcsParser(String expression){
	    CcsLexer lex = new CcsLexer(new ANTLRStringStream(expression));
	    CommonTokenStream tokens = new CommonTokenStream(lex);
	    return new CcsParser(tokens);
	}
	
	public static Ccs1Parser getCcs1Parser(String expression){
	    Ccs1Lexer lex = new Ccs1Lexer(new ANTLRStringStream(expression));
	    CommonTokenStream tokens = new CommonTokenStream(lex);
	    return new Ccs1Parser(tokens);
	}
	
	public static String ts(String str){
		return str.toString();
	}
	
}
