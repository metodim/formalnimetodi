package ii.edu.mk.parser;

//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class TestCcs1Parser extends BaseTest{

	@Test
	public void testValidExpressions() throws RecognitionException{
		Ccs1Parser parser = getCcs1Parser(ts("A=B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("a.b.A + B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
//		parser = getCcs1Parser(ts("(a.0 + _a.A)\\{a,b}"));parser.expr();
//		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
//		
//		parser = getCcs1Parser(ts("(a.0 | _a.A)\\{a,#}"));parser.expr();
//		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
//		parser = getCcs1Parser(ts("a.B + [a/b]"));parser.expr();
//		assertThat(parser.getNumberOfSyntaxErrors(),is(0));
		
		parser = getCcs1Parser(ts("#.#.B + 0"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("(a.B + b.B)[a/b, b/a]"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("(a.B + #.B)[a/#, b/a]"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		
		parser = getCcs1Parser(ts("(a.b.A + _a.0)|B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("(a.b.A + _a.0).B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("(a.b.A + _a.0)+B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs1Parser(ts("(0 | 0) + 0"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
	}
	
	@Test
	public void testNotValidExpressions(){
		Ccs1Parser parser;
		try{
			String expr = "A=B.";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "a.b.A. + B";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
//		try{
//			String expr = "a.0 + _a.A)\\{a,b}";
//			parser = getCcs1Parser(ts(expr));parser.expr();
//			fail("Expression: " + expr + " should not be recognized by the lexer");
//		}catch (RecognitionException e) {}
//		
//		try{
//			String expr = "(a.0 | _a.A)\\{a,#}";
//			parser = getCcs1Parser(ts(expr));parser.expr();
//			fail("Expression: " + expr + " should not be recognized by the lexer");
//		}catch (RecognitionException e) {}
		
//		try{
//			String expr = "a.B + [a/b]";
//			parser = getCcs1Parser(ts(expr));parser.expr();
//			fail("Expression: " + expr + " should not be recognized by the lexer");
//		}catch (RecognitionException e) {}
		
		try{
			String expr = "#.#.B + (0";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a.B + aBb.B)/[a/b, b/a]";
			parser = getCcs1Parser(ts(expr));parser.expr();
			System.out.println(parser.getNumberOfSyntaxErrors());
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a.B + asd(0) #.B)[a/#, b/a]";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a.b.A + __a.0)|B";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a_A.b.A + _a.0).B";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a.b.A + _a.0(())))+B";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(0 ||| 0) + 0";
			parser = getCcs1Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
	}
	
}
