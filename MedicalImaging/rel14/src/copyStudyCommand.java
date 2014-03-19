public class copyStudyCommand implements Command{
	Study study;
	String copyStudy;
	public copyStudyCommand(Study s, String newStudy){
		this.study=s;
		this.copyStudy=newStudy;
	}
	
	public void execute(){
		study.copy(copyStudy);
	}
}