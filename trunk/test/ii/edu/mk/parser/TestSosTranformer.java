package ii.edu.mk.parser;

import ii.edu.mk.ccs.SosGraphNode;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosRuleType;
import ii.edu.mk.ccs.SosTransformer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSosTranformer extends BaseParserTest {

	@Test
	public void test_simple() throws Exception {

		SosGraphNode graph = new SosTransformer().generateLtsGraph(new ASTDomainBuilder().getRoot("A = a.A"));
		assertThat(graph.getTransitions().size(), comparesEqualTo(1));

		SosRule r = graph.getTransitions().keySet().iterator().next();
		assertThat(r.getType(), comparesEqualTo(SosRuleType.ACT));

		SosGraphNode next = graph.getTransitions().values().iterator().next();
		assertEquals(next, graph);
	}

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
	public void test_restrict_tau_multiple_processes() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("I = (A|B)\\{a}"),

		new ASTDomainBuilder().getRoot("A = _a.0"),

		new ASTDomainBuilder().getRoot("B = a.0")));
	}

	@Test
	public void test_alt_bit() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		ASTDomainBuilder.INSTANCE.getRoot("I=(S|T|R|A)\\{send0,send1,receive0,receive1,reply0,reply1,ack0,ack1}"),

		ASTDomainBuilder.INSTANCE.getRoot("S=_send0.S+ack0.accept.S1+ack1.S"),

		ASTDomainBuilder.INSTANCE.getRoot("S1=_send1.S1+ack1.accept.S1+ack0.S1"),

		ASTDomainBuilder.INSTANCE.getRoot("T=send0.T1+send1.T2"),

		ASTDomainBuilder.INSTANCE.getRoot("T1=_receive0.T+#.T+_receive0.T1"),

		ASTDomainBuilder.INSTANCE.getRoot("T2=_receive1.T+#.T+_receive1.T2"),

		ASTDomainBuilder.INSTANCE.getRoot("R=receive0.deliver.R1+reply1.R+receive1.R"),

		ASTDomainBuilder.INSTANCE.getRoot("R1=receive1.deliver.R+reply0.R1+receive0.R1"),

		ASTDomainBuilder.INSTANCE.getRoot("A=reply0.A1+reply1.A2"),

		ASTDomainBuilder.INSTANCE.getRoot("A1=_ack0.A+#.A+_ack0.A1"),

		ASTDomainBuilder.INSTANCE.getRoot("A2=_ack1.A+#.A+_ack1.A2")

		).get(0));
	}

	@Test
	public void test_restrict_tau_multiple_processes1() throws Exception {
		print(new SosTransformer().generateLtsGraph(

		new ASTDomainBuilder().getRoot("A = (a.B|_a.B)\\{a}"),

		new ASTDomainBuilder().getRoot("B = b.0")));
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

	List<SosGraphNode> visited = new ArrayList<SosGraphNode>();

	private void print(SosGraphNode graph, String prefix, int level) {
		if (graph.getTransitions().keySet().size() == 0)
			return;

		if (visited.contains(graph))
			return;

		visited.add(graph);
		for (SosRule sosRule : graph.getTransitions().keySet()) {
			SosGraphNode next = graph.getTransitions().get(sosRule);

			System.out.println(prefix + "\t" + sosRule.getSymbol() + "\t" + next.getName() + ": " + next.getCcsTree());

			if (!next.isForestRoot())
				print(next, prefix + "\t\t\t", level + 1);
		}
	}
}
