package GraphDataSystem;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
public class GridsCanvas extends JPanel{
	int width, height;
	final int VERTEXSIZE = 15;
	
	Graph graph;
	int rows;
	int cols;

	GridsCanvas(int w, int h, int rh, int cw, Graph graph) {
		setSize(width = w, height = h);
	    this.graph = graph;
	    rows = rh;
	    cols = cw;
	}

	public void paint(Graphics g) {
		width = getSize().width;
		height = getSize().height;

		int rowHt = height / (rows);
		int rowWid = width / (cols);
		
		drawEdges(g,rowHt,rowWid);
		drawVerteces(g,rowHt,rowWid);
		
	 }
	
	private void drawEdges(Graphics g, int rowWid, int rowHt) {
		for (Vertex element1 :graph.vertices){
			int index1 = element1.index;
			int x1 = (index1)%cols; //which column
			int y1 = (index1)/cols; //which row
			for (Edge element2: element1.edges) {
				
				g.setColor(colorSpectrum(element2));
				
				int index2 =  element2.to.index;
				int x2 = (index2)%cols; //which column
				int y2 = (index2)/cols; //which row
				g.drawLine(x1*rowHt+VERTEXSIZE/2, y1*rowWid+VERTEXSIZE/2, x2*rowHt+VERTEXSIZE/2, y2*rowWid+VERTEXSIZE/2);
			}
		}
	}
	private void drawVerteces(Graphics g, int rowWid, int rowHt) {
		for (Vertex element1 :graph.vertices){
			int index1 = element1.index;
			int x1 = (index1)%cols; //which column
			int y1 = (index1)/cols; //which row
			
			g.setColor(Color.white);
			g.drawOval(x1*rowHt, y1*rowWid, VERTEXSIZE, VERTEXSIZE);
			g.fillOval(x1*rowHt, y1*rowWid, VERTEXSIZE, VERTEXSIZE);
			g.setColor(Color.black);
			g.drawString(Integer.toString(index1), x1*rowHt, y1*rowWid +10);
		}
	}
	
	private Color colorSpectrum(Edge e) {
		// B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!  B A D!
		Color C = Color.magenta;
		if(e.weight >2)
			C = Color.blue;
		if(e.weight >4)
			C = Color.green;
		if(e.weight >6)
			C = Color.orange;
		if(e.weight >8)
			C = Color.red;
		return C;
	}
}
