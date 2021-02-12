
public class test{
	

public static void main(String[] args) {
		
		// Creates Module Descriptor
		double[] weights = {0.2, 0.3, 0.5};
		ModuleDescriptor oop = new ModuleDescriptor("ECM1410", "OOP", weights);
		
		// Creates student
		Student student = new Student(1000, "Ana", 'F');
		student.printAll();
		
		// Creates module
		Module module = new Module(2021, (byte)2, oop);
		
		// Adds student record
		double[] marks = {70,85,60};
		StudentRecord record = new StudentRecord(student, module, marks);
		student.addRecord(record);
		module.addRecord(record);
		
		//Prints student transcript
		String script = student.printTranscript();
		System.out.println(script);
	}
}