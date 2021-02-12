

public class StudentRecord {

	private Student student;
	
	private Module module;
	
	private double[] marks;
	
	private double finalScore;
	
	private Boolean isAboveAverage;

	/**
	 * Constructor for Student Record
	 *@param student
	 *@param module
	 *@param marks each mark must be between 0 and 100
	 */
	public StudentRecord(Student student, Module module, double[] marks) {
		
		
		// Validates that each mark is between 0 and 100
		for (double mark : marks) {
			if(mark > 100 || mark < 0) {
				throw new IllegalArgumentException("Each mark must be between 0 and 100");
			}
		}
		
		
		
		// Calculates final score
		double total = 0.0;
		int count = 0;
		for(double score: marks) {
			total += score;
			count++;
		}
		
		// Inits variables
		this.student = student;
		this.module = module;
		this.marks = marks;
		this.finalScore = total/count;
	}
	
	/**
	 * Calculates if the student is above average for the module
	 */
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

