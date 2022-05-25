package GraphDataSystem;

import java.util.Comparator;

public class Edge implements Comparator<Edge>{
	public Vertex to; 
    public int weight;

    public Edge(Vertex to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    
    public int compare(Edge e1, Edge e2){
    	 return e1.weight - e2.weight;
    }
}
