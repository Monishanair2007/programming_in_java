public class ContractEmployee extends Employee {

    int noOfHours;     // Number of hours worked
    double hourlyRate; // Payment per hour

    // Constructor to initialize contract employee details
    ContractEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId,
                     int noOfHours, double hourlyRate) {

        // Calling parent class constructor
        super(name, panNo, joiningDate, designation, empId);

        // Initializing contract-specific attributes
        this.noOfHours = noOfHours;
        this.hourlyRate = hourlyRate;
    }

    // Overriding method to calculate total cost (CTC)
    @Override
    double calcCTC() {
        return noOfHours * hourlyRate; // Total pay = hours × rate
    }
}