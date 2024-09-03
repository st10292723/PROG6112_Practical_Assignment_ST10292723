
package librarymangementsystem;

import java.util.ArrayList;
import librarymangementsystem.LibraryMangementSystem.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryManagementSystemTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = null;
        library.addBook(book);
        assertEquals(book, library.searchBookByTitle("Java Programming"));
    }

    @Test
    public void testSearchBookByTitle_Found() {
        Library library = new Library();
        Book book = null;
        library.addBook(book);
        Book foundBook = (Book) library.searchBookByTitle("Java Programming");
        assertNotNull(foundBook);
    }

    @Test
    public void testSearchBookByTitle_NotFound() {
        Library library = new Library();
        Book foundBook = (Book) library.searchBookByTitle("Non-Existent Book");
        assertNull(foundBook);
    }

    @Test
    public void testSearchBooksByAuthor_Found() {
        Library library = new Library();
        Book book1 = null;
        Book book2 = null;
        library.addBook(book1);
        library.addBook(book2);
        ArrayList<Book> authorBooks = library.searchBooksByAuthor("John Doe");
        assertEquals(2, authorBooks.size());
    }

    @Test
    public void testSearchBooksByAuthor_NotFound() {
        Library library = new Library();
        ArrayList<Book> authorBooks = library.searchBooksByAuthor("Jane Doe");
        assertTrue(authorBooks.isEmpty());
    }

    private static class Library {

        public Library() {
        }

        private void addBook(Book book) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object searchBookByTitle(String java_Programming) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private ArrayList<Book> searchBooksByAuthor(String john_Doe) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
