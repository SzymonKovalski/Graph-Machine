package GraphDataSystem;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Main extends JFrame{
	final static int RANDMIN = 1;
	final static int RANDMAX = 100;
	final static int HEIGHT = 4;
	final static int WIDTH = 4;
	static Graph graph;
	public Main() {
        graph = new Graph(HEIGHT, WIDTH, RANDMIN, RANDMAX);
        Djikstra djikstra = new Djikstra(graph);
        //djikstra.computePath(graph.getVertex(1));
        DisplayGraph displaygraph = new DisplayGraph(150, 150, HEIGHT, WIDTH, graph);

        //System.out.println(djikstra.getShortestPathTo(graph.getVertex(4)));
        
        JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JToolBar toolbar = new JToolBar();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
	    panel.setLayout(new BorderLayout());
		
	    toolbar.add(djikstra);
	    toolbar.add(new SaveSystem(graph));
	    
	    panel.add(toolbar,BorderLayout.NORTH);
	    panel.add(displaygraph);
	    
	    frame.add(panel, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	    //debug. The bloody graph is generated wrong!
	    System.out.println(graph.getVertex(15));
    }
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
