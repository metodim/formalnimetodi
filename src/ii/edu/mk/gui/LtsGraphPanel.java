package ii.edu.mk.gui;

import ii.edu.mk.io.AldebaranFile;
import ii.edu.mk.io.AldebaranFile.AldebaranFileLine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

@SuppressWarnings("serial")
public class LtsGraphPanel extends JPanel {

	private final static Dimension vpDim = new Dimension(500, 500);
	public LtsGraphPanel(){
			this.setMinimumSize(vpDim);
			this.setPreferredSize(vpDim);
			this.setMaximumSize(vpDim);
			this.setLayout(new MigLayout("fill","[100%]", "[100%]"));
	}
	
	public void drawGraph(AldebaranFile aldebaranFile){
		this.setVisible(false);
		this.removeAll();
		this.add(createGraph(aldebaranFile), "grow");
		this.setVisible(true);
	}
	
	private JPanel createGraph(AldebaranFile aldebaranFile){
		
		//find all distinct vertices that are used
		Set<Integer> vertices = new HashSet<Integer>();
		for(AldebaranFileLine line : aldebaranFile.getLines()){
			vertices.add(line.getStartState());
			vertices.add(line.getEndState());
		}
		
		Graph<Vertice, Edge> graph = new DirectedSparseMultigraph<Vertice, Edge>();
		Map<Integer, Vertice> verticeMap = new HashMap<Integer, Vertice>();
		
		//add root node and set it as initial node
		Vertice rootNode = Vertice.createVertice(aldebaranFile.getFirstState());
		rootNode.setStartNode(true);
		verticeMap.put(aldebaranFile.getFirstState(), rootNode);
		graph.addVertex(rootNode);
		vertices.remove(aldebaranFile.getFirstState());
		
		//add the rest of the nodes
		for(Integer verticeNum : vertices){
			Vertice node = Vertice.createVertice(verticeNum);
			verticeMap.put(verticeNum, node);
			graph.addVertex(node);
		}
      
		for(AldebaranFileLine line : aldebaranFile.getLines()){
			Edge edge = Edge.createEdge(line.getLabel());
			Vertice fromVertice = verticeMap.get(line.getStartState());
			Vertice toVertice = verticeMap.get(line.getEndState());
			graph.addEdge(edge, fromVertice, toVertice);
		}
		
		
	    Layout<Vertice, Edge> layout = new CircleLayout<Vertice, Edge>(graph);
	    layout.setSize(vpDim);
	    BasicVisualizationServer<Vertice, Edge> vv = new BasicVisualizationServer<Vertice, Edge>(layout);
	   
	    Transformer<Vertice,Paint> vertexPaint = new Transformer<Vertice, Paint>() {
            public Paint transform(Vertice i) {
            	if(i.getStartNode()){
            		return Color.GREEN;
            	}else{
            		return Color.YELLOW;
            	}
            }
	    };

        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
//      vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertice>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Edge>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
//        vv.getRenderer().getEdgeLabelRenderer().labelEdge(arg0, arg1, arg2, arg3)
	    
	    vv.setPreferredSize(vpDim); //Sets the viewing area size
	    return vv;
	}
	
	private static class Vertice {
		boolean startNode;
		Integer integer;
		
		private Vertice(Integer number){
			this.integer = number;
			this.startNode = false;
		}
		
		public static final Vertice createVertice(Integer number){
			return new Vertice(number);
		}
		
		public Integer getInteger() {
			return integer;
		}
		
		public void setStartNode(boolean value){
			this.startNode = value;
		}
		
		public boolean getStartNode(){
			return startNode;
		}
		
		@Override
		public String toString() {
			return integer.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			return integer.equals(((Vertice)obj).getInteger());
		}
	}
	
	private static class Edge {
		String label;
		
		private Edge(String label){
			this.label = label;
		}
		
		public static final Edge createEdge(String label){
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
			return label.equals(((Edge)obj).getLabel());
		}
	}
	
}
