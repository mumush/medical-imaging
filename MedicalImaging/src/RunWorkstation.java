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

	//creates instance of Workstation class which will
	//run the Workstation classes constructor
	//which generates the GUI
	
	public static void main(String [] args) {
		
   	Workstation station;
   	localStudy study;
   	File file = new File(System.getProperty("user.dir"));
   	ArrayList<Study> list = new ArrayList<Study>();
   	Controller control= new Controller(list);
      
		station = new Workstation(control);
      
		for(File child: file.listFiles()){
			try{
				FileInputStream fileIn = new FileInputStream(new File(child.getAbsolutePath())+".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				study = (localStudy) in.readObject();
				in.close();
				fileIn.close();
				study.addObserver(station);
				station.control.addStudy(study);
				
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
   }
   


}
