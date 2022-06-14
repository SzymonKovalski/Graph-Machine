package GraphDataSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveSystem extends JPanel implements ActionListener {
	Graph graph = Main.graph;
	JButton saveButton = new JButton("Save");
	JTextField loadFrom = new JTextField();
	JButton loadButton = new JButton("Load");
	
	String file = "./save1";
	private void Save() {
		try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(graph);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	private void Load() {
		try {
			 
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Graph g = (Graph) objectIn.readObject();
 
            //dont know why, but DisplayGraph doesnt get the memo about changed width
            
            System.out.println("The Object has been read from the file");
            objectIn.close();
            Graph tempGraph = new Graph(g.height, g.width);
            Main.updateGraph(tempGraph); //wierd and convoluted solution
            Main.updateGraph(g);
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	
	
	
	
	protected SaveSystem(){
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
		if (e.getSource()==loadButton) {
			Load();
		}
		if (e.getSource()==saveButton) {
			Save();
		}
	}
}
