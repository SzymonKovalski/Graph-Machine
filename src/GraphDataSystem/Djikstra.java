package GraphDataSystem;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import java.util.Set;
public class Djikstra extends JPanel implements ActionListener{
	Graph graph;
	int startingPoint;
	int endingPoint;
	int arraySize;
	
	public int[] shortestDFromStart;
	public Vertex[] previousVertex;
	
	JButton button = new JButton("Djikstra");
	JTextField fromTF = new JTextField();
	JTextField toTF = new JTextField();
	
	private void delveDeeper(Vertex start, boolean[] visited, int depthWeight) {// this looks fishy. what when there is no vertex
		Vertex element1 = start;
		Edge[] availableEdges;
		boolean[] localVisited = new boolean[arraySize];
		for(int i=0; i<visited.length; i++) {
			localVisited[i] = visited[i];
		}
		localVisited[start.index] = true;	
		int k=0;
		for(int i=0; i<element1.edges.size(); i++){
			Edge element2 = element1.getEdge(i);
			if(shortestDFromStart[element2.to.index] > element2.weight+depthWeight) { //1. log edge weight
				shortestDFromStart[element2.to.index] = element2.weight+depthWeight;
				previousVertex[element2.to.index] = start;
			}
			if(localVisited[element2.to.index]==false){ //1.1 check if edge doesnt goes to a visited zone to go further
				k++;
			}
		}
		availableEdges = new Edge[k];
		k=0;
		for(int i=0; i<element1.edges.size(); i++){ // writing this twice is bad practice but i dont have energy
			Edge element2 = element1.getEdge(i);
			if(localVisited[element2.to.index]==false) {
				availableEdges[k] = element2;
				k++;
			}	
		}
		//2 sort the valid outs from least weight to most
	    for (int i = 0; i < availableEdges.length - 1; i++) {
	        for (int j = 0; j < availableEdges.length - i - 1; j++) {
	            if (availableEdges[j].weight > availableEdges[j + 1].weight) {
	                Edge temp = availableEdges[j];
	                availableEdges[j] = availableEdges[j + 1];
	                availableEdges[j + 1] = temp;
	            }
	        }
	    }
		//3 call itself again for each, starting from lowest
		for(Edge element2: availableEdges) {
			delveDeeper(element2.to ,localVisited, depthWeight+element2.weight);
		}
	}

	//major flaw. comparison doesnt apply path to the vertex, resulting in 7 --> 10 --> 7 ...
	private void explainPath(Vertex start) {
		Vertex thisVertex = previousVertex[start.index];
		System.out.print(thisVertex.index);
		if(thisVertex.index != startingPoint) {
			System.out.print(" --> ");
			explainPath(thisVertex);
		}
		else {
			System.out.println();
		}
	}
	
	private void djikstraAlgorythm() {
		//read from text fields if they worked
		startingPoint = 1;
		endingPoint = 12;
		
		shortestDFromStart[startingPoint] = 0;
		delveDeeper(graph.getVertex(startingPoint), new boolean[arraySize], 0);
		System.out.println(shortestDFromStart[endingPoint]);
		explainPath(graph.getVertex(endingPoint));
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
