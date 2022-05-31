package GraphDataSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;


import javax.swing.*;

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
	
	private void delveDeeper(Vertex end, boolean[] visited, int depthWeight) {// this looks fishy. what when there is no vertex
		Vertex element1 = end;
		Edge[] availableEdges;
		boolean[] localVisited = new boolean[arraySize];
		for(int i=0; i<visited.length; i++) {
			localVisited[i] = visited[i];
		}
		localVisited[end.index] = true;	
		int k=0;
		for(int i=0; i<element1.edges.size(); i++){
			Edge element2 = element1.getEdge(i);
			if(shortestDFromStart[element2.to.index] > element2.weight+depthWeight //why not work
					&& element2.to.index != end.index) { //1. log edge weight
				shortestDFromStart[element2.to.index] = element2.weight+depthWeight;
				previousVertex[element2.to.index] = end;
			}
			if(localVisited[element2.to.index]==false){ //1.1 check if edge doesnt goes to a visited zone to go further
				k++;
			}
		}
		availableEdges = new Edge[k];
		k=0;
		for(int i=0; i<element1.edges.size(); i++){
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
	
	private void djikstraButton() {
		//read from text fields if they worked
		startingPoint = 0;
		endingPoint = 0;
		startingPoint = Integer.parseInt(fromTF.getText());
		endingPoint = Integer.parseInt(toTF.getText());
		
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
		
		
		fromTF.setPreferredSize(new Dimension(100, 20));
		toTF.setPreferredSize(new Dimension(100, 20));
		button.setPreferredSize(new Dimension(100, 20));
		button.addActionListener(this);
		this.add(fromTF, BorderLayout.WEST);
		this.add(toTF, BorderLayout.WEST);
	    this.add(button, BorderLayout.WEST);
	    this.setSize(40,40);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			djikstraButton();
		}
	}
}
