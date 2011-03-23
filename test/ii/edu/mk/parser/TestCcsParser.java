package ii.edu.mk.parser;

//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class TestCcsParser extends BaseTest{

	@Test
	public void testValidExpressions() throws RecognitionException{
		Ccs2Parser parser = getCcs2Parser(ts("A=B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("a.b.A + B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
//		parser = getCcsParser(ts("(a.0 + _a.A)\\{a,b}"));parser.expr();
//		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
//		
//		parser = getCcsParser(ts("(a.0 | _a.A)\\{a,#}"));parser.expr();
//		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("#.#.B + 0"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("(a.B + b.B)[a/b, b/a]"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("(a.B + #.B)[a/#, b/a]"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		
		parser = getCcs2Parser(ts("(a.b.A + _a.0)|B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		// TODO Dragan: I think that this CCS should fail
		// parser = getCcs1Parser(ts("(a.b.A + _a.0).B"));parser.expr();
		// assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("(a.b.A + _a.0)+B"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("(0 | 0) + 0"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
		
		parser = getCcs2Parser(ts("A=B\\{a}+(a.b|(b.c.d+d.c)\\{c,a}|C)\\{a}"));parser.expr();
		assertThat(parser.getNumberOfSyntaxErrors(), comparesEqualTo(0));
	}
	
	@Test
	public void testNotValidExpressions(){
		Ccs2Parser parser;
		try{
			String expr = "A=B.";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "a.b.A. + B";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "a.0 + _a.A)\\{a,b}";
			parser = getCcs2Parser(ts(expr));parser.expr();
			System.out.println(parser.getNumberOfSyntaxErrors());
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		
		try{
			String expr = "(a.0 | _a.A)\\{a,#}";
			parser = getCcs2Parser(ts(expr));parser.expr();
			System.out.println(parser.toString());
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}
		catch (RuntimeException e) {}
		
		try{
			String expr = "a.B + [a/b]";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//NoViableAlternative
		
		try{
			String expr = "#.#.B + (0";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//MismatchTokenException
		
		try{
			String expr = "(a.B + aBb.B)/[a/b, b/a]";
			parser = getCcs2Parser(ts(expr));parser.expr();
			System.out.println(parser.getNumberOfSyntaxErrors());
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//MismatchTokenException
		
		try{
			String expr = "(a.B + asd(0) #.B)[a/#, b/a]";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//MismatchTokenException
		
		try{
			String expr = "(a.b.A + __a.0)|B";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}
		catch (RecognitionException e) {}//MismatchTokenException
		catch (RuntimeException e) {}//MismatchTokenException
		
		try{
			String expr = "(a_A.b.A + _a.0).B";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//MismatchTokenException
		
		try{
			String expr = "(a.b.A + _a.0(())))+B";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//MismatchTokenException
		
		try{
			String expr = "(a.b.A + _a.0.(())))+B";
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//NoViableAlternative
		
		try{
			String expr = "(0 ||| 0) + 0"; 
			parser = getCcs2Parser(ts(expr));parser.expr();
			fail("Expression: " + expr + " should not be recognized by the lexer");
		}catch (RecognitionException e) {}//NoViableAlternative
		
	}
	
}
