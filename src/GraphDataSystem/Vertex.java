package GraphDataSystem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>, Serializable{
    private int name;
    public List<Edge> edges;
    private boolean visited;
    private Vertex previosVertex;
    private double minDistance = Double.MAX_VALUE;

    public Vertex(int name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public int getName() {
    	return name;
    }
    
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviosVertex() {
        return previosVertex;
    }

    public void setPreviosVertex(Vertex previosVertex) {
        this.previosVertex = previosVertex;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return Integer.toString(name);
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.minDistance, otherVertex.minDistance);
    }
}