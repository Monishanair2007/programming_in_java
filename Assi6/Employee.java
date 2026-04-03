// Abstract Base Class
public abstract class Employee {

    String name;
    String panNo;
    String joiningDate;
    String designation;
    int empId;

    // Constructor to initialize common employee details
    Employee(String name, String panNo, String joiningDate, String designation, int empId) {
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    // Abstract method → must be implemented by child classes
    abstract double calcCTC();

    // Method to return the type of employee (class name)
    String getEmployeeType() {
        return this.getClass().getSimpleName();
    }

    // Method to display basic employee details
    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("PAN: " + panNo);
        System.out.println("Joining Date: " + joiningDate);
    }
}