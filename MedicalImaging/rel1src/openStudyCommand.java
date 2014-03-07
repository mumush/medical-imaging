public class openStudyCommand implements Command{
	Study study;
	
	public openStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.open();
	}
}