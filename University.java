package joshuaprout;

import joshuaprout.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the main class for the university data management app.
 *
 * @author Joshua Prout jnp207@exeter.ac.uk
 */

public class University {

    private ModuleDescriptor[] moduleDescriptors;

    private Student[] students;

    private Module[] modules;

    /**
     * Constructor for university class.
     * <p>
     * Takes no parameters, arrays are filled later
     */
    public University() {
        ModuleDescriptor[] blankDescriptor = {};
        Student[] blankStudents = {};
        Module[] blankModules = {};

        this.moduleDescriptors = blankDescriptor;
        this.students = blankStudents;
        this.modules = blankModules;
    }

    /**
     * Adds new module descriptor to module descriptors array.
     *
     * @param NewModuleDesc New module descriptor to add to array
     */
    public void addModuleDescriptor(ModuleDescriptor newModuleDesc) {
        ModuleDescriptor[] newModuleDescs = Arrays.copyOf(this.moduleDescriptors, this.moduleDescriptors.length + 1);
        newModuleDescs[newModuleDescs.length - 1] = newModuleDesc;
        this.moduleDescriptors = newModuleDescs;
    }

    /**
     * Adds new student to students array.
     *
     * @param Student newStudent, adds new student to array
     */
    public void addStudent(Student newStudent) {
        Student[] newStudents = Arrays.copyOf(this.students, this.students.length + 1);
        newStudents[newStudents.length - 1] = newStudent;
        this.students = newStudents;
    }

    /**
     * Adds new module to the array
     *
     * @param Module NewModule, adds new module to array
     */
    public void addModule(Module newModule) {
        Module[] newModules = Arrays.copyOf(this.modules, this.modules.length + 1);
        newModules[newModules.length - 1] = newModule;
        this.modules = newModules;
    }

    /**
     * Returns number of students in the university system
     *
     * @return numberOfStudents The number of students registered in the system.
     */
    public int getTotalNumberStudents() {

        return students.length;
    }

    /**
     * Returns student with the highest GPA
     *
     * @return The student with the highest GPA.
     */
    public Student getBestStudent() {
        Student highestStudent = students[0];
        for (Student student : students) {
            if (student.getGpa() > highestStudent.getGpa()) {
                highestStudent = student;
            }
        }
        return highestStudent;
    }

    /**
     * @return The module with the highest average score.
     */
    public Module getBestModule() {
        Module highestModule = modules[0];
        for (Module module : modules) {
            if (module.getFinalAverageGrade() > highestModule.getFinalAverageGrade()) {
                highestModule = module;
            }
        }

        return highestModule;
    }

