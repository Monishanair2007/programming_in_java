import java.util.ArrayList;

// Customer class
class Customer {
    private int id;
    private String name;
    private ArrayList<Account> accounts;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Display customer and all accounts
    public void display() {
        System.out.println("\nCustomer ID: " + id);
        System.out.println("Name: " + name);

        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
        } else {
            for (Account acc : accounts) {
                acc.display();
            }
        }
    }
}