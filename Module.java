public class Module {
	
	private int year;
	
	private byte term;
	
	private ModuleDescriptor module;
	
	private StudentRecord[] records;
	
	private double finalAverageGrade;
	
	public Module(int year, byte term, ModuleDescriptor module, StudentRecord[] records, double FinalAverageGrade) {
		this.year = year;
		this.term = term;
		this.module = module;
		this.records = records;
		
		// Calculate final average grade
		float total = 0.0;
		int count = 0;
		for(StudentRecord record: records){
			total += record.getFinalScore();
			count++;
		}
		this.finalAverageGrade= total/count;
		
	}
	
	public float getFinalAverageGrade(){
		return finalAverageGrade;
	}
}

