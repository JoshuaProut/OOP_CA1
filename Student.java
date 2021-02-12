import java.util.Arrays;

/**
 * Represents a student at the university, contains their id, name, gender(optional),
 * grade point average and their records for each module 
 */

public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records;

	/**
	 * Constructor for student with gender
	 *
	 * @param id
	 * @param name
	 * @param gender must be M, F, or X. No gender can also be given using the other constructor
	 * @param uni is passed so that the constructor can check that the id doesn't exist in the university already
	 */

	public Student(int id, String name, char gender, University uni) {

		// Checks that the ID is unique for the university it has been submitted for
		if (uni.checkId(id) == true) {
			throw new IllegalArgumentException("ID must be unique");
		}

		//Checks that name isn't empty
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}

		//Checks that gender is one of the recognised characters
		else if (gender != 'M' && gender!= 'F' && gender != 'X') {
			throw new IllegalArgumentException("Not a valid gender choice");
		}
		
		// Initializes variables
		this.id = id;
		this.name = name;
		this.gender = gender;
		
		// Initilizes blank records array, to be added to later
		StudentRecord[] newArray = {};
		this.records = newArray;
	}
	
	/** 
	 * Constructor for student without gender
	 * @param id
	 * @param name
	 * @param uni is passed so that the constructor can check that the id doesn't exist in the university already
	 */
	public Student(int id, String name, University uni) {

		// Validates that the ID is unique for the university it has been submitted for
		if (uni.checkId(id) == true) {
			throw new IllegalArgumentException("ID must be unique");
		}
		
		//Validates that name isn't empty
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
	
		
		// Initializes variables
		this.id = id;
		this.name = name;
		
		// Initilizes blank records array, to be added to later
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
			
			script = script + "| "+ Integer.toString(year) + " | " + Byte.toString(term)  + 
			" | " + moduleCode + " | " + Double.toString(finalScore) + " | \n";
		}
		
		return script;
	}

	public int getId() {
		return id;
	}
	
	public double getGpa(){
		return gpa;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Invokes the setAboveAverage method for each record, to find if the student is above average
	 * in that module.
	 */
	public void setAboveAverage(){
		for (StudentRecord record: records) {
			record.setAboveAverage();
		}
	}
	
}