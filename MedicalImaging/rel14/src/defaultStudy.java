import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*Douglas Weber
 * 3-17-14*/
public class defaultStudy implements Serializable {
	
	//default study is de
	private String de="";

	public defaultStudy(String s){
		de=s;
	}
	
	public void save(){
		try
		{
			FileOutputStream fileOut = new FileOutputStream("default.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Default study is saved");
		}
		catch(IOException i)
		{
      		i.printStackTrace();
  		}
	}
	
	public String getName(){
		return de;
	}
}
