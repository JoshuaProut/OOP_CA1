
import java.util.Arrays;

/**
 * Represents a module in a given term and year, contains the student records of the
 * students on the module and an average mark for all students on the module.
 */

public class Module {

    private int year;

    private byte term;

    private ModuleDescriptor module;

    private StudentRecord[] records;

    private double finalAverageGrade;

    /**
     * Constructor for Module class
     *
     * @param year   that module is in
     * @param term   that module is in
     * @param module Module Descriptor for the module
     */

    public Module(int year, byte term, ModuleDescriptor module) {
        this.year = year;
        this.term = term;
        this.module = module;

        StudentRecord[] newArray = {};
        this.records = newArray;
    }

    /**
     * Gets final average grade of all students on the module.
     *
     * @return finalAverageGrade
     */
    public double getFinalAverageGrade() {
        // Calculate final average grade
        double total = 0.0;
        int count = 0;
        for (StudentRecord record : records) {
            total += record.getFinalScore();
            count++;
        }
        this.finalAverageGrade = total / count;
        return finalAverageGrade;
    }

    /**
     * Adds a student record to the module.
     *
     * @param newRecord Studentrecord to add to records array.
     */
    public void addRecord(StudentRecord newRecord) {
        StudentRecord[] newRecords = Arrays.copyOf(this.records, this.records.length + 1);
        newRecords[newRecords.length - 1] = newRecord;
        this.records = newRecords;
    }

    public int getYear() {
        return year;
    }

    public byte getTerm() {
        return term;
    }

    public String getModuleCode() {
        String moduleCode = module.getModuleCode();
        return moduleCode;
    }
}

