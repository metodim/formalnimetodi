package ii.edu.mk.parser;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosTransformer;

import org.junit.Test;

public class TestSosTranformer extends BaseParserTest {

	@Test
	public void test1() throws Exception {
		print(new SosTransformer().buildSosGraph(new SosGraphNode("A", new ASTDomainBuilder().getRoot("a.B"))));
//		print(new SosTransformer().buildSosGraph(new SosGraphNode("A", new ASTDomainBuilder().getRoot("a.A+b.B"))));
//		print(new SosTransformer().buildSosGraph(new SosGraphNode("A", new ASTDomainBuilder().getRoot("a.A|_a.B"))));
//		print(new SosTransformer().buildSosGraph(new SosGraphNode("A", new ASTDomainBuilder().getRoot("a.A|_a.B+c.C"))));
//		print(new SosTransformer().buildSosGraph(new SosGraphNode("A", new ASTDomainBuilder().getRoot("a.A|_a.B+c.C+d.D"))));
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

			print(next, prefix + "\t\t\t", level + 1);
		}
	}
}
