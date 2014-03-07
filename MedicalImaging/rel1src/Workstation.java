/**
*	@author Ryan Hoffmann
	@version 3/3/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Workstation implements Observer {
	
	   JFrame jf;
	   JMenuItem openItem;
	   JMenuItem copyItem;
	   JMenuItem saveItem;
	   JMenuItem exitItem;
	   JMenuItem optionsItem;
	   
	   JButton previousButton;
	   JButton forwardButton;
	   
	   JLabel label;
	   JLabel label2;
	   JLabel label3;
	   JLabel label4;
	   
	   JRadioButton oneView;
	   JRadioButton fourView;
	   
	   ButtonGroup viewButtonGroup;
	   Controller control;

   public void update(Observable obs, Object obj) {
	   
	   localStudy study = (localStudy) obs;
	   
		if( obj.equals("open") ) {
			
			if(study.getDisplayState() == 1 ){
			String imgPath = study.getImageList().get(study.getCurrentImage()).getAddress();
			
			System.out.println( study.getImageList().get(study.getCurrentImage()).getAddress());
			
			ImageIcon img = new ImageIcon(imgPath);
			
			label.setIcon(img);
			
			//clear other three images
			label2.setIcon(null);
			label3.setIcon(null);
			label4.setIcon(null);
			
			}
			else{
				ImageIcon img = new ImageIcon(study.getImageList().get(study.getCurrentImage()).getAddress());
				ArrayList<ImageIcon> imgs=new ArrayList<ImageIcon>();
				imgs.add(img);
				for(int i=1;i<4;i++){
					if(study.getImageList().get(study.getCurrentImage()+i).getAddress().equals("blank")){
						ImageIcon newImg = new ImageIcon();
						imgs.add(newImg);
					}
					else{
						ImageIcon newImg = new ImageIcon(study.getImageList().get(study.getCurrentImage()+i).getAddress());
						imgs.add(newImg);
					}
				}
				
				label.setIcon(imgs.get(0));
				label2.setIcon(imgs.get(1));
				label3.setIcon(imgs.get(2));
				label4.setIcon(imgs.get(3));
			}
			
		}
		
		if( obj.equals("next image") ) {
			String imgPath = study.getImageList().get(study.getCurrentImage()).getAddress();
			
			System.out.println( study.getImageList().get(study.getCurrentImage()).getAddress());
			
			if(study.getDisplayState()==1){
				
				ImageIcon img = new ImageIcon(imgPath);
			
				label.setIcon(img);
				
				//clear other three images
				label2.setIcon(null);
				label3.setIcon(null);
				label4.setIcon(null);
				
			}
			else{
				ImageIcon img = new ImageIcon(study.getImageList().get(study.getCurrentImage()).getAddress());
				ArrayList<ImageIcon> imgs=new ArrayList<ImageIcon>();
				imgs.add(img);
				for(int i=1;i<4;i++){
					if(study.getImageList().get(study.getCurrentImage()+i).getAddress().equals("blank")){
						ImageIcon newImg = new ImageIcon();
						imgs.add(newImg);
					}
					else{
						ImageIcon newImg = new ImageIcon(study.getImageList().get(study.getCurrentImage()+i).getAddress());
						imgs.add(newImg);
					}
				}
				
				label.setIcon(imgs.get(0));
				label2.setIcon(imgs.get(1));
				label3.setIcon(imgs.get(2));
				label4.setIcon(imgs.get(3));
			}
			
		}
		
		if( obj.equals("display") ) {
			
			if(study.getDisplayState() == 1) {
				
				String imgPath = study.getImageList().get(study.getCurrentImage()).getAddress();
				
				System.out.println( study.getImageList().get(study.getCurrentImage()).getAddress());
				
				ImageIcon img = new ImageIcon(imgPath);
				
				label.setIcon(img);
				
				//clear other three images
				label2.setIcon(null);
				label3.setIcon(null);
				label4.setIcon(null);
				
				}
				else{
					ImageIcon img = new ImageIcon(study.getImageList().get(study.getCurrentImage()).getAddress());
					ArrayList<ImageIcon> imgs=new ArrayList<ImageIcon>();
					imgs.add(img);
					for(int i=1;i<4;i++){
						if(study.getImageList().get(study.getCurrentImage()+i).getAddress().equals("blank")){
							ImageIcon newImg = new ImageIcon();
							imgs.add(newImg);
						}
						else{
							ImageIcon newImg = new ImageIcon(study.getImageList().get(study.getCurrentImage()+i).getAddress());
							imgs.add(newImg);
						}
					}
					
					label.setIcon(imgs.get(0));
					label2.setIcon(imgs.get(1));
					label3.setIcon(imgs.get(2));
					label4.setIcon(imgs.get(3));
				}
			
			jf.pack();
			
		}
		
		if( obj.equals("previous image") ) {
			if(study.getDisplayState()==1){
				String imgPath = study.getImageList().get(study.getCurrentImage()).getAddress();
			
				System.out.println( study.getImageList().get(study.getCurrentImage()).getAddress());
			
				ImageIcon img = new ImageIcon(imgPath);
			
				label.setIcon(img);
			}
			else{
				ImageIcon img = new ImageIcon(study.getImageList().get(study.getCurrentImage()).getAddress());
				ArrayList<ImageIcon> imgs=new ArrayList<ImageIcon>();
				imgs.add(img);
				for(int i=1;i<4;i++){
					if(study.getImageList().get(study.getCurrentImage()+i).getAddress().equals("blank")){
						ImageIcon newImg = new ImageIcon();
						imgs.add(newImg);
					}
					else{
						ImageIcon newImg = new ImageIcon(study.getImageList().get(study.getCurrentImage()+i).getAddress());
						imgs.add(newImg);
					}
				}
				
				label.setIcon(imgs.get(0));
				label2.setIcon(imgs.get(1));
				label3.setIcon(imgs.get(2));
				label4.setIcon(imgs.get(3));
				
			}
			
		}
		
		//udpate GUI
		jf.repaint();
		jf.revalidate();
	   
   }



   public Workstation(Controller ctrl) {
	   control= ctrl;
		//create new JFrame
		jf = new JFrame();
		
		//set the layout for jf to be a border layout
		jf.setLayout(new BorderLayout() );
		
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
		exitItem = new JMenuItem("Exit");
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
      ImageIcon image1 = new ImageIcon();
      label = new JLabel("", image1, JLabel.CENTER);
      
      rowOne.add(label);
      
      //create new image and image label
      ImageIcon image2 = new ImageIcon();
      label2 = new JLabel("", image2, JLabel.CENTER);
      
      rowOne.add(label2);
      
      //create new image and image label
      ImageIcon image3 = new ImageIcon();
      label3 = new JLabel("", image3, JLabel.CENTER);
      
      rowOne.add(label3);
      
      //create new image and image label
      ImageIcon image4 = new ImageIcon();
      label4 = new JLabel("", image4, JLabel.CENTER);
      
      rowOne.add(label4);
      
      
      //add row to JFrame
      jf.add(rowOne, BorderLayout.CENTER);
      
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
      
      jf.add(rowTwo, BorderLayout.SOUTH);
      
      
		//******Register External Action Listeners
		
		controlListener ctrlListener = new controlListener(this);
		
		openItem.addActionListener(ctrlListener);
      copyItem.addActionListener(ctrlListener);
      saveItem.addActionListener(ctrlListener);
      optionsItem.addActionListener(ctrlListener);
      exitItem.addActionListener(ctrlListener);
      
      previousButton.addActionListener(ctrlListener);
      forwardButton.addActionListener(ctrlListener);
      
      oneView.addActionListener(ctrlListener);
      fourView.addActionListener(ctrlListener);
      
      
		//******JFrame setup
		
		//set the title of the frame
		jf.setTitle("Medical Image Workstation");
		
		//set the size of the frame
		jf.setSize(650, 700);
		
		//set close operation
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the frame to be visible
		jf.setVisible(true);
   
   }


}