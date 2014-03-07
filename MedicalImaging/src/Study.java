/*interface for the study classes
 * @author team3*/
import java.io.Serializable;
import java.util.ArrayList;

public interface Study extends Serializable {	

	final int min=1;
	final int max=4;
	
	public void open();

	public void setDisplayState(int i);
	
	public void setCurrentImage(int i);
	
	public void setIterator(ImageIterator i);
	
	public void setImageList(ArrayList<Image> i);
	
	public void setDirectory(String s);
	
	public int getDisplayState();
	
	public int getCurrentImage();
	
	public ImageIterator getIterator();
	
	public ArrayList<Image> getImageList();
	
	public String getDirectory();
	
	public void save();

	public Study copy();

	public void scrollForward();

	public void scrollBack();

	public void changeDisplay();

	public void exitStudy();
   
}
