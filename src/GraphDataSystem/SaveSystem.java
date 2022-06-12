package GraphDataSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveSystem extends JPanel implements ActionListener {
	Graph graph = Main.graph;
	JButton saveButton = new JButton("Save");
	JTextField loadFrom = new JTextField();
	JButton loadButton = new JButton("Load");
	
	File file = new File("save1.txt");
	FileOutputStream fileOutStr =  new FileOutputStream("theBuilding.ser"); 
			        
	ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
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
		
	}
	
	
	
	
	
	public SaveSystem(){
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
