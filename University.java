public class University {

	private ModuleDescriptor[] moduleDescriptors;
	
	private Student[] students;
	
	private Module[] modules;

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		// TODO - needs to be implemented
		return null;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		// TODO - needs to be implemented
		return null;
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		// TODO - needs to be implemented
		return null;
	}
	
	public static boolean isIDUnique(int ID) {
		
		boolean found = false;
		for(Student student : students) {
			if(student.getID() == ID){
				found = true;
				break;
			}
		}	
		return found;
	}		
		
	
	public static void main(String[] args) {
		// TODO - needs to be implemented
		
		
	}
	
}
