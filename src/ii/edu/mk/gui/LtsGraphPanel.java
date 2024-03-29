package ii.edu.mk.gui;

import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranFile.AldebaranFileLine;

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
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.commons.collections15.Transformer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * Panel for and LTS Graph generated from an {@link AldebaranFile}
 */
@SuppressWarnings("serial")
public class LtsGraphPanel extends JPanel {

	private final static Logger LOG = LogManager.getLogger(LtsGraphPanel.class);
	public final static Dimension VP_DIM = new Dimension(800, 600);

	public LtsGraphPanel() {
		this.setMinimumSize(VP_DIM);
		this.setPreferredSize(VP_DIM);
		this.setMaximumSize(VP_DIM);
		this.setLayout(new MigLayout("fill", "[100%]", "[35!]3px[fill]"));
	}

	/**
	 * Draws a graph from an {@link AldebaranFile}
	 */
	public void drawGraph(AldebaranFile aldebaranFile) {
		this.setVisible(false);
		this.removeAll();
		createGraph(aldebaranFile);
		this.setVisible(true);
	}

	private void createGraph(AldebaranFile aldebaranFile) {

		// find all distinct vertices that are used
		Set<Integer> vertices = new HashSet<Integer>();
		for (AldebaranFileLine line : aldebaranFile.getLines()) {
			vertices.add(line.getStartState());
			vertices.add(line.getEndState());
		}

		Graph<Vertice, Edge> graph = new DirectedSparseMultigraph<Vertice, Edge>();
		Map<Integer, Vertice> verticeMap = new HashMap<Integer, Vertice>();

		// 1. add root node and set it as initial node
		Vertice rootNode = Vertice.createVertice(aldebaranFile.getFirstState());
		rootNode.setStartNode(true);
		verticeMap.put(aldebaranFile.getFirstState(), rootNode);
		graph.addVertex(rootNode);
		vertices.remove(aldebaranFile.getFirstState());

		// 2. add the rest of the nodes
		for (Integer verticeNum : vertices) {
			Vertice node = Vertice.createVertice(verticeNum);
			verticeMap.put(verticeNum, node);
			graph.addVertex(node);
		}

		// 3. connect the edges to the vertices
		for (AldebaranFileLine line : aldebaranFile.getLines()) {
			Edge edge = Edge.createEdge(line.getLabel());
			Vertice fromVertice = verticeMap.get(line.getStartState());
			Vertice toVertice = verticeMap.get(line.getEndState());
			graph.addEdge(edge, fromVertice, toVertice);
		}

		Layout<Vertice, Edge> layout = new CircleLayout<Vertice, Edge>(graph);
		layout.setSize(VP_DIM);
		final VisualizationViewer<Vertice, Edge> vv = new VisualizationViewer<Vertice, Edge>(layout);

		final Dimension d = vv.getSize();
		vv.addPostRenderPaintable(new VisualizationViewer.Paintable() {
			int x;
			int y;
			Font font;
			FontMetrics metrics;
			int swidth;
			int sheight;
			String str = "LTS Graph";

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
			public Paint transform(Vertice i) {
				if (i.getStartNode()) {
					return Color.GREEN;
				} else {
					return Color.YELLOW;
				}
			}
		};

		vv.addGraphMouseListener(new TestGraphMouseListener<Vertice>());
//		vv.getRenderer().setVertexRenderer(new GradientVertexRenderer<Vertice, Edge>(Color.white, Color.red, Color.white, Color.blue, vv.getPickedVertexState(), false));
		
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		// vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertice>());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Edge>());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		// vv.getRenderer().getEdgeLabelRenderer().labelEdge(arg0, arg1, arg2, arg3)

		vv.setPreferredSize(VP_DIM); // Sets the viewing area size
		
		final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
		final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<String, Number>();
		vv.setGraphMouse(graphMouse);

		vv.addKeyListener(graphMouse.getModeKeyListener());
		vv.setToolTipText("<html><center>Type 'p' for Pick mode<p>Type 't' for Transform mode");

		final ScalingControl scaler = new CrossoverScalingControl();
		// zoom out just a bit for the initial preview
		scaler.scale(vv, 1 / 1.2f, vv.getCenter());

		//init buttons
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

		JButton reset = new JButton("Reset");
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
		
		panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		this.add(controls, "al c, wrap");
		this.add(panel, "grow");
	}

	/**
	 * A nested class to demo the GraphMouseListener finding the right vertices
	 * after zoom/pan
	 */
	static class TestGraphMouseListener<V> implements GraphMouseListener<V> {

		public void graphClicked(V v, MouseEvent me) {
			LOG.debug("Vertex " + v + " was clicked at (" + me.getX() + "," + me.getY() + ")");
		}

		public void graphPressed(V v, MouseEvent me) {
			LOG.debug("Vertex " + v + " was pressed at (" + me.getX() + "," + me.getY() + ")");
		}

		public void graphReleased(V v, MouseEvent me) {
			LOG.debug("Vertex " + v + " was released at (" + me.getX() + "," + me.getY() + ")");
		}
	}
	
	private static class Vertice {
		boolean startNode;
		Integer integer;

		private Vertice(Integer number) {
			this.integer = number;
			this.startNode = false;
		}

		public static final Vertice createVertice(Integer number) {
			return new Vertice(number);
		}

		public Integer getInteger() {
			return integer;
		}

		public void setStartNode(boolean value) {
			this.startNode = value;
		}

		public boolean getStartNode() {
			return startNode;
		}

		@Override
		public String toString() {
			return integer.toString();
		}

		@Override
		public boolean equals(Object obj) {
			return integer.equals(((Vertice) obj).getInteger());
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

		public String getLabel() {
			return label;
		}

		@Override
		public String toString() {
			return label;
		}

		@Override
		public boolean equals(Object obj) {
			return label.equals(((Edge) obj).getLabel());
		}
	}

}
