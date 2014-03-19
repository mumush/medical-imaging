//Interface for the UI//

import java.util.Observable;
import java.util.Observer;


public interface UI extends Observer {
	
	public void update(Observable arg0, Object arg1);
   
}
