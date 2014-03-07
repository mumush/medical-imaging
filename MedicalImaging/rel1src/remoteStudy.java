/**
 * 
 */

/**
 * @author dsw3144
 *
 */
public class remoteStudy implements Study {

	int displayState=1;
	
	boolean current= false;
	
	int currentImage= 0;
	
	/* (non-Javadoc)
	 * @see Study#open()
	 */
	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Study#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Study#copy()
	 */
	@Override
	public void copy(String dir) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Study#scrollForward()
	 */
	@Override
	public void scrollForward() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Study#scrollBack()
	 */
	@Override
	public void scrollBack() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see Study#changeDisplay()
	 */
	@Override
	public void changeDisplay() {
		// TODO Auto-generated method stub
		if(displayState == min){
			displayState = max;
		}
		else{
			displayState = min;
		}

	}

	/* (non-Javadoc)
	 * @see Study#exitStudy()
	 */
	@Override
	public void exitStudy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void copy(String fileDir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

}
