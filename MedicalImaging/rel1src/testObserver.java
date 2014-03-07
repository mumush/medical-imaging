import java.util.Observable;
import java.util.Observer;


public class testObserver implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		localStudy study;
		study = (localStudy) arg0;
		if(arg1=="next image"){
			System.out.println(study.imageList.get(study.currentImage).getAddress());
		}
		
	}

}
