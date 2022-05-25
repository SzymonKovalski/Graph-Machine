package GraphDataSystem;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Set;

import javax.swing.*;
import java.util.Set;
public class Djikstra extends JPanel implements ActionListener{
	Graph graph;
	int startingPoint;
	int endingPoint;
	int arraySize;
	
	int[] shortestDFromStart;
	Vertex[] previousVertex;
	
	JButton button = new JButton("Djikstra");
	JTextField fromTF = new JTextField();
	JTextField toTF = new JTextField();
	
	public void delveDeeper(Vertex start, boolean[] visited) {// this looks fishy. what when there is no vertex
		Vertex element1 = start;
		boolean[] localVisited = new boolean[arraySize];
		localVisited = visited;
		localVisited[start.index] = true;
		int i =0;
		
		
		for(Edge element2: element1.edges) {

			//1 check if edge doesnt goes to a visited zone
			
			//2 order the valid outs from least costly to most
			
			//3 call itself again for each of them
			
			//local array to keep track of vertices a path has been in?
			//sacrifices?
		}
	}
	
	private void djikstraAlgorythm() {
		//read from text fields if they worked
		startingPoint = 1;
		endingPoint = 15;
		
		shortestDFromStart[startingPoint] = 0;
		//delveDeeper(graph.getVertex(startingPoint));
	}
	
	public Djikstra(Graph graph){
		this.graph = graph;
		arraySize = graph.vertices.size();
		shortestDFromStart = new int[arraySize];
		previousVertex = new Vertex[arraySize];
		
		for (int i=0; i<arraySize; i++) {
			shortestDFromStart[i] = 99999999;
		}
		
		
		fromTF.setSize(10, 40);
		toTF.setSize(40, 10);  //why the fuck arent these working
		button.setSize(40, 10);
		button.addActionListener(this);
		this.add(fromTF, BorderLayout.WEST);
		this.add(toTF, BorderLayout.WEST);
	    this.add(button, BorderLayout.WEST);
	    this.setSize(40,40);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			djikstraAlgorythm();
		}
	}
}
