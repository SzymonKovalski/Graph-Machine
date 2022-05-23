package GraphDataSystem;
import java.util.Set;
//import java.util.List;
//import java.util.ArrayList;
import java.util.HashSet;
public class Vertex {
	public int index;
    public Set<Edge> edges; //collection of edges to neighbors 

    public Vertex(int index) {
        this.index = index;
        edges = new HashSet<>();
    }

    boolean addEdge(Edge edge){
        return edges.add(edge);
    }
    Edge getEdge(int n) {
    	int i = 0;
        
        for (Edge element :edges) { 
          // Implementing for loop
  
            if (i == n)
            {
                return element;
            }
            i++;
        }
        return null;
    }
}
