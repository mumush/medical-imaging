public class copyStudyCommand implements Command{
	Study study;
	
	public copyStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.copy();
	}
}