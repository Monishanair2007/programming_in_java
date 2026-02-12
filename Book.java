public class Book {
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    // Default Constructor
    public Book() {
        title = "Ek tha raja Ek Thi Raani";
        price = 100000.0;
        ISBN = "ABCD";
        genre = "Fiction";
        author = "Proest of Pros Nemo";
    }

    // Parameterized Constructor with validation using custom exception
    public Book(String title, double price, String ISBN, String genre, String author) throws InvalidBookException {
        if (price < 0) {
            throw new InvalidBookException("Price cannot be negative!");
        }
        

        this.title = title;
        this.price = price;
        this.ISBN = ISBN;
        this.genre = genre;
        this.author = author;
    }

    // Copy Constructor
    public Book(Book other) {
        this.title = other.title;
        this.price = other.price;
        this.ISBN = other.ISBN;
        this.genre = other.genre;
        this.author = other.author;
    }
}
