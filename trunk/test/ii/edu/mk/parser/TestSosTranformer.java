package ii.edu.mk.parser;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.ccs.SosTransformer;

import org.junit.Test;

public class TestSosTranformer extends BaseTest {

	@Test
	public void test1() throws Exception {

		print(new SosTransformer().getSosGraph(new ASTDomainBuilder().getRoot("a.B")));

		print(new SosTransformer().getSosGraph(new ASTDomainBuilder().getRoot("a.A+b.B")));

		print(new SosTransformer().getSosGraph(new ASTDomainBuilder().getRoot("a.A|_a.B")));

		print(new SosTransformer().getSosGraph(new ASTDomainBuilder().getRoot("a.A|_a.B+c.C")));

		print(new SosTransformer().getSosGraph(new ASTDomainBuilder().getRoot("a.A|_a.B+c.C+d.D")));
	}

	private void print(SosGraphNode graph) {
		print(graph, "", 1);
		System.out.println();
	}

	private void print(SosGraphNode graph, String prefix, int level) {
		for (SosRule sosRule : graph.getTransitions().keySet()) {
			System.out.println(String.format("%s %d: %s", prefix, level, sosRule));
			print(graph.getTransitions().get(sosRule), prefix + "\t", level + 1);
		}
	}
}
