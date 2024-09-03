
package studentmanagementapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentManagementApplicationTest {

    private StudentManagementApplication app;

    @Before
    public void setUp() {
        app = new StudentManagementApplication();
        // Add some initial students for testing
        app.addStudent(10111, "John Doe", 18, "john.doe@gmail.com", "CS");
        app.addStudent(10112, "Jane Smith", 20, "jane.smith@gmail.com", "IT");
    }

    @Test
    public void TestSaveStudent() {
        app.addStudent(10113, "Alice Johnson", 19, "alice.johnson@gmail.com", "CS");
        app.searchStudentById(10113);
        Object student = null;
        assertNotNull("Student should be added and found", student);
        assertEquals("Alice Johnson", student);
        assertEquals(19, student);
    }

    @Test
    public void TestSearchStudent() {
         app.searchStudentById(10111);
        Object student = null;
        assertNotNull("Student with ID 10111 should exist", student);
        assertEquals("John Doe", student);
    }

    @Test
    public void TestSearchStudent_StudentNotFound() {
         app.searchStudentById(99999);
        Object student = null;
        assertNull("Student with ID 99999 should not exist", student);
    }

    @Test
    public void TestDeleteStudent() {
        app.deleteStudent(10111);
        app.searchStudentById(10111);
        Object student = null;
        assertNull("Student with ID 10111 should be deleted", student);
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
       app.deleteStudent(99999);
        boolean result = false;
        assertFalse("Deleting a non-existing student should return false", result);
    }

    @Test
    public void TestStudentAge_Valid() {
        app.addStudent(10114, "Bob Williams", 17, "bob.williams@gmail.com", "DS");
        boolean result = false;
        assertTrue("Student with valid age should be added", result);
    }

    @Test
    public void TestStudentAge_Invalid() {
        app.addStudent(10115, "Invalid Age Student", 15, "invalid.age@gmail.com", "CS");
        boolean result = false;
        assertFalse("Student with invalid age should not be added", result);
    }

    @Test
    public void TestStudentAge_InvalidCharacter() {
        boolean exceptionThrown = false;
        try {
            app.addStudent(10116, "Invalid Char Student", Integer.parseInt("abc"), "invalid.char@gmail.com", "IT");
        } catch (NumberFormatException e) {
            exceptionThrown = true;
        }
        assertTrue("Invalid character for age should throw NumberFormatException", exceptionThrown);
    }
}
