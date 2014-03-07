public class scrollForwardStudyCommand implements Command{
	Study study;
	
	public scrollForwardStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.scrollForward();
	}
}