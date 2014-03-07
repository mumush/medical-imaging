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
	WorkStation workstationClass;
   
	//the directory in which this file is located
	File studiesDir = new File("../studies");
	
	//the file chooser with the starting directory as the previous location
	JFileChooser chooser = new JFileChooser(studiesDir);
   
   //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   
    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //chooser.setAcceptAllFileFilterUsed(false);


	public controlListener(WorkStation _workstationClass) {
	
		workstationClass = _workstationClass;
	
	}
   
    public static void copyFolder(File src, File dest)
    	throws IOException{
 
    	if(src.isDirectory()){
 
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
 
    		//list all the directory contents
    		String files[] = src.list();
 
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}
 
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
 
    	        byte[] buffer = new byte[1024];
 
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
              out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }


	
   /**
     * actionPerformed - when an action is performed this method is called
	  * which supplies an if clause to determine if an item in the GUI was
	  * acted on
	  * @param --> ae, an ActionEvent
     * 
   */
	public void actionPerformed(ActionEvent ae) {
		
      
      if( ae.getSource() == workstationClass.openItem ) {
      
         int hasSelectedFile = chooser.showOpenDialog(workstationClass.jf);
      
         File inFile = chooser.getSelectedFile();
         
         File parentDir = inFile.getParentFile();
         
         String studyName = parentDir.getName();
         
         System.out.println(studyName);
         
         //generateCommand("open", studyName);
         
         //take the study name, create instance of that study, and based on the
      
      }
      
		if( ae.getSource() == workstationClass.copyItem ) {
		
         String newStudyName = JOptionPane.showInputDialog(workstationClass.jf, "Enter a name for the New Study");
         
         System.out.println( newStudyName );
         
         //copy to new directory as well as contents
         
         File source = new File("../studies/ct_head");
         
         String newStudyDir = "../studies/" + newStudyName;
         
         File dest = new File( newStudyDir );
         
         try{
            copyFolder(source,dest);
         }
         catch(IOException e){
            e.printStackTrace();
            //error, just exit
            System.exit(0);
         }
      
      
		}
		
	
	}

}

