import java.util.*;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display All");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    customers.add(new Customer(id, name));
                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();

                    Customer found = null;

                    for (Customer c : customers) {
                        if (c.getId() == cid) {
                            found = c;
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.println("1. Savings  2. Loan");
                        int type = sc.nextInt();

                        System.out.print("Enter Account No: ");
                        int accNo = sc.nextInt();

                        System.out.print("Enter Initial Amount: ");
                        double bal = sc.nextDouble();

                        if (type == 1) {
                            found.addAccount(new SavingsAccount(accNo, bal));
                            System.out.println("Savings Account added!");
                        } else {
                            found.addAccount(new LoanAccount(accNo, bal));
                            System.out.println("Loan Account added!");
                        }
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int did = sc.nextInt();

                    for (Customer c : customers) {
                        if (c.getId() == did) {

                            System.out.print("Enter Account No: ");
                            int accNo = sc.nextInt();
                            sc.nextLine();

                            for (Account acc : c.getAccounts()) {

                                if (acc.accountNumber == accNo) {

                                    System.out.print("Enter amount: ");
                                    double amt = sc.nextDouble();
                                    sc.nextLine();

                                    System.out.print("Enter note: ");
                                    String note = sc.nextLine();

                                    acc.deposit(amt, note);
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int wid = sc.nextInt();

                    for (Customer c : customers) {
                        if (c.getId() == wid) {

                            System.out.print("Enter Account No: ");
                            int accNo = sc.nextInt();
                            sc.nextLine();

                            for (Account acc : c.getAccounts()) {

                                if (acc.accountNumber == accNo) {

                                    System.out.print("Enter amount: ");
                                    double amt = sc.nextDouble();
                                    sc.nextLine();

                                    System.out.print("Enter mode: ");
                                    String mode = sc.nextLine();

                                    acc.withdraw(amt, mode);
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n===== ALL CUSTOMER DETAILS =====");

                    for (Customer c : customers) {
                        c.display();
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}