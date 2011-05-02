package ii.edu.mk.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	 TestCcsParser.class
	,ASTMarshalerTest.class
	,TestASTDomainBuilder.class
//	,TestSosTranformer.class
})
public class AllParserTests {

}
