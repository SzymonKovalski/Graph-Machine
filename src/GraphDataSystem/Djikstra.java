package GraphDataSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Djikstra extends JPanel implements ActionListener{
	Graph graph;
	JButton button = new JButton("Djikstra");
	JTextField fromTF = new JTextField();
	JTextField toTF = new JTextField();
    public void computePath(Vertex sourceVertex) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();

            for (Edge edge : vertex.getEdges()) {
                Vertex v = edge.getTargetVertex();
//                Vertex u = edge.getStartVertex();
                double weight = edge.getWeight();
                double minDistance = vertex.getMinDistance() + weight;

                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(vertex);
                    v.setPreviosVertex(vertex);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVerte) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVerte; vertex != null; vertex = vertex.getPreviosVertex()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
    public Djikstra(Graph graph){
    	this.graph = graph;
    	//graphics
    	fromTF.setPreferredSize(new Dimension(100, 20));
    	toTF.setPreferredSize(new Dimension(100, 20));
    	button.setPreferredSize(new Dimension(100, 20));
    	button.addActionListener(this);
    	this.add(fromTF, BorderLayout.WEST);
    	this.add(toTF, BorderLayout.WEST);
    	this.add(button, BorderLayout.WEST);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			this.computePath(graph.getVertex(0));
			System.out.println(this.getShortestPathTo(graph.getVertex(3)));
		}
	}
}