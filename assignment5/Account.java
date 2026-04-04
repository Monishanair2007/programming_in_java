// Base abstract class
abstract class Account {
    protected int accountNumber;
    protected double balance;

    // Constructor
    public Account(int accNo, double bal) {
        this.accountNumber = accNo;
        this.balance = bal;
    }

    // Base deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Overloaded deposit method
    public void deposit(double amount, String note) {
        deposit(amount);
        System.out.println("Note: " + note);
    }

    // Abstract withdraw method (must be overridden)
    public abstract void withdraw(double amount);

    // Overloaded withdraw method
    public void withdraw(double amount, String mode) {
        System.out.println("Mode: " + mode);
        withdraw(amount);
    }

    // Abstract display
    public abstract void display();
}