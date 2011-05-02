package ii.edu.mk.parser;

import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.utils.ASTMarshaler;

import org.junit.Test;

/**
 * 
 * @author Vladimir Carevski
 */
public class ASTMarshalerTest extends BaseParserTest{

	@Test
	public void testMarshalingASTtoString() throws Exception {
		CcsOperation root = null;
		
		root = ASTDomainBuilder.INSTANCE.getRoot("a.B");
		assertThat(ASTMarshaler.marshal(root), comparesEqualTo("(.(B)(a))"));
		
		root = ASTDomainBuilder.INSTANCE.getRoot("(a.B+b.C)\\{a}");
		assertThat(ASTMarshaler.marshal(root), comparesEqualTo("(//(a)(+(.(C)(b))(.(B)(a))))"));
		
		root = ASTDomainBuilder.INSTANCE.getRoot("C=a.B");
		assertThat(ASTMarshaler.marshal(root), comparesEqualTo("(=(.(B)(a))(C))"));
		
		root = ASTDomainBuilder.INSTANCE.getRoot("(a.B+b.C)\\{a, b}");
		assertThat(ASTMarshaler.marshal(root), comparesEqualTo("(//(ba)(+(.(C)(b))(.(B)(a))))"));
	}

}