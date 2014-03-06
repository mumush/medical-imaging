/**
*	@author Doug Weber
	@version 3/3/14
*/

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class RunWorkstation extends Applet{
	/**
	 * 
	 */
	//creates instance of Workstation class which will
	//run the Workstation classes constructor
	//which generates the GUI	
	WorkStation station;
	Study study;
	File file=new File(System.getProperty("user.dir"));
	ArrayList<Study> list;
	
	public void init() {
		
		station=new WorkStation();
		try{
			FileInputStream fileIn = new FileInputStream(new File(System.getProperty("user.dir")+"/studies/.ser"));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			study = (localStudy) in.readObject();
			in.close();
			fileIn.close();
			list.add(study);
			
		}
		 catch (ClassNotFoundException e) {
			
			System.out.println("Bad things happend");
			e.printStackTrace();
		}
		 catch(Exception e){
			e.printStackTrace();
		}
		for(File child: file.listFiles()){
			study = new localStudy(child.getAbsolutePath());
			list.add(study);
			}

}

