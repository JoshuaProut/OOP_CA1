import java.util.Arrays;

public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records;

	public Student(int id, String name, char gender) {

		// TODO university.checkID()
		// id, name and gender validation
		// TODO accept empty gender variable
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		} else if (gender == 'B') {
			throw new IllegalArgumentException("Not a valid gender choice");
		}
		this.id = id;
		this.name = name;
		this.gender = gender;
		
		StudentRecord[] newArray = {};
		this.records = newArray;
	}

	/**
	 *Adds a new StudentRecord to the records array
	 *
	 * @param newRecord StudentRecord to be added
	 */
	public void addRecord(StudentRecord newRecord) {
		
		// Adds new record to records array
		StudentRecord[] newRecords = Arrays.copyOf(this.records, this.records.length + 1);
		newRecords[newRecords.length - 1] = newRecord;
		this.records = newRecords;
		
		
		// As new record created, recalculate gpa
		double total = 0;
		double count = 0;
		for (StudentRecord record : records) {
			double finalScore = record.getFinalScore();
			total += finalScore;
			count++;
		}
		this.gpa = total / count;
	}

	/** 
	*Returns transcript for student
	*@return String formatted script containing 
	*/ 
	
	public String printTranscript() {
		//Creates initial part of transcript
		String script = "University of Knowledge Official Transcript\n\n\nID: " 
		+ Integer.toString(id) + "\nName: " + name + "\nGPA: " + Double.toString(gpa) 
		+ "\n\n" ;
		
		//Creates line for each student record
		for(StudentRecord record: records){
			Module module = record.getModule();
			int year = module.getYear();
			byte term = module.getTerm();
			String moduleCode = module.getModuleCode();
			double finalScore = record.getFinalScore();
			System.out.println(moduleCode);
			
			script = script + "| "+ Integer.toString(year) + " | " + Byte.toString(term)  + 
			" | " + moduleCode + " | " + Double.toString(finalScore) + " | \n";
		}
		
		return script;
	}

	public int getID() {
		return id;
	}
	
	public double getGpa(){
		return gpa;
	
	//Object variable tester
	public void printAll() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(gender);
	}
	
}