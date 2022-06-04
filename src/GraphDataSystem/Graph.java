package GraphDataSystem;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {
	public Set<Vertex> vertices;
	public Graph(int height, int width, int randMin, int randMax) {
		vertices = new HashSet<>();
		Vertex[] VertexArray = new Vertex[height*width];
		  
		  //makes vertexes
		  for (int i = 0; i < height*width; i++) {
			  VertexArray[i] = new Vertex(i); 
		  }

		  //adds Edges to neighbouring Vertexes
		  for (int i = 0; i < height*width; i++) {
			  //if not last in line, then to the right
			  if ((i+1)%width!=0) {
				  int r = ThreadLocalRandom.current().nextInt(randMin, randMax + 1);
				  VertexArray[i].addNeighbour(new Edge(r, VertexArray[i], VertexArray[i+1]));
				  VertexArray[i+1].addNeighbour(new Edge(r, VertexArray[i+1], VertexArray[i]));
			  }
			  //if not last row, then connect down
			  if (i<height*width-width) {
				  int r = ThreadLocalRandom.current().nextInt(randMin, randMax + 1);
				  VertexArray[i].addNeighbour(new Edge(r, VertexArray[i], VertexArray[i+width]));
				  VertexArray[i+width].addNeighbour(new Edge(r, VertexArray[i+width], VertexArray[i]));
			  }
		  }
		  //remember them in graph
		  for (int i = 0; i < height*width; i++) {
		    this.addVertex(VertexArray[i]);  
		  }

        //v1.addNeighbour(new Edge(1, v1, v2));
        //v1.addNeighbour(new Edge(10, v1, v2));

        //v2.addNeighbour(new Edge(1, v2, v3));

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
