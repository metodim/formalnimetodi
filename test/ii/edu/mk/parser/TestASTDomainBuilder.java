package ii.edu.mk.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ii.edu.mk.ccs.domain.CcsAdd;
import ii.edu.mk.ccs.domain.CcsProcess;
import ii.edu.mk.ccs.domain.CcsRestrict;
import ii.edu.mk.ccs.domain.CcsTrans;
import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

import org.junit.Test;

public class TestASTDomainBuilder extends BaseParserTest {

	@Test
	public void testRecursive1() throws Exception {

		CcsOperation root = ASTDomainBuilder.INSTANCE.getRoot("a.B");
		assertEquals(OperatorType.TRANSITION, root.getType());

		assertTrue(root instanceof CcsTrans);
		assertEquals("a", ((CcsTrans) root).getAction().getName());

		assertEquals(OperatorType.PROCESS, ((CcsTrans) root).getRight().getType());
		assertTrue(((CcsTrans) root).getRight() instanceof CcsProcess);
		assertEquals("B", ((CcsTrans) root).getRight().getName());
	}

	@Test
	public void testRecursive2() throws Exception {

		CcsOperation root = ASTDomainBuilder.INSTANCE.getRoot("(a.B+b.C)\\{a}");
		assertEquals(root.getType(), OperatorType.RESTRICTION);

		assertTrue(root instanceof CcsRestrict);
		assertEquals(1, ((CcsRestrict) root).getRestrictedActions().size());
		assertEquals("a", ((CcsRestrict) root).getRestrictedActions().get(0).getName());

		assertTrue(((CcsRestrict) root).getOperand() instanceof CcsAdd);
		CcsAdd add = (CcsAdd) ((CcsRestrict) root).getOperand();
		assertTrue(add.getLeft() instanceof CcsTrans);
		assertTrue(add.getRight() instanceof CcsTrans);
		CcsTrans left = (CcsTrans) add.getLeft();
		CcsTrans right = (CcsTrans) add.getRight();

		assertEquals("a", left.getAction().getName());
		assertEquals("B", left.getRight().getName());
		assertTrue(left.getRight() instanceof CcsProcess);

		assertEquals("b", right.getAction().getName());
		assertEquals("C", right.getRight().getName());
		assertTrue(right.getRight() instanceof CcsProcess);
	}
	
	@Test
	public void testNonRecursive1() throws Exception {

		CcsOperation root = ASTDomainBuilder.INSTANCE.getRootNoRecursion("a.B");
		assertEquals(OperatorType.TRANSITION, root.getType());

		assertTrue(root instanceof CcsTrans);
		assertEquals("a", ((CcsTrans) root).getAction().getName());

		assertEquals(OperatorType.PROCESS, ((CcsTrans) root).getRight().getType());
		assertTrue(((CcsTrans) root).getRight() instanceof CcsProcess);
		assertEquals("B", ((CcsTrans) root).getRight().getName());
	}
	
	@Test
	public void testNonRecursive2() throws Exception {

		CcsOperation root = ASTDomainBuilder.INSTANCE.getRootNoRecursion("(a.B+b.C)\\{a}");
		assertEquals(root.getType(), OperatorType.RESTRICTION);

		assertTrue(root instanceof CcsRestrict);
		assertEquals(1, ((CcsRestrict) root).getRestrictedActions().size());
		assertEquals("a", ((CcsRestrict) root).getRestrictedActions().get(0).getName());

		assertTrue(((CcsRestrict) root).getOperand() instanceof CcsAdd);
		CcsAdd add = (CcsAdd) ((CcsRestrict) root).getOperand();
		assertTrue(add.getLeft() instanceof CcsTrans);
		assertTrue(add.getRight() instanceof CcsTrans);
		CcsTrans left = (CcsTrans) add.getLeft();
		CcsTrans right = (CcsTrans) add.getRight();

		assertEquals("a", left.getAction().getName());
		assertEquals("B", left.getRight().getName());
		assertTrue(left.getRight() instanceof CcsProcess);

		assertEquals("b", right.getAction().getName());
		assertEquals("C", right.getRight().getName());
		assertTrue(right.getRight() instanceof CcsProcess);
	}
}
