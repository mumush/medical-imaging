public class changeDisplayStudyCommand implements Command{
	Study study;
	
	public changeDisplayStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.changeDisplay();
	}
}