    /**
     * Checks if ID has already been taken by another student in the system
     *
     * @return true if ID is not available
     */
    public boolean checkId(int theId) {

        boolean found = false;
        for (Student student : students) {
            int id = student.getId();
            if (id == theId) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @return the student with the given ID
     */
    public Student getStudentById(int theId) {

        for (Student student : students) {
            if (student.getId() == theId) {
                return student;
            }
        }
        return null;
    }

    /**
     * Calls the updateAboveAverage method for each student.
     * <p>
     * This will compare their score for each student record against the average for
     * the module
     */
    public void updateAboveAverage() {
        for (Student student : students) {
            student.setAboveAverage();
        }
    }

    /**
     * Creates university object, and inputs and outputs data.
     * <p>
     * Creates a university object, to which the data will be added to
     * Creates Module Descriptors and adds to array, creates Students and adds to array,
     * creates modules and adds to array, then creates and adds student records to the
     * module and student objects
     */
    public static void main(String[] args) {
        // TODO - needs to be implemented
        University uni = new University();

        // Creates Module Descriptors
        ModuleDescriptor ECM0002 = new ModuleDescriptor("ECM0002", "Real World Mathematics", new double[]{0.1, 0.3, 0.6});
        ModuleDescriptor ECM1400 = new ModuleDescriptor("ECM1400", "Programming", new double[]{0.25, 0.25, 0.25, 0.25});
        ModuleDescriptor ECM1406 = new ModuleDescriptor("ECM1406", "Data Structures", new double[]{0.25, 0.25, 0.5});
        ModuleDescriptor ECM1410 = new ModuleDescriptor("ECM1410", "Object-Oriented Programming", new double[]{0.2, 0.3, 0.5});
        ModuleDescriptor BEM2027 = new ModuleDescriptor("BEM2027", "Information Systems", new double[]{0.1, 0.3, 0.3, 0.3});
        ModuleDescriptor PHY2023 = new ModuleDescriptor("PHY2023", "Thermal Physics", new double[]{0.4, 0.6});

        // Adds Module Descriptors to array
        uni.addModuleDescriptor(ECM0002);
        uni.addModuleDescriptor(ECM1400);
        uni.addModuleDescriptor(ECM1406);
        uni.addModuleDescriptor(ECM1410);
        uni.addModuleDescriptor(BEM2027);
        uni.addModuleDescriptor(PHY2023);

        // Creates students and adds to array
        uni.addStudent(new Student(1000, "Ana", 'F', uni));
        uni.addStudent(new Student(1001, "Oliver", 'M', uni));
        uni.addStudent(new Student(1002, "Mary", 'F', uni));
        uni.addStudent(new Student(1003, "John", 'M', uni));
        uni.addStudent(new Student(1004, "Noah", 'M', uni));
        uni.addStudent(new Student(1005, "Chico", 'M', uni));
        uni.addStudent(new Student(1006, "Maria", 'F', uni));
        uni.addStudent(new Student(1007, "Mark", 'X', uni));
        uni.addStudent(new Student(1008, "Lia", 'F', uni));
        uni.addStudent(new Student(1009, "Rachel", 'F', uni));

        // Adds student records

        Student student;
        Module module;
        StudentRecord record;

        // ECM1400 2019 term 1
        module = new Module(2019, (byte) 1, ECM1400);
        uni.addModule(module);

        student = uni.getStudentById(1000);
        record = new StudentRecord(student, module, new double[]{9, 10, 10, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1001);
        record = new StudentRecord(student, module, new double[]{8, 8, 8, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1002);
        record = new StudentRecord(student, module, new double[]{5, 5, 6, 5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1003);
        record = new StudentRecord(student, module, new double[]{6, 4, 7, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1004);
        record = new StudentRecord(student, module, new double[]{10, 9, 10, 9});
        module.addRecord(record);
        student.addRecord(record);

        //PHY 2023 2019 1
        module = new Module(2019, (byte) 1, PHY2023);
        uni.addModule(module);

        student = uni.getStudentById(1005);
        record = new StudentRecord(student, module, new double[]{9, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1006);
        record = new StudentRecord(student, module, new double[]{6, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1007);
        record = new StudentRecord(student, module, new double[]{5, 6});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1008);
        record = new StudentRecord(student, module, new double[]{9, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1009);
        record = new StudentRecord(student, module, new double[]{8, 5});
        module.addRecord(record);
        student.addRecord(record);

        //BEM2027 2019 2
        module = new Module(2019, (byte) 2, BEM2027);
        uni.addModule(module);

        student = uni.getStudentById(1000);
        record = new StudentRecord(student, module, new double[]{10, 10, 9.5, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1001);
        record = new StudentRecord(student, module, new double[]{7, 8.5, 8.2, 8});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1002);
        record = new StudentRecord(student, module, new double[]{6.5, 7.0, 5.5, 8.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1003);
        record = new StudentRecord(student, module, new double[]{5.5, 5, 6.5, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1004);
        record = new StudentRecord(student, module, new double[]{7, 5, 8, 6});
        module.addRecord(record);
        student.addRecord(record);

        //ECM1400 2019 2
        module = new Module(2019, (byte) 2, ECM1400);
        uni.addModule(module);

        student = uni.getStudentById(1005);
        record = new StudentRecord(student, module, new double[]{9, 10, 10, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1006);
        record = new StudentRecord(student, module, new double[]{8, 8, 8, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1007);
        record = new StudentRecord(student, module, new double[]{5, 5, 6, 5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1008);
        record = new StudentRecord(student, module, new double[]{6, 4, 7, 9});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1009);
        record = new StudentRecord(student, module, new double[]{10, 9, 8, 9});
        module.addRecord(record);
        student.addRecord(record);


        // ECM1406 2020 1
        module = new Module(2020, (byte) 1, ECM1406);
        uni.addModule(module);

        student = uni.getStudentById(1000);
        record = new StudentRecord(student, module, new double[]{10, 10, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1001);
        record = new StudentRecord(student, module, new double[]{8, 7.5, 7.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1002);
        record = new StudentRecord(student, module, new double[]{9, 7, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1003);
        record = new StudentRecord(student, module, new double[]{9, 8, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1004);
        record = new StudentRecord(student, module, new double[]{2, 7, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1005);
        record = new StudentRecord(student, module, new double[]{10, 10, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1006);
        record = new StudentRecord(student, module, new double[]{8, 7.5, 7.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1007);
        record = new StudentRecord(student, module, new double[]{10, 10, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1008);
        record = new StudentRecord(student, module, new double[]{9, 8, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1009);
        record = new StudentRecord(student, module, new double[]{8, 9, 10});
        module.addRecord(record);
        student.addRecord(record);

        //ECM1410 2020 1
        module = new Module(2020, (byte) 1, ECM1410);
        uni.addModule(module);

        student = uni.getStudentById(1000);
        record = new StudentRecord(student, module, new double[]{10, 9, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1001);
        record = new StudentRecord(student, module, new double[]{8.5, 9, 7.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1002);
        record = new StudentRecord(student, module, new double[]{10, 10, 5.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1003);
        record = new StudentRecord(student, module, new double[]{7, 7, 7});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1004);
        record = new StudentRecord(student, module, new double[]{5, 6, 10});
        module.addRecord(record);
        student.addRecord(record);

        //ECM0002 2020 2
        module = new Module(2020, (byte) 2, ECM0002);
        uni.addModule(module);
        student = uni.getStudentById(1005);
        record = new StudentRecord(student, module, new double[]{8, 9, 8});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1006);
        record = new StudentRecord(student, module, new double[]{6.5, 9, 9.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1007);
        record = new StudentRecord(student, module, new double[]{8.5, 10, 8.5});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1008);
        record = new StudentRecord(student, module, new double[]{7.5, 8, 10});
        module.addRecord(record);
        student.addRecord(record);
        student = uni.getStudentById(1009);
        record = new StudentRecord(student, module, new double[]{10, 6, 10});
        module.addRecord(record);
        student.addRecord(record);

        // Calculates if each student is above average
        uni.updateAboveAverage();

        //Prints number of students
        int numberOfStudents = uni.getTotalNumberStudents();
        System.out.println("Number of students " + numberOfStudents);

        //Prints best student
        Student bestStudent = uni.getBestStudent();
        System.out.println("Best student " + bestStudent.getName());

        //Prints best student's transcript
        System.out.println(bestStudent.printTranscript());

        //Prints best module
        Module bestModule = uni.getBestModule();
        System.out.println("Best Module " + bestModule.getModuleCode());
    }
}
