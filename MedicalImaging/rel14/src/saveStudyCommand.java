public class saveStudyCommand implements Command{
	Study study;
	
	public saveStudyCommand(Study s){
		this.study=s;
	}
	
	public void execute(){
		study.save();
	}
}