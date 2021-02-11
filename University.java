/**
 * @author Joshua Prout jnp207@exeter.ac.uk
 */

import java.util.Arrays;
import java.util.Scanner;



public class University {

	private ModuleDescriptor[] moduleDescriptors;
	
	private Student[] students;
	
	private Module[] modules;


	public University(){
		ModuleDescriptor[] blankDescriptor = {};
		Student[] blankStudents = {};
		Module[] blankModules = {};
		
		this.moduleDescriptors = blankDescriptor;
		this.students = blankStudents;
		this.modules = blankModules;
	}
	
	/**
	 *@param ModuleDescriptor NewModuleDesc, adds new module descriptor to array
	 */
	public void addModuleDescriptor(ModuleDescriptor newModuleDesc){
		ModuleDescriptor[] newModuleDescs = Arrays.copyOf(this.moduleDescriptors, this.moduleDescriptors.length + 1);
		newModuleDescs[newModuleDescs.length-1] = newModuleDesc;
		this.moduleDescriptors = newModuleDescs;
	}
	
	/**
	 *@param Student newStuden, adds new student to array
	 */
	public void addStudent(Student newStudent) {
		Student[] newStudents = Arrays.copyOf(this.students, this.students.length + 1);
		newStudents[newStudents.length-1] = newStudent;
		this.students = newStudents;
	}
	
	/**
	 *@param Module NewModule, adds new module to array
	 */
	public void addModule(Module newModule) {
		Module[] newModules = Arrays.copyOf(this.modules, this.modules.length + 1);
		newModules[newModules.length-1] = newModule;
		this.modules = newModules;
	}
	
	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		
		return students.length();
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		Student highestStudent = students[0];
		for(Student student: students) {
			if(student.getGpa() > highestStudent.gpa){
				highestStudent = student;
			}	
		}
		return highestStudent;		
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		Module highestModule = module[0];
		for (Module module: modules) {
			if (module.getFinalAverageGrade() > highestModule.getFinalAverageGrade()){
				highestModule = module;
			}
		}
		
		return highestModule;
	}
	
	public boolean isIDUnique(int ID) {
		
		boolean found = false;
		for(Student student : students) {
			if(student.getID() == ID){
				found = true;
				break;
			}
		}	
		return found;
	}		
		
	public Student getStudentByID(int id){
		for(Student student: students){
			if (student.getID = id) {
				return student;
			}
		}
	}
		
	public Module getModuleByCode(String code) {
		for(Module module: modules) {
			if (Module.getModuleCode() == code){}
		}
	}
	
		
	
	public static void main(String[] args) {
		// TODO - needs to be implemented
		University uni = new University();
			
		// Adds Module Descriptors to array
		uni.addModuleDescriptor(new ModuleDescriptor("Real World Mathematics", "ECM0002", new double[] {0.1,0.3,0.6}));
		uni.addModuleDescriptor(new ModuleDescriptor("Programming", "ECM1400", new double[] {0.25,0.25,0.25,0.25}));
		uni.addModuleDescriptor(new ModuleDescriptor("Data Structures", "ECM1406", new double[] {0.25,0.25,0.5}));
		uni.addModuleDescriptor(new ModuleDescriptor("Object-Oriented Programming", "ECM1410", new double[] {0.2,0.3,0.5}));
		uni.addModuleDescriptor(new ModuleDescriptor("Information Systems", "BEM2027", new double[] {0.1,0.3,0.3,0.3}));
		uni.addModuleDescriptor(new ModuleDescriptor("Thermal Physics", "PHY2023", new double[] {0.4,0.6}));
		
		// Adds students
		uni.addStudent(new Student(1000, "Ana", 'F'));
		uni.addStudent(new Student(1001, "Oliver", 'M'));
		uni.addStudent(new Student(1002, "Mary", 'F'));
		uni.addStudent(new Student(1003, "John", 'M'));
		uni.addStudent(new Student(1004, "Noah", 'M'));
		uni.addStudent(new Student(1005, "Chico", 'M'));
		uni.addStudent(new Student(1006, "Maria", 'F'));
		uni.addStudent(new Student(1007, "Mark", 'X'));
		uni.addStudent(new Student(1008, "Lia", 'F'));
		uni.addStudent(new Student(1009, "Rachel", 'F'));
		
		
		// Adds student record
		double[] marks = {70,85,60};
		StudentRecord record = new StudentRecord(student, module, marks);
		student.addRecord(record);
		module.addRecord(record);
		
		// Adds student records
		
		
		//Prints student transcript
		String script = student.printTranscript();
		System.out.println(script);
	}	
}
