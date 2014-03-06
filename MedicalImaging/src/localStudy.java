/**
 * 
 */

/**
 * @author dsw3144
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
public class localStudy extends Observable implements Study {
	
	int displayState;
	
	int currentImage;	
	
	String directory;
	
	String blankImage;
	
	ImageIterator iter;
	
	ArrayList<Image> imageList= new ArrayList<Image>();
	
	public localStudy(String dirName){
		directory=dirName;
		displayState=min;
		currentImage=0;
	}
	
	/* (non-Javadoc)
	 * @see Study#open()
	 */
	@Override
	public void open() {
		// TODO Auto-generated method stub
		File dir= new File(directory);
		for(File child : dir.listFiles()){
			Image image = new imageProxy(child.getAbsolutePath());
			imageList.add(image);
		}
		int listMod=imageList.size()%4;
		if(listMod!=0){
			for(listMod; listMod!=4; listMod++){
				Image blank = new imageProxy("blank");
				imageList.add(image);
			}
		}
		iter= new Iterator(imageList, currentImage);
		setChanged();
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see Study#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try
		{
         		FileOutputStream fileOut = new FileOutputStream(directory+".ser");
         		ObjectOutputStream out = new ObjectOutputStream(fileOut);
         		out.writeObject(self);
         		out.close();
        	 	fileOut.close();
        	 	System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}
		catch(IOException i)
      		{
          		i.printStackTrace();
      		}
		
	}

	/* (non-Javadoc)
	 * @see Study#copy()
	 */
	@Override
	public Study copy() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see Study#scrollForward()
	 */
	@Override
	public void scrollForward() {
		// TODO Auto-generated method stub
		if(displayState==min){
			currentImage=iter.next();
		}
		else{
			currentImage=iter.next4();
		}
		setChanged();
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see Study#scrollBack()
	 */
	@Override
	public void scrollBack() {
		// TODO Auto-generated method stub
		if(displayState==min){
			currentImage=iter.previous();
		}
		else{
			currentImage=iter.previous4();
		}
		setChanged();
		notifyObservers();

	}

	/* (non-Javadoc)
	 * @see Study#changeDisplay()
	 */
	@Override
	public void changeDisplay() {
		if(displayState == min){
			displayState = max;
		}
		else{
			displayState = min;
		}
		setChanged();
		notifyObservers();

	}
	
	/* (non-Javadoc)
	 * @see Study#exitStudy()
	 */
	@Override
	public void exitStudy() {
		// TODO Auto-generated method stub

	}

}
