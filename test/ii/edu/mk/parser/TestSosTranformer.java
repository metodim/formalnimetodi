package ii.edu.mk.parser;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosTransformer;

import java.util.List;

import org.junit.Test;

public class TestSosTranformer extends BaseParserTest {

	@Test
	public void test1() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = a.B")));
	}

	@Test
	public void test2() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("B = a.b.B")));
	}

	@Test
	public void test3() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = a.B|_a.B")));
	}

	@Test
	public void test4() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = a.B|_a.B+c.C")));
	}

	@Test
	public void test5() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = a.B|_a.B+c.C+d.D")));
	}

	@Test
	public void test_two_processes() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = a.B"),

		new ASTDomainBuilder().getRoot("B = b.A")));
	}

	@Test
	public void test_two_processes_that_reference_each_other1() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		ASTDomainBuilder.INSTANCE.getRoot("A = B"),

		ASTDomainBuilder.INSTANCE.getRoot("B = a.A")));
	}

	@Test
	public void test_two_processes_that_reference_each_other2() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		ASTDomainBuilder.INSTANCE.getRoot("A = a.A"),

		ASTDomainBuilder.INSTANCE.getRoot("B = A")));
	}

	private void print(List<SosGraphNode> forrest) {
		for (SosGraphNode graph : forrest)
			print(graph);
	}

	@Test
	public void test_restrict_simple() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = (a.B)\\{a}")));
	}

	@Test
	public void test_restrict_tau() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = (a.B|_a.B)\\{a, _a}")));
	}

	@Test
	public void test_restrict_tau_multiple_processes1() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (a.B|_a.B)\\{a}"),

		new ASTDomainBuilder().getRoot("B = b.0")));
	}

	@Test
	public void test_restrict_tau_multiple_processes2() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("I = (A|B)\\{a}"),

		new ASTDomainBuilder().getRoot("A = _a.A"),

		new ASTDomainBuilder().getRoot("B = a.B")));
	}

	@Test
	public void test_restrict_with_two_processes1() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (a.B)\\{a}"),

		new ASTDomainBuilder().getRoot("B = b.A")));
	}

	@Test
	public void test_restrict_reverse1() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = (a.B)\\{a}")));
	}

	@Test
	public void test_restrict_reverse2() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = (a.B)\\{_a}")));
	}

	@Test
	public void test_restrict_sync_add() throws Exception {
		print(new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = (a.B|a.C+a.D)\\{a}")));
	}

	@Test
	public void test_restrict_sync_multiple_processes() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (B|C)\\{b,c}"),

		new ASTDomainBuilder().getRoot("B = b.B"),

		new ASTDomainBuilder().getRoot("C = c.C")));
	}

	@Test
	public void test_restrict_add_multiple_processes() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (B+C)\\{b,c}"),

		new ASTDomainBuilder().getRoot("B = b.B"),

		new ASTDomainBuilder().getRoot("C = c.C")));
	}

	@Test
	public void test_restrict_with_two_processes_infinite1() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (B)\\{a}"),

		new ASTDomainBuilder().getRoot("B = b.A")));
	}

	@Test
	public void test_restrict_with_two_processes_infinite2() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		ASTDomainBuilder.INSTANCE.getRoot("B = b.A"),

		ASTDomainBuilder.INSTANCE.getRoot("A = (a.B+b.A)\\{c}")));
	}

	private void print(SosGraphNode graph) {
		System.out.println(graph.getName() + ": " + graph.getCcsTree());
		print(graph, "", 1);
		System.out.println();
	}

	private void print(SosGraphNode graph, String prefix, int level) {
		if (graph.getTransitions().keySet().size() == 0)
			return;

		for (SosRule sosRule : graph.getTransitions().keySet()) {
			SosGraphNode next = graph.getTransitions().get(sosRule);

			System.out.println(prefix + "\t" + sosRule.getSymbol() + "\t" + next.getName() + ": " + next.getCcsTree());

			if (!next.isForestRoot())
				print(next, prefix + "\t\t\t", level + 1);
		}
	}
}
