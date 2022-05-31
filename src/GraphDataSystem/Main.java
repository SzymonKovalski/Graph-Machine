package GraphDataSystem;
//import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;


public class Main extends JFrame{
	final int RANDMIN = 1;
	final int RANDMAX = 10;
	final int HEIGHT = 4;
	final int WIDTH = 4;
	
	public Main() {
		Graph graph = new Graph(HEIGHT, WIDTH, RANDMIN, RANDMAX);
		GridsCanvas gridscanvas = new GridsCanvas(150, 150, HEIGHT, WIDTH, graph);

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JToolBar toolbar = new JToolBar();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
	    panel.setLayout(new BorderLayout());
		
	    toolbar.add(new Djikstra(graph));
	    toolbar.add(new SaveSystem(graph));
	    
	    panel.add(toolbar,BorderLayout.NORTH);
	    panel.add(gridscanvas);
	    
	    frame.add(panel, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);

	  }

	  public static void main(String[] a) {
	    new Main().setVisible(true);
	  }
	  
}
