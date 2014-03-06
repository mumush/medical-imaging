/**
*	@author Ryan Hoffmann
	@version 3/3/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class controlListener implements ActionListener {

	//public variable which references the gui class
	Workstation workstationClass;
   
	//the directory in which this file is located
	File studiesDir = new File("../studies");
	
	//the file chooser with the starting directory as the previous location
	JFileChooser chooser = new JFileChooser(studiesDir);
   
   //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   
    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //chooser.setAcceptAllFileFilterUsed(false);


	public controlListener(Workstation _workstationClass) {
	
		workstationClass = _workstationClass;
	
	}
	
   /**
     * actionPerformed - when an action is performed this method is called
	  * which supplies an if clause to determine if an item in the GUI was
	  * acted on
	  * @param --> ae, an ActionEvent
     * 
   */
	public void actionPerformed(ActionEvent ae) {
		
		//if resetBut is clicked, reset the JTextField to its default state
      /**
		if(ae.getSource() == workstationClass.resetBut) {
			
				Font font = new Font("SansSerif", Font.PLAIN, 12);
				gfhClass.field.setFont(font);
				gfhClass.field.setBackground(gfhClass.origColor);
			
		}
      
      */
      
      if( ae.getSource() == workstationClass.openItem ) {
      
         int hasSelectedFile = chooser.showOpenDialog(workstationClass.jf);
      
         File inFile = chooser.getSelectedFile();
         
         File parentDir = inFile.getParentFile();
         
         String name = parentDir.getName();
         
         System.out.println(name);
      
      }
		
	
	}

}

