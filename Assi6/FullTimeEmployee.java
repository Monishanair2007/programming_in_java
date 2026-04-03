public class FullTimeEmployee extends Employee {

    double baseSalary; // Fixed monthly/base salary
    String role;       // Role of employee (e.g., SWE, HR)

    // Constructor to initialize full-time employee details
    FullTimeEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId,
                     double baseSalary, String role) {

        // Calling parent class constructor
        super(name, panNo, joiningDate, designation, empId);

        // Initializing full-time specific attributes
        this.baseSalary = baseSalary;
        this.role = role;
    }

    // Overriding method to calculate total CTC
    @Override
    double calcCTC() {

        // If role is Software Engineer → 20% performance bonus
        if (role.equalsIgnoreCase("SWE")) {
            double perfBonus = 0.2 * baseSalary;
            return baseSalary + perfBonus;
        }

        // If role is HR → 10% hiring commission
        else if (role.equalsIgnoreCase("HR")) {
            double hiringCommission = 0.1 * baseSalary;
            return baseSalary + hiringCommission;
        }

        // Default case → no extra benefits
        return baseSalary;
    }
}