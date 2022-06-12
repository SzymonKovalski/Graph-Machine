package GraphDataSystem;

import java.awt.Graphics;
import java.util.List;
import java.awt.Color;
import javax.swing.JPanel;

public class DisplayGraph extends JPanel{
	int width, height;
	final int VERTEXSIZE = 15;
	
	Graph graph = Main.graph;
	List<Vertex> path = null;
	
	int rows = graph.height;
	int cols = graph.width;
	
	int rowHt;
	int rowWid;
	Graphics g;
	
	final int DEFAULTSIZE = 150;
	
	DisplayGraph() {
		setSize(width = DEFAULTSIZE, height = DEFAULTSIZE);
	    generate();
	}
	public void generate() {
		
	}
	public void paint(Graphics g) {
		width = getSize().width;
		height = getSize().height;

		rowHt = height / (rows);
		rowWid = width / (cols);
		this.g = g;
		drawEdges();
		drawVerteces();
		if(path!=null) {
			drawPath();
		}
	 }
	
	private void drawEdges() {
		for (Vertex element1 :graph.vertices){
			int index1 = element1.getName();
			int x1 = (index1)%cols; //which column
			int y1 = (index1)/cols; //which row
			for (Edge element2: element1.edges) {
				
				g.setColor(colorSpectrum(element2));
				
				int index2 =  element2.getTargetVertex().getName();
				int x2 = (index2)%cols; //which column
				int y2 = (index2)/cols; //which row
				g.drawLine(x1*rowHt+VERTEXSIZE/2, y1*rowWid+VERTEXSIZE/2, x2*rowHt+VERTEXSIZE/2, y2*rowWid+VERTEXSIZE/2);
			}
		}
	}
	private void drawVerteces() {
		for (Vertex element1 :graph.vertices){
			int index1 = element1.getName();
			int x1 = (index1)%cols; //which column
			int y1 = (index1)/cols; //which row
			
			g.setColor(Color.white);
			g.drawOval(x1*rowHt, y1*rowWid, VERTEXSIZE, VERTEXSIZE);
			g.fillOval(x1*rowHt, y1*rowWid, VERTEXSIZE, VERTEXSIZE);
			g.setColor(Color.black);
			g.drawString(Integer.toString(index1), x1*rowHt, y1*rowWid +10);
		}
	}
	public void updateUI(List<Vertex> path) {
		this.path = path;
		DisplayGraph.this.repaint();
	}
	private void drawPath() {
		g.setColor(Color.black);
		//g.setStroke(new BasicStroke(2));
		for (int i=0; i<path.size()-1;i++) {
			int index1 = path.get(i).getName();
			int x1 = (index1)%cols; //which column
			int y1 = (index1)/cols; //which row
			int index2 = path.get(i+1).getName();
			int x2 = (index2)%cols; //which column
			int y2 = (index2)/cols; //which row
			g.drawLine(x1*rowHt+VERTEXSIZE/2, y1*rowWid+VERTEXSIZE/2, x2*rowHt+VERTEXSIZE/2, y2*rowWid+VERTEXSIZE/2);
		}
	}
	private Color colorSpectrum(Edge e) {
		// B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!
		Color C = Color.magenta;
		if(e.getWeight() >20)
			C = Color.blue;
		if(e.getWeight() >40)
			C = Color.green;
		if(e.getWeight() >60)
			C = Color.orange;
		if(e.getWeight() >80)
			C = Color.red;
		return C;
	}
}