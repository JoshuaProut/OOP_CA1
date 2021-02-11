

public class StudentRecord {

	private Student student;
	
	private Module module;
	
	private double[] marks;
	
	private double finalScore;
	
	private Boolean isAboveAverage;

	public StudentRecord(Student student, Module module, double[] marks) {
		
		this.student = student;
		this.module = module;
		this.marks = marks;
		
		// Calculates final score
		double total = 0.0;
		int count = 0;
		for(double score: marks) {
			total += score;
			count++;
		}
			
		this.finalScore = total/count;
	}
	// Calculates if the student is above average
	public void setAboveAverage(){
		if (this.finalScore > module.getFinalAverageGrade()){
			this.isAboveAverage = true;
		} else {
			this.isAboveAverage = false;
		}
	}	
	
	public double getFinalScore(){
		return finalScore;
	}
	
	public Module getModule(){
		return module;
	}
}

