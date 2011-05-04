package ii.edu.mk.io;

import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosRuleType;
import ii.edu.mk.ccs.domain.CcsAction;
import ii.edu.mk.core.BaseTest;
import ii.edu.mk.parser.ASTMarshaler;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @author Vladimir Carevski
 */
public class TestAldebaranIO extends BaseTest{

	@Test
	public void testAldebaranIO() throws IOException{
		File fileIn = getTestResourceFile("alt_bit.aut");
		File fileOut = getTestResourceFile("alt_bit_out.aut");
		
		AldebaranFile alFile = AldebaranUtils.readFile(fileIn);
		AldebaranUtils.writeFile(alFile, fileOut);
		
	}
	
	@Test
	public void testLtsToAldebaranConveter(){
		
		SosGraphNode A = new SosGraphNode("0", null);
		SosGraphNode B = new SosGraphNode("1", null);
		SosGraphNode C = new SosGraphNode("2", null);
		
		CcsAction b = new CcsAction("b");
		CcsAction c = new CcsAction("c");
		
		SosRule toB = new SosRule(SosRuleType.ACT, null, null, b);
		SosRule toC = new SosRule(SosRuleType.ACT, null, null, c);
		
		SosRule toB1 = new SosRule(SosRuleType.ACT, null, null, b);
		SosRule toC1 = new SosRule(SosRuleType.ACT, null, null, c);
		
		A.getTransitions().put(toB, B);
		A.getTransitions().put(toC, C);
		
		B.getTransitions().put(toC1, C);
		C.getTransitions().put(toB1, B);
		
		assertThat(AldebaranUtils.toString(AldebaranUtils.convert(A), false),
				comparesEqualTo("des (0, 4, 3)(0, b, 1)(0, c, 2)(1, c, 2)(2, b, 1)"));
	}
	
}
