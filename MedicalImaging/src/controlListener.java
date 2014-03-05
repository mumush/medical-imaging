/**
*	@author Ryan Hoffmann
	@version 3/3/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class controlListener implements ActionListener {

	//public variable which references the gui class
	Workstation workstationClass;


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
		
	
	}

}

