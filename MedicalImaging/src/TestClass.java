/**
 * 
 */

/**
 * @author jrs9025
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testObserver obv = new testObserver();
		System.out.println(System.getProperty("user.dir")+"\\studies\\axial_head_mri");
		localStudy study = new localStudy(System.getProperty("user.dir")+"\\studies\\axial_head_mri");
		study.addObserver(obv);
		Command open= new openStudyCommand(study);
		Command command = new scrollForwardStudyCommand(study);
		open.execute();
		command.execute();
		

	}

}
