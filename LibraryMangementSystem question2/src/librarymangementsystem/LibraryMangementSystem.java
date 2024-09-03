package librarymangementsystem;

import java.util.ArrayList;
import java.util.Scanner;

    //Code  attribution
    //this method was adapted from stack overflow
    //https://stackoverflow.com/questions/42373289/creating-a-student-arraylist-to-add-students-to-course-class-java
    //Nayriva
    //https://stackoverflow.com/users/7530776/nayriva

public class LibraryMangementSystem {

    public class Book {
        private String title;
        private String author;
        private int year;
        private final String ISBN;

    // Constructor
    public Book(String title, String author, String ISBN, int year) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
    }

    // Getters for accessing private fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year: " + year;
    }
    }



public class Library {
    private ArrayList<Book> books;  // Advanced array concept: Using ArrayList

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // This is a method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // This is a method to search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // If not found
    }

    // This is a Method to search for a book by author
    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    // This is a method to display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}



public class LibraryApp {
    public void main(String[] args) {
        Library library = new Library();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            do {
                // Displaying menu options
                System.out.println("\nLibrary Management System");
                System.out.println("1. Add a New Book");
                System.out.println("2. Search for a Book by Title");
                System.out.println("3. Search for Books by Author");
                System.out.println("4. Display All Books");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1:
                        // Adding a new book
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Year of Publication: ");
                        int year = scanner.nextInt();
                        Book book = new Book(title, author, isbn, year);
                        library.addBook(book);
                        break;
                    case 2:
                        // Searching for a book by title
                        System.out.print("Enter Book Title to Search: ");
                        String searchTitle = scanner.nextLine();
                        Book foundBook = library.searchBookByTitle(searchTitle);
                        if (foundBook != null) {
                            System.out.println("Book Found: " + foundBook);
                        } else {
                            System.out.println("Book with title '" + searchTitle + "' not found.");
                        }
                        break;
                    case 3:
                        // Searching for books by author
                        System.out.print("Enter Author to Search: ");
                        String searchAuthor = scanner.nextLine();
                        ArrayList<Book> authorBooks = library.searchBooksByAuthor(searchAuthor);
                        if (!authorBooks.isEmpty()) {
                            System.out.println("Books by " + searchAuthor + ":");
                            for (Book b : authorBooks) {
                                System.out.println(b);
                            }
                        } else {
                            System.out.println("No books found by author '" + searchAuthor + "'.");
                        }
                        break;
                    case 4:
                        // Displaying all books
                        library.displayAllBooks();
                        break;
                    case 5:
                        // Exiting the application
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }
}

   
    
}
