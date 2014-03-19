/**
*	@author Doug Weber
	@version 3/6/14
*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class RunWorkstation {

	/*creates instance of Workstation class which will
	*run the Workstation classes constructor
	*and generates the GUI*/
	
	public static void main(String [] args) {
		
   	Workstation station;
   	localStudy study;
   	defaultStudy de=null;
   	File file = new File(System.getProperty("user.dir") + "\\studies");
   	ArrayList<Study> list = new ArrayList<Study>();
   	Controller control= new Controller(list);
      
		station = new Workstation(control);
      
      		//loop thought the file and create a list of studys based on saved .ser file//
		for(File child: file.listFiles()){
			try{
				FileInputStream fileIn = new FileInputStream(child+".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				study = (localStudy) in.readObject();
				in.close();
				fileIn.close();
				study.addObserver(station);
				list.add(study);
				System.out.println("deserialized");
				
			}
			 catch (ClassNotFoundException e) {
				
				System.out.println("Bad things happened");
				e.printStackTrace();
			}
			catch(IOException e){
				
				study = new localStudy(child.getAbsolutePath());
				study.addObserver(station);
				list.add(study);				
			}
			 catch(Exception e){
				e.printStackTrace();
			}
		
		}    
		try{
			FileInputStream fileIn = new FileInputStream("default.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			de = (defaultStudy) in.readObject();
			String deFault=de.getName();
			control.setDefalut(deFault);
			for(int i=0; i<list.size();i++){
				if (deFault.equals(list.get(i).getDirectory())){
					control.generateCommand("open",list.get(i).getDirectory());
				}
			}
			in.close();
			fileIn.close();
			
			System.out.println("default deserialized");
			
		}
		 catch (ClassNotFoundException e) {
			
			System.out.println("Bad things happened");
			e.printStackTrace();
		}
		 catch(Exception e){
			System.out.println("No Default Study");
		}
   }
   


}
