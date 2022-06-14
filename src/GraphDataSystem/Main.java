package GraphDataSystem;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Main extends JFrame{

	public static int height = 2;
	public static int width = 3;
	
	static JFrame frame = new JFrame();
	public static Graph graph = new Graph(height, width);
	static JPanel panel = new JPanel();
	static DisplayGraph displaygraph = new DisplayGraph();
	public Main() { 
		displayAll();
    }
	private static void displayAll() {
        Djikstra djikstra = new Djikstra();
		JToolBar toolbar = new JToolBar();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
	    panel.setLayout(new BorderLayout());
		
	    toolbar.add(djikstra);
	    toolbar.add(new SaveSystem());
	    toolbar.add(new GenerateNewGraph());
	    
	    panel.add(toolbar,BorderLayout.NORTH);
	    panel.add(displaygraph);
	    
	    frame.add(panel, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	public static void updateGraph(Graph newG) {
		panel.removeAll();
		height = newG.height;
		width = newG.width;
		graph = newG;
		displaygraph = new DisplayGraph();
		displayAll();
	}
}
