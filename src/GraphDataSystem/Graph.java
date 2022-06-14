package GraphDataSystem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Graph implements Serializable{
	public List<Vertex> vertices;
	final static int RANDMIN = 1;
	final static int RANDMAX = 100;
	public static int height, width;
	public Graph(int height, int width) {
		this.vertices = new ArrayList<>();
		this.height = height;
		this.width = width;
		Vertex[] VertexArray = new Vertex[height*width];
		  
		  //makes vertexes
		  for (int i = 0; i < height*width; i++) {
			  VertexArray[i] = new Vertex(i); 
		  }

		  //adds Edges to neighbouring Vertexes
		  for (int i = 0; i < height*width; i++) {
			  //if not last in line, then to the right
			  if ((i+1)%width!=0) {
				  int r = ThreadLocalRandom.current().nextInt(RANDMIN, RANDMAX + 1);
				  VertexArray[i].addNeighbour(new Edge(r, VertexArray[i], VertexArray[i+1]));
				  VertexArray[i+1].addNeighbour(new Edge(r, VertexArray[i+1], VertexArray[i]));
			  }
			  //if not last row, then connect down
			  if (i<height*width-width) {
				  int r = ThreadLocalRandom.current().nextInt(RANDMIN, RANDMAX + 1);
				  VertexArray[i].addNeighbour(new Edge(r, VertexArray[i], VertexArray[i+width]));
				  VertexArray[i+width].addNeighbour(new Edge(r, VertexArray[i+width], VertexArray[i]));
			  }
		  }
		  //remember them in graph
		  for (int i = 0; i < height*width; i++) {
		    this.addVertex(VertexArray[i]);  
		  }

		  
	}
	boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }
	Vertex getVertex(int n) {
    	for (Vertex v : vertices) {
    		if (v.getName() == n) {
    			return v;
    		}
    	}
    	return null;
    }
}
