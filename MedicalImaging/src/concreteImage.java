/**
 * 
 */

/**
 * @author dsw3144
 *
 */
//import for the BufferedImage
import java.awt.*;
public class concreteImage implements Image {

	private String add;
	
	public concreteImage(String address) {
		
		add=address;
	}

	@Override
	public Image displayImage() {
		BufferedImage image=ImageIO.read(new File(add));
		
		return image;
		
	}
	

}
