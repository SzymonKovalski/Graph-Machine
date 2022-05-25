package GraphDataSystem;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;
public class Graph {
	public Set<Vertex> vertices; //collection of all verices 

    public Graph(int h, int w, int randMin, int randMax) {
        vertices = new HashSet<>();
        
  		  Vertex[] VertexArray = new Vertex[h*w];
  		  
  		  //makes vertexes
  		  for (int i = 0; i < h*w; i++) {
  			  VertexArray[i] = new Vertex(i); 
  		  }

  		  //adds Edges to neighbouring Vertexes
  		  for (int i = 0; i < h*w; i++) {
  			  //if not last in line, then to the right
  			  if ((i+1)%w!=0) {
  				  int r = ThreadLocalRandom.current().nextInt(randMin, randMax + 1);
  				  VertexArray[i].addEdge(new Edge(VertexArray[i+1], r));
  				  VertexArray[i+1].addEdge(new Edge(VertexArray[i], r));
  			  }
  			  //if not last row, then connect down
  			  if (i<h*w-w) {
  				  int r = ThreadLocalRandom.current().nextInt(randMin, randMax + 1);
  				  VertexArray[i].addEdge(new Edge(VertexArray[i+w], r));
  				  VertexArray[i+w].addEdge(new Edge(VertexArray[i], r));
  			  }
  		  }
  		  //remember them in graph
  		  for (int i = 0; i < h*w; i++) {
  		    this.addVertex(VertexArray[i]);  
  		  }
  	  
    } 


    boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }
    Vertex getVertex(int n) {
    	int i = 0;
        
        for (Vertex element :vertices) { 
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
