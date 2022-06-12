package GraphDataSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GenerateNewGraph extends JPanel implements ActionListener {
	Graph graph = Main.graph;
	JButton button = new JButton("Generate");
	JTextField heightField = new JTextField();
	JTextField widthField = new JTextField();
	public GenerateNewGraph(){
		heightField.setPreferredSize(new Dimension(100, 20));
		widthField.setPreferredSize(new Dimension(100, 20));
    	button.setPreferredSize(new Dimension(100, 20));
    	button.addActionListener(this);
		this.add(heightField, BorderLayout.WEST);
    	this.add(widthField, BorderLayout.WEST);
    	this.add(button, BorderLayout.WEST);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			int height = Integer.parseInt(heightField.getText());
			int width = Integer.parseInt(widthField.getText());
			Graph tempGraph = new Graph(height, width);
			Main.updateGraph(tempGraph);
		}
	}
}
