/*iterator implementation
@author Douglas Weber
*/

//import library's for arrayList and Image
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Iterator implements ImageIterator{

	/*attributes of the class iterator
	has a list of images and the current position in the list*/
	private List<Image> images;
	private int position;

	/* constructor takes in the image list from study and the current
	position attribut and uses them to build the iterator*/
	public Iterator(List<Image> list,int current){
		this.images=list;
		this.position=current;
	}

	//override hasNext()
	public boolean hasNext(){
		//test position without changing position
		int test=position+1;

		if(test<images.size()){
			return true;
		}
		else{
			return false;
		}
	}

	//override hasPrevious()
	public boolean hasPrevious(){
		//test position without changing position
		int test=position-1;

		if(test>=0){
			return true;
		}
		else{
			return false;
		}
	}

	//override has4Next()
	public boolean has4Next(){
		//test position without changing position
		int test=position+4;

		if(test<images.size()){
			return true;
		}
		else{
			return false;
		}
	}

	//override has4Previous()
	public boolean has4Previous(){
		//test position without changing position
		int test=position-4;

		if(test>=0){
			return true;
		}
		else{
			return false;
		}
	}

	//override next()
	public Image next(){
		position++;

		return images.get(position);
	}

	//override next4()
	public Image next4(){
		position=position+4;

		return images.get(position);
	}

	//override previous()
	public Image previous(){
		position=position-1;

		return images.get(position);
	}

	//override previous4()
	public Image previous4(){
		position=position-4;

		return images.get(position);
	}
}
