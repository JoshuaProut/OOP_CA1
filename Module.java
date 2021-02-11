package ecm1410.ca1.joshuaprout

import java.util.Arrays;

public class Module {
	
	private int year;
	
	private byte term;
	
	private ModuleDescriptor module;
	
	private StudentRecord[] records;
	
	private double finalAverageGrade;
	
	public Module(int year, byte term, ModuleDescriptor module) {
		this.year = year;
		this.term = term;
		this.module = module;
		
		StudentRecord[] newArray = {} ;
		this.records = newArray;
	}
	
	public double getFinalAverageGrade(){
		// Calculate final average grade
		double total = 0.0;
		int count = 0;
		for(StudentRecord record: records){
			total += record.getFinalScore();
			count++;
		}
		this.finalAverageGrade= total/count;
		return finalAverageGrade;
	}
	
	// Adds a student record to the module
	public void addRecord(StudentRecord newRecord) {
		StudentRecord[] newRecords = Arrays.copyOf(this.records, this.records.length + 1);
		newRecords[newRecords.length - 1] = newRecord;
		this.records = newRecords;
	}
	
	public void variableTester() {
		System.out.println(year);
		System.out.println(term);
	}
	
	public int getYear(){
		return year;
	}
	public byte getTerm(){
		return term;
	}
	
	
	public String getModuleCode(){
		String moduleCode = module.getModuleCode();
		return moduleCode;
	}
}

