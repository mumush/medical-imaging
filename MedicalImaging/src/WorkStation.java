/**
*	@author Ryan Hoffmann
	@version 3/3/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Workstation {


	JFrame jf;
   JMenuItem openItem;
	JMenuItem aboutItem;
   JMenuItem copyItem;
   JMenuItem saveItem;
   JMenuItem exitItem;
   JMenuItem optionsItem;
   
   JButton previousButton;
   JButton forwardButton;
   
   JRadioButton oneView;
   JRadioButton fourView;
   
   ButtonGroup viewButtonGroup;
   

   public Workstation() {
   
		//create new JFrame
		jf = new JFrame();
		
		//set the layout for jf to be a border layout
		jf.setLayout(new GridLayout(2, 0));
		
		//create new JMenuBar
		JMenuBar jmb = new JMenuBar();
		
		//create new JMenu for File
		JMenu fileMenu = new JMenu("File");
		//set mnemonic for the file option to the letter 'f'
		fileMenu.setMnemonic('F');
      
		//create new JMenuItem for the File menu called Open
		openItem = new JMenuItem("Open Study");
		//set mnemonic for the exit option to the letter 'o'
		openItem.setMnemonic('O');
		//add the exitItem to the fileMenu
		fileMenu.add(openItem);
      
		//create new JMenuItem for the File menu called Copy
		copyItem = new JMenuItem("Copy Study");
		//set mnemonic for the exit option to the letter 'c'
		copyItem.setMnemonic('C');
		//add the exitItem to the fileMenu
		fileMenu.add(copyItem);
      
		//create new JMenuItem for the File menu called Save
		saveItem = new JMenuItem("Save Study");
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
		
		//create new JMenu for Preferences
		JMenu prefsMenu = new JMenu("Preferences");
		//set mnemonic for the help option to the letter 'r'
		prefsMenu.setMnemonic('R');
		
		//create new JMenuItem for the Preferences menu
		optionsItem = new JMenuItem("Options");
		//add the aboutItem to the helpMenu
		prefsMenu.add(optionsItem);
		
		//add the menus to the JMenuBar
		jmb.add(fileMenu);
		jmb.add(prefsMenu);
		
		//add the jmb to the JFrame
		jf.setJMenuBar(jmb);
      
      //first row in grid layout
      JPanel rowOne = new JPanel(new GridLayout(2, 2));
      
      //create new image and image label
      ImageIcon image = new ImageIcon("../studies/axial_head_mri/head01.jpg");
      JLabel label = new JLabel("", image, JLabel.CENTER);
      
      rowOne.add(label);
      
      //create new image and image label
      ImageIcon image1 = new ImageIcon("../studies/axial_head_mri/head01.jpg");
      JLabel label1 = new JLabel("", image1, JLabel.CENTER);
      
      rowOne.add(label1);
      
      //create new image and image label
      ImageIcon image2 = new ImageIcon("../studies/axial_head_mri/head01.jpg");
      JLabel label2 = new JLabel("", image2, JLabel.CENTER);
      
      rowOne.add(label2);
      
      //create new image and image label
      ImageIcon image3 = new ImageIcon("../studies/axial_head_mri/head01.jpg");
      JLabel label3 = new JLabel("", image3, JLabel.CENTER);
      
      rowOne.add(label3);
      
      
      //add row to JFrame
      jf.add(rowOne);
      
      JPanel rowTwo = new JPanel();
      
      previousButton = new JButton("Previous Image");
      forwardButton = new JButton("Next Image");
      
      rowTwo.add(previousButton);
      rowTwo.add(forwardButton);
      
      oneView = new JRadioButton("Single Image View");
      oneView.setSelected(true);
      fourView = new JRadioButton("Quad Image View");
      
      viewButtonGroup = new ButtonGroup();
      viewButtonGroup.add(oneView);
      viewButtonGroup.add(fourView);
      
      rowTwo.add(oneView);
      rowTwo.add(fourView);
      
      jf.add(rowTwo);
      
      
		//******Register External Action Listeners
		
		controlListener ctrlListener = new controlListener(this);
		
		openItem.addActionListener(ctrlListener);
      
      
		//******JFrame setup
		
		//set the title of the frame
		jf.setTitle("Medical Image Workstation");
		
		//set the size of the frame
		jf.setSize(650, 800);
		
		//set close operation
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the frame to be visible
		jf.setVisible(true);
   
   }


}