public class Manager extends FullTimeEmployee {

    double TA;            // Travel Allowance
    double eduAllowance;  // Education Allowance

    Manager(String name, String panNo, String joiningDate,
            String designation, int empId,
            double baseSalary, String role,
            double TA, double eduAllowance) {

        super(name, panNo, joiningDate, designation, empId, baseSalary, role);
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    double calcCTC() {

        double perfBonus = 0.2 * baseSalary; // Manager bonus
        return baseSalary + perfBonus + TA + eduAllowance;
    }
}