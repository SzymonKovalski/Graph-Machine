package GraphDataSystem;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Djikstra extends JPanel implements ActionListener{
	Graph graph;
	int startingPoint;
	int endingPoint;
	int arraySize;
	
	int[] vertices; 
	int[][] edges;
	int[] dist;
	boolean[] visited;
	
	JButton button = new JButton("Djikstra");
	JTextField fromTF = new JTextField();
	JTextField toTF = new JTextField();
	
	private void djikstraAlgorythm() {
		//read from text fields if they worked
		startingPoint = 1;
		endingPoint = 15;
		
		dist[startingPoint] = 0;
		delveDeeper(startingPoint);
		for (int i=0; i<arraySize; i++) {
			System.out.print(i + "("+ dist[i] + ") ");
		}
	}
	public void delveDeeper(int start) {// this looks fishy. what when there is no vertex
		visited[start] = true;
		for (int i=0; i<arraySize; i++) {
			if(dist[i]>edges[start][i]) {
				dist[i] = edges[start][i]; // very wrong
			}
			if(visited[i]!=true) { //if i is not on the already visited list
				delveDeeper(i);
			}
		}
	}
	
	
	
	public Djikstra(Graph graph){
		this.graph = graph;
		arraySize = graph.vertices.size();
		vertices = new int[arraySize];
		edges = new int[arraySize][arraySize];
		dist = new int[arraySize];
		visited = new boolean[arraySize];
		
		for (int i=0; i<arraySize; i++) {
			vertices[i] = 0;
			dist[i] = 9999;
			for (int j=0; j<arraySize; j++) {
				edges[i][j] = 9999;
			}
			visited[i]=false;
		}
		for (Vertex element1 : graph.vertices) {
			for (Edge element2 : element1.edges) {
				edges[element1.index-1][element2.to.index-1] = element2.weight;
			}
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
