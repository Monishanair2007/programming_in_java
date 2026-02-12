import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Book Class
class Book {
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    public Book(String title, double price, String ISBN, String genre, String author) 
            throws InvalidBookException {

        if (price < 0) {
            throw new InvalidBookException("Price cannot be negative!");
        }

        this.title = title;
        this.price = price;
        this.ISBN = ISBN;
        this.genre = genre;
        this.author = author;
    }
}

public class ArrayListOfBooks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            // Predefined 8 books
            bookList.add(new Book("Java Basics", 499.99, "ISBN001", "Education", "John Smith"));
            bookList.add(new Book("Data Structures", 699.50, "ISBN002", "Computer Science", "Alice Brown"));
            bookList.add(new Book("Operating Systems", 850.75, "ISBN003", "Computer Science", "Andrew Tan"));
            bookList.add(new Book("Database Systems", 720.40, "ISBN004", "Technology", "Michael Lee"));
            bookList.add(new Book("Python Programming", 550.00, "ISBN005", "Education", "David Clark"));
            bookList.add(new Book("Artificial Intelligence", 999.99, "ISBN006", "Technology", "Sophia Martin"));
            bookList.add(new Book("Web Development", 650.25, "ISBN007", "Programming", "Emma Wilson"));
            bookList.add(new Book("Ek tha raja Ek Thi Raani", 100000.0, "ISBN008", "Fiction", "Proest of Pros Nemo"));

        } catch (InvalidBookException e) {
            System.out.println("Error creating book: " + e.getMessage());
            return; // stop program if book creation fails
        }

        int n = 0;

        try {
            System.out.print("How many books (1 to " + bookList.size() + ") do you want to calculate sum/average for? ");
            n = sc.nextInt();

            if (n < 1 || n > bookList.size()) {
                System.out.println("Invalid number! Using all " + bookList.size() + " books.");
                n = bookList.size();
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            n = bookList.size();
        }

        double totalPrice = 0;
        Book highest = bookList.get(0);
        Book lowest = bookList.get(0);

        System.out.println("\n===== Selected Book Details =====");

        for (int i = 0; i < n; i++) {
            Book b = bookList.get(i);

            System.out.println("Title: " + b.title);
            System.out.println("Price: " + b.price);
            System.out.println("ISBN: " + b.ISBN);
            System.out.println("Genre: " + b.genre);
            System.out.println("Author: " + b.author);
            System.out.println("----------------------------");

            totalPrice += b.price;

            if (b.price > highest.price) highest = b;
            if (b.price < lowest.price) lowest = b;
        }

        double average = totalPrice / n;

        System.out.println("\n===== Final Results =====");
        System.out.println("Total Books Considered: " + n);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Average Price: " + average);
        System.out.println("Highest Price Book: " + highest.title + " - " + highest.price);
        System.out.println("Lowest Price Book: " + lowest.title + " - " + lowest.price);

        sc.close();
    }
}
