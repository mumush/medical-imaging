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
	String defaultName=null;
	
	
	//constructor
	public Controller(ArrayList l){
		this.studyList=l;
	}
	
	//adds study to the list
	public void addStudy(Study study){
		studyList.add(study);
	}
	public void setDefalut(String s){
		defaultName= s;
	}
	
	public String getDefault(){
		return defaultName;
	}
	
	
	
	
	//genterates a command object and executes it
	public void generateCommand(String comm, String dir){
		//commands are copy exit open save scrollBack scrollForward
		Study stud = null;		
		for(int i=0; i<studyList.size();i++){
			if(studyList.get(i).getDirectory().equals(dir)){
				stud=studyList.get(i);
			}
		}		
		Command command;
		if(comm.equals("scrollForward")){
			command= new scrollForwardStudyCommand(stud);
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
		else if(comm.equals("changeDisplay")){
			command= new changeDisplayStudyCommand(stud);
		}
		else{
			command= new copyStudyCommand(stud,comm);
		}
		command.execute();		
	}

}
