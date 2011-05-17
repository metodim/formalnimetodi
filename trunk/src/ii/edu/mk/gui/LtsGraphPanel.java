package ii.edu.mk.gui;

import ii.edu.mk.ccs.SosGraphNode;
import ii.edu.mk.ccs.SosRule;
import ii.edu.mk.io.AldebaranFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.AbstractModalGraphMouse;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.GradientVertexRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * Panel for and LTS Graph generated from an {@link AldebaranFile}
 */
@SuppressWarnings("serial")
public class LtsGraphPanel extends JPanel {

	private final static Dimension vpDim = new Dimension(500, 500);

	public LtsGraphPanel() {
		this.setMinimumSize(vpDim);
		this.setPreferredSize(vpDim);
		this.setMaximumSize(vpDim);
		this.setLayout(new MigLayout("fill", "[100%]", "[100%]"));
	}

	/**
	 * Draws a graph from an {@link SosGraphNode}
	 */
	public void drawGraph(SosGraphNode graph) {
		this.setVisible(false);
		this.removeAll();
		createGraph(graph);
		// this.add(createGraph(graph), "grow");
		this.setVisible(true);
	}

	/**
	 * The zoom and scroll pane is taken from
	 * {@link edu.uci.ics.jung.samples.GraphZoomScrollPaneDemo}
	 */
	private void createGraph(SosGraphNode ltsGraph) {

		Graph<Vertice, Edge> graph = new DirectedSparseMultigraph<Vertice, Edge>();
		Map<String, Vertice> verticeMap = new HashMap<String, Vertice>();

		// 1. add root node and set it as initial node
		Vertice rootNode = Vertice.createVertice(ltsGraph.getName());
		rootNode.startNode = true;
		verticeMap.put(rootNode.label, rootNode);

		HashSet<SosGraphNode> visited = new HashSet<SosGraphNode>();
		Stack<SosGraphNode> stack = new Stack<SosGraphNode>();
		stack.push(ltsGraph);
		while (!stack.empty()) {
			SosGraphNode currentNode = stack.pop();
			if (!verticeMap.containsKey(currentNode.getName()))
				verticeMap.put(currentNode.getName(), Vertice.createVertice(currentNode.getName()));

			for (SosRule rule : currentNode.getTransitions().keySet()) {
				SosGraphNode nextNode = currentNode.getTransitions().get(rule);
				if (!verticeMap.containsKey(nextNode.getName()))
					verticeMap.put(nextNode.getName(), Vertice.createVertice(nextNode.getName()));

				if (!visited.contains(nextNode)) {
					stack.push(nextNode);
					visited.add(nextNode);
				}

				graph.addEdge(Edge.createEdge(rule.toString()), verticeMap.get(currentNode.getName()), verticeMap.get(nextNode.getName()));
			}
		}

		Layout<Vertice, Edge> layout = new CircleLayout<Vertice, Edge>(graph);
		layout.setSize(vpDim);
		final VisualizationViewer<Vertice, Edge> vv = new VisualizationViewer<Vertice, Edge>(layout);

		final Dimension d = vv.getSize();
		vv.addPostRenderPaintable(new VisualizationViewer.Paintable() {
			int x;
			int y;
			Font font;
			FontMetrics metrics;
			int swidth;
			int sheight;
			String str = "GraphZoomScrollPane Demo";

			public void paint(Graphics g) {

				if (font == null) {
					font = new Font(g.getFont().getName(), Font.BOLD, 30);
					metrics = g.getFontMetrics(font);
					swidth = metrics.stringWidth(str);
					sheight = metrics.getMaxAscent() + metrics.getMaxDescent();
					x = (d.width - swidth) / 2;
					y = (int) (d.height - sheight * 1.5);
				}
				g.setFont(font);
				Color oldColor = g.getColor();
				g.setColor(Color.lightGray);
				g.drawString(str, x, y);
				g.setColor(oldColor);
			}

			public boolean useTransform() {
				return false;
			}
		});

		Transformer<Vertice, Paint> vertexPaint = new Transformer<Vertice, Paint>() {
			public Paint transform(Vertice v) {
				if (v.startNode) {
					return Color.GREEN;
				} else {
					return Color.YELLOW;
				}
			}
		};

		vv.addGraphMouseListener(new TestGraphMouseListener<Vertice>());
		vv.getRenderer().setVertexRenderer(new GradientVertexRenderer<Vertice, Edge>(Color.white, Color.red, Color.white, Color.blue, vv.getPickedVertexState(), false));

		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		// vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertice>());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Edge>());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		// vv.getRenderer().getEdgeLabelRenderer().labelEdge(arg0, arg1, arg2,
		// arg3)

		vv.setPreferredSize(vpDim); // Sets the viewing area size

		final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
		this.add(panel);
		final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<String, Number>();
		vv.setGraphMouse(graphMouse);

		vv.addKeyListener(graphMouse.getModeKeyListener());
		vv.setToolTipText("<html><center>Type 'p' for Pick mode<p>Type 't' for Transform mode");

		final ScalingControl scaler = new CrossoverScalingControl();
		// zoom out just a bit for the initial preview
		scaler.scale(vv, 1 / 1.2f, vv.getCenter());

		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scaler.scale(vv, 1.1f, vv.getCenter());
			}
		});
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scaler.scale(vv, 1 / 1.1f, vv.getCenter());
			}
		});

		JButton reset = new JButton("reset");
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).setToIdentity();
				vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW).setToIdentity();
			}
		});

		JPanel controls = new JPanel();
		controls.add(plus);
		controls.add(minus);
		controls.add(reset);
		this.add(controls, BorderLayout.SOUTH);
	}

	/**
	 * A nested class to demo the GraphMouseListener finding the right vertices
	 * after zoom/pan
	 */
	static class TestGraphMouseListener<V> implements GraphMouseListener<V> {

		public void graphClicked(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was clicked at (" + me.getX() + "," + me.getY() + ")");
		}

		public void graphPressed(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was pressed at (" + me.getX() + "," + me.getY() + ")");
		}

		public void graphReleased(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was released at (" + me.getX() + "," + me.getY() + ")");
		}
	}

	private static class Vertice {
		boolean startNode;
		String label;

		private Vertice(String number) {
			this.label = number;
			this.startNode = false;
		}

		public static final Vertice createVertice(String number) {
			return new Vertice(number);
		}

		@Override
		public String toString() {
			return label.toString();
		}

		@Override
		public boolean equals(Object obj) {
			return label.equals(((Vertice) obj).label);
		}
	}

	private static class Edge {
		String label;

		private Edge(String label) {
			this.label = label;
		}

		public static final Edge createEdge(String label) {
			return new Edge(label);
		}

		@Override
		public String toString() {
			return label;
		}

		@Override
		public boolean equals(Object obj) {
			return label.equals(((Edge) obj).label);
		}
	}

}
