import java.util.*;

public class PayrollSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter PAN No: ");
            String pan = sc.nextLine();

            System.out.print("Enter Joining Date: ");
            String date = sc.nextLine();

            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine();

            System.out.println("Select Employee Type:");
            System.out.println("1. Full Time");
            System.out.println("2. Contract");
            System.out.println("3. Manager");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                // Full-Time Employee
                System.out.print("Enter Base Salary: ");
                double baseSalary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Role (SWE/HR): ");
                String role = sc.nextLine();

                employees.add(new FullTimeEmployee(
                        name, pan, date, designation, empId, baseSalary, role));

            } else if (choice == 2) {

                // Contract Employee
                System.out.print("Enter Number of Hours: ");
                int hours = sc.nextInt();

                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();

                employees.add(new ContractEmployee(
                        name, pan, date, designation, empId, hours, rate));

            } else if (choice == 3) {

                // Manager
                System.out.print("Enter Base Salary: ");
                double baseSalary = sc.nextDouble();

                System.out.print("Enter TA: ");
                double TA = sc.nextDouble();

                System.out.print("Enter Education Allowance: ");
                double edu = sc.nextDouble();
                sc.nextLine();

                employees.add(new Manager(
                        name, pan, date, designation, empId,
                        baseSalary, "SWE", TA, edu));
            }
        }

        // Display Output
        System.out.printf("\n%-15s %-12s %-20s %-12s\n",
                "Name", "Salary", "Employee Type", "CTC");

        for (Employee emp : employees) {

            double salary = 0;

            if (emp instanceof FullTimeEmployee) {
                salary = ((FullTimeEmployee) emp).baseSalary;
            } else if (emp instanceof ContractEmployee) {
                salary = ((ContractEmployee) emp).hourlyRate;
            }

            System.out.printf("%-15s %-12.2f %-20s %-12.2f\n",
                    emp.name,
                    salary,
                    emp.getEmployeeType(),
                    emp.calcCTC());
        }

        sc.close();
    }
}