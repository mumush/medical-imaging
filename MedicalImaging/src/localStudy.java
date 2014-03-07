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
			Image image = new Image(child.getAbsolutePath());
			imageList.add(image);
		}
		int listMod=imageList.size() % 4;
		if(listMod!=0){
			for(listMod = imageList.size() % 4; listMod != 4; listMod++){
				Image blank = new Image("blank");
				imageList.add(blank);
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
         		out.writeObject(this);
         		out.close();
        	 	fileOut.close();
        	 	System.out.printf("Serialized data is saved");
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
	public void copy(String fileDir) {
		
		File source = new File(directory);
		File dest = new File(fileDir);
      
		try {
		   copyFolder(source, dest);
		} 
      catch (IOException e) {
			e.printStackTrace();
		}
      
		notifyObservers(new localStudy(fileDir));
	}
   
	private static void copyFolder(File source, File dest) throws IOException {

	if( source.isDirectory() ){

		//if the directory doesn't exist, create one
		if( !dest.exists() ) {
      
		   dest.mkdir();
		   System.out.println("Directory copied!");
         
		}

		String filesArray[] = source.list();

      //for each file in the array of all files in the source dir
		for (String file : filesArray) {

		   File sourceFile = new File(source, file);
		   File destFile = new File(dest, file);
         
		   //recursive copy call
		   copyFolder(sourceFile, destFile);
		}

	}
   
   else { //if there's a file, copy it
   
      //create input and output streams
      InputStream inputStream = new FileInputStream(source);
      OutputStream outputStream = new FileOutputStream(dest); 
      
      //initialize byte buffer
      byte[] buffer = new byte[1024];
      
      int length;
      
      //copy file in bytes
      while ((length = inputStream.read(buffer)) > 0) {
      
         outputStream.write(buffer, 0, length);
         
      }
      
      //close streams and output info to system.out
      inputStream.close();
      outputStream.close();
      System.out.println("File copied!");
   }
   
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
		notifyObservers(displayState);

	}
	
	/* (non-Javadoc)
	 * @see Study#exitStudy()
	 */
	@Override
	public void exitStudy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDirectory() {
		// TODO Auto-generated method stub
		return directory;
	}

}
