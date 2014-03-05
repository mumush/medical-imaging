/**
*	@author Ryan Hoffmann
	@version 3/3/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Workstation implements UI {

	@Override
	public void update(Observable arg0, Object arg1) {

		

	}

	JFrame jf;
	JMenuItem aboutItem;
	JTextField field;
	Color origColor;
	JButton enterBut;
	JButton resetBut;

   public Workstation() {
   
		//create new JFrame
		jf = new JFrame();
		
		//set the layout for jf to be a border layout
		jf.setLayout(new GridLayout(2, 2));
		
		//create new JMenuBar
		JMenuBar jmb = new JMenuBar();
		
		//create new JMenu for File
		JMenu fileMenu = new JMenu("File");
		//set mnemonic for the file option to the letter 'f'
		fileMenu.setMnemonic('F');
      
		//create new JMenuItem for the File menu called Open
		JMenuItem openItem = new JMenuItem("Open Study");
		//set mnemonic for the exit option to the letter 'o'
		openItem.setMnemonic('O');
		//add the exitItem to the fileMenu
		fileMenu.add(openItem);
      
		//create new JMenuItem for the File menu called Copy
		JMenuItem copyItem = new JMenuItem("Copy Study");
		//set mnemonic for the exit option to the letter 'c'
		copyItem.setMnemonic('C');
		//add the exitItem to the fileMenu
		fileMenu.add(copyItem);
      
		//create new JMenuItem for the File menu called Save
		JMenuItem saveItem = new JMenuItem("Save Study");
		//set mnemonic for the exit option to the letter 's'
		saveItem.setMnemonic('S');
		//add the exitItem to the fileMenu
		fileMenu.add(saveItem);
		
		//create new JMenuItem for the File menu called Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		//set mnemonic for the exit option to the letter 'x'
		exitItem.setMnemonic('X');
		//add the exitItem to the fileMenu
		fileMenu.add(exitItem);
		
		//create new JMenu for Help
		JMenu helpMenu = new JMenu("Help");
		//set mnemonic for the help option to the letter 'h'
		helpMenu.setMnemonic('H');
		
		//create new JMenuItem for the Help menu called About
		aboutItem = new JMenuItem("About");
		//add the aboutItem to the helpMenu
		helpMenu.add(aboutItem);
		
		//add the menus to the JMenuBar
		jmb.add(fileMenu);
		jmb.add(helpMenu);
		
		//add the jmb to the JFrame
		jf.setJMenuBar(jmb);
      
      
      
      
      
		//******JFrame setup
		
		//set the title of the frame
		jf.setTitle("Dat GUI");
		
		//set the size of the frame
		jf.setSize(230, 300);
		
		//set close operation
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the frame to be visible
		jf.setVisible(true);
		
		
   
   }


}