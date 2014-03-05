/*interface for the study classes
 * @author team3*/
import java.util.Observable;
public interface Study implements Observable {	
	final int min=1;
	final int max=4;
	
	public void open();

	public void save();

	public void copy();

	public void scrollForward();

	public void scrollBack();

	public void changeDisplay();

	public void exitStudy();
}
