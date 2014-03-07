public class scrollBackStudyCommand implements Command{
	Study study;
	
	public scrollBackStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.scrollBack();
	}
}