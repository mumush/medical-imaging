/**
 * Controller.java
 * Version:
 * 		$Id$
 * Revision:
 * 		$Log$
 */

/**
 * @author John/Doug
 * 3-6-14
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller{
	
	ArrayList<Study> studyList;
	
	public Controller(ArrayList l){
		this.studyList=l;
	}

	public void generateCommand(String comm, String dir){
		//commands are copy exit open save scrollBack scrollForward
		Study stud=null;		
		for(int i=0; i<studyList.size();i++){
			if(studyList.get(i).getDirectory().equals(dir)){
				stud=studyList.get(i);
			}
		}		
		Command command;
		if(comm.equals("copy")){
			command= new copyStudyCommand(stud);
		}
		else if(comm.equals("exit")){
			command= new exitStudyCommand(stud);
		}
		else if(comm.equals("open")){
			command= new openStudyCommand(stud);
		}
		else if(comm.equals("save")){
			command= new saveStudyCommand(stud);
		}
		else if(comm.equals("scrollBack")){
			command= new scrollBackStudyCommand(stud);
		}
		else{
			command= new scrollForwardStudyCommand(stud);
		}
		command.execute();		
	}

}
