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
	File studiesDir = new File(System.getProperty("user.dir")+"\\studies");
	
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
		
		String studyDir;
		File inFile;
        if(workstationClass.control.getDefault().equals(null)&& !(chooser.getSelectedFile()==null)){
        	 inFile = chooser.getSelectedFile();
        	 studyDir = System.getProperty("user.dir") + "\\studies\\" + inFile.getName();

         }
         else if(!workstationClass.control.getDefault().equals(null) && chooser.getSelectedFile()==null){
        	 inFile=new File(workstationClass.control.defaultName);
        	 studyDir=workstationClass.control.getDefault();
         }
         else{
        	 inFile = chooser.getSelectedFile();
        	 studyDir = System.getProperty("user.dir") + "\\studies\\" + inFile.getName();
         }
      
      if( ae.getSource() == workstationClass.openItem ) {
   
    	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         int hasSelectedFile = chooser.showOpenDialog(workstationClass.jf);
      
         inFile = chooser.getSelectedFile();
        
         
         studyDir = System.getProperty("user.dir") + "\\studies\\" + inFile.getName();
         
         System.out.println(studyDir);
         
         //generate command
         workstationClass.control.generateCommand("open", studyDir );
      
      }
      
      if( ae.getSource() == workstationClass.saveItem ) {

          workstationClass.control.generateCommand("save", studyDir );
    	  
      }
      
      if( ae.getSource() == workstationClass.forwardButton ) {

          //generate command
          workstationClass.control.generateCommand("scrollForward", studyDir );
    	  
      }
      if(ae.getSource()== workstationClass.exitItem){
    	  
    	  System.exit(0);
      }
      
      if( ae.getActionCommand() == "Single Image View" ) {

          //generate command
          workstationClass.control.generateCommand("changeDisplay", studyDir );
    	  
      }
      
      if( ae.getActionCommand() == "Quad Image View" ) {
    	  
          //generate command
          workstationClass.control.generateCommand("changeDisplay", studyDir );
    	  
    	  
      }
      
      if( ae.getSource() == workstationClass.previousButton ) {

          //generate command
          workstationClass.control.generateCommand("scrollBack", studyDir );
    	  
      }
      
		if( ae.getSource() == workstationClass.copyItem ) {
		
         String newStudyName = JOptionPane.showInputDialog(workstationClass.jf, "Enter a name for the New Study");
         String copyStudy = System.getProperty("user.dir") + "\\studies\\" + newStudyName;
         workstationClass.control.generateCommand(copyStudy,studyDir);
         
      
      
		}
		
		if( ae.getSource() == workstationClass.defaultItem ) {
			//File inFile = chooser.getSelectedFile();
			studyDir = System.getProperty("user.dir") + "\\studies\\" + inFile.getName();
			defaultStudy de = new defaultStudy(studyDir);
			de.save();
			JOptionPane.showMessageDialog(workstationClass.jf, "Default Study Saved!");
			
			
		}
		
	
	}

}

