/*iterator implementation
@author Douglas Weber
*/

//import library's for arrayList and Image
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Iterator implements ImageIterator{

	/*attributes of the class iterator
	has a list of images and the current position in the list*/
	private ArrayList<Image> images;
	private int position;

	/* constructor takes in the image list from study and the current
	position attribute and uses them to build the iterator*/
	public Iterator(ArrayList<Image> list,int current){
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
		/*test position without changing position
		*testing 7 forward since four forward just checks for the existance of the top
		*left image, so we need to make sure we can display the next four*/
		int test=position+7;

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
	public int next(){
		if(hasNext()){
			return position++;
		}
		else{
			return position;
		}
	}

	//override next4()
	public int next4(){
		if(has4Next()){
			position=position+4;
			return position;
		}
		else{
			return position;
		}
	}

	//override previous()
	public int previous(){
		if(hasPrevious()){
			return (position--);
		}
		else{
			return position;	
		}
	}

	//override previous4()
	public int previous4(){
		if(has4Previous()){
			position=position-4;
			return position;
		}
		else{
			return 0;	
		}
	}
	//getters and setters//
	public int getPosition() {
		
		return this.position;
	}

	public void setPosition(int i) {
		this.position=i;
		
	}

	public void setImageList(ArrayList<Image> i) {
		this.images=i;
		
	}

	public ArrayList<Image> getImageList() {
		
		return this.images;
	}
}
