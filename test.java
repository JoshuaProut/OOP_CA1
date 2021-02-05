public class test{

public static void main(String[] args) {
		
		// Creates Module Descriptor
		double[] weights = {0.2, 0.3, 0.5};
		ModuleDescriptor oop = new ModuleDescriptor("", "OOP", weights);
		
		// Creates student
		Student student = new Student(1000, "Ana", 'F');
	}
}