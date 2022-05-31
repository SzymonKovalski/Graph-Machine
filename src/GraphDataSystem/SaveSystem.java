package GraphDataSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveSystem extends JPanel implements ActionListener {
	Graph graph;
	public SaveSystem(Graph graph){
		this.graph = graph;
		
		JButton saveButton = new JButton("Save");
		JTextField loadFrom = new JTextField();
		JButton loadButton = new JButton("Load");
		
		saveButton.setPreferredSize(new Dimension(100, 20));
		loadFrom.setPreferredSize(new Dimension(200, 20));
		loadButton.setPreferredSize(new Dimension(100, 20));
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		this.add(saveButton, BorderLayout.EAST);
		this.add(loadFrom, BorderLayout.EAST);
	    this.add(loadButton, BorderLayout.EAST);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
