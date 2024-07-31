import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Book class with attributes and constructor
class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

// Library class with linear and binary search methods
class Library {

    // Linear search to find books by title
    public Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Book middleBook = books.get(middle);
            int comparison = middleBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return middleBook;
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null; // Book not found
    }

    // Helper method to sort books by title
    public void sortBooksByTitle(List<Book> books) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
    }
}

// Main class to test the search functionality
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "Moby-Dick", "Herman Melville"));

        Library library = new Library();

        // Linear search test
        String titleToSearch = "1984";
        Book foundBook = library.linearSearchByTitle(books, titleToSearch);
        System.out.println("Linear Search Result: " + (foundBook != null ? foundBook : "Book not found"));

        // Sort books by title for binary search
        library.sortBooksByTitle(books);

        // Binary search test
        foundBook = library.binarySearchByTitle(books, titleToSearch);
        System.out.println("Binary Search Result: " + (foundBook != null ? foundBook : "Book not found"));
    }
}
