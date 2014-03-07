/*interface for the study classes
 * @author team3*/
import java.io.Serializable;

public interface Study extends Serializable {	

	final int min=1;
	final int max=4;
	
	public void open();

	public void save();

	public void copy( String fileDir);

	public void scrollForward();

	public void scrollBack();

	public void changeDisplay();

	public void exitStudy();

	public String getDirectory();
   
}
