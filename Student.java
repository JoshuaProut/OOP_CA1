public class Student {
	
	private int id;
	
	private String name;
	
	private char gender;
	
	private double gpa;
	
	private StudentRecord[] records;
	
	public Student(int id, String name, char gender){
		
		// TODO university.checkID()
		
		// id, name and gender validation
		if(id == null || id = ""){
			throw IllegalArgumentException("ID cannot be empty");
		} else if (name == null || name = ""){
			throw IllegalArgumentException("Name cannot be empty");
		} else if ( gender != 'F' || gender != 'M' || gender != 'X' || gender != ''){
			throw IllegalArgumentException("Not a valid gender gender choice");
		} 
		this.id = id;
		this.name = name;
		this.gender = gender;
		
		
		// Calculate gpa
		double total = 0;
		double count = 0;
		for(StudentRecord record : records){
			double finalScore = record.getFinalScore;
			total += finalScore;
			count++;
		}
		this.gpa = total/count;
		
	}
		

	public String printTranscript() {
		// do something
		return "";
	}
	
	public int getID(){
		return id
}
