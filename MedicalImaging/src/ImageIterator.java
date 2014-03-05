/**iterator interface
*@author Douglas
*/

//import for image class
import java.awt.*;
public interface ImageIterator{

	//checks to see if imagelist has more images
	public boolean hasNext();

	//goes to next image
	public int next();

	//checks to see if imagelist has previous images
	public boolean hasPrevious();

	//goes to previous image
	public int previous();

	//checks to see if imagelist has 4 more images
	public boolean has4Next();

	//checks to see if imagelist has 4 previous images
	public boolean has4Previous();

	//goes to next 4 images
	public int next4();

	//goes to previous 4 images
	public int previous4();

}
