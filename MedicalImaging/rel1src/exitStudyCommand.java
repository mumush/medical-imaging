public class exitStudyCommand implements Command{
	Study study;
	
	public exitStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.exitStudy();
	}
}