/*Douglas S. Weber
 *Test for the Iterator class
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//test class for the iterator.java//
public class testIterator {
	
	public static void main(String[] args){
		ArrayList<Image> list=new ArrayList<Image>();
		Image blank = null;
		Iterator iterator;

		//preload the list to size 8
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		iterator=new Iterator(list,0);
		
		//should be 0, testing getter
		System.out.println(iterator.getPosition());
		//test the setter, should be 1
		iterator.setPosition(1);
		System.out.println(iterator.getPosition());
		//test hasNext(),should be true
		System.out.println(iterator.hasNext());
		//test hasNext(), should be false
		iterator.setPosition(7);
		System.out.println(iterator.hasNext());
		//test hasPrevious(),should be true
		System.out.println(iterator.hasPrevious());
		//test hasPrevious(), should be false
		iterator.setPosition(0);
		System.out.println(iterator.hasPrevious());
		//test next(), should print 1
		iterator.next();
		System.out.println(iterator.getPosition());
		//test next() when no next exists. should print 7
		iterator.setPosition(7);
		iterator.next();
		System.out.println(iterator.getPosition());
		//test previous(),should be 6
		iterator.previous();
		System.out.println(iterator.getPosition());
		//test previous(), should stay 0
		iterator.setPosition(0);
		iterator.previous();
		System.out.println(iterator.getPosition());
		//test has4Next(),should be true
		System.out.println(iterator.has4Next());
		//test has4Previous(), should be false
		System.out.println(iterator.has4Previous());
		//test has4Previous(),should be true
		iterator.setPosition(7);
		System.out.println(iterator.has4Previous());
		//test has4Next(),should be false
		System.out.println(iterator.has4Next());
		//test previous4(),should print 3
		iterator.previous4();
		System.out.println(iterator.getPosition());
		//test previous4(), should still print 3
		iterator.previous4();
		System.out.println(iterator.getPosition());
		//one last test,should print 0
		iterator.setPosition(4);
		iterator.previous4();
		System.out.println(iterator.getPosition());
		//test next4(),should print 4
		iterator.next4();
		System.out.println(iterator.getPosition());
		//test next4(), should still print 4
		iterator.next4();
		System.out.println(iterator.getPosition());
		//test setter and getter for the list, should print 12
		list.add(blank);
		list.add(blank);
		list.add(blank);
		list.add(blank);
		iterator.setImageList(list);
		System.out.println(iterator.getImageList().size());
		
		
	}
	
}
