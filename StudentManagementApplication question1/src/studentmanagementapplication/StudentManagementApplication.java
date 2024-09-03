
package studentmanagementapplication;

import java.util.ArrayList;
import java.util.Scanner;

    //Code  attribution
    //this method was adapted from stack overflow
    //https://stackoverflow.com/questions/42373289/creating-a-student-arraylist-to-add-students-to-course-class-java
    //Nayriva
    //https://stackoverflow.com/users/7530776/nayriva

class Student {
    private int id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    Student(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "STUDENT ID: " + id +
               "\nSTUDENT NAME: " + name +
               "\nSTUDENT AGE: " + age +
               "\nSTUDENT EMAIL: " + email +
               "\nSTUDENT COURSE: " + course + "\n";
    }
}

public class StudentManagementApplication {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("==============================");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
        System.out.print("Enter your choice: ");
    }

    public static int enterValidAge() {
        int age;
        while (true) {
            System.out.print("Enter the student's age: ");
            age = scanner.nextInt();
            if (age >= 16) {
                break;
            } else {
                System.out.println("You have entered an incorrect student age!!! Please re-enter the student's age.");
            }
        }
        return age;
    }

    public void addStudent(int par, String john_Doe, int par1, String johndoegmailcom, String cs) {
        System.out.print("Enter the student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the student's email: ");
        String email = scanner.nextLine();
        int age = enterValidAge();
        System.out.print("Enter the student's course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        studentList.add(student);

        System.out.println("Student details have been successfully saved!");
    }

    public void searchStudentById(int par) {
        System.out.print("Enter the student ID to search: ");
         int id = scanner.nextInt();

        Student foundStudent = new Student(id);

        for (Student student : studentList) {
            if (student.getId() == id) {
                foundStudent = student;
                break;
            }
        }
        Student student = null;

        if (foundStudent != student) {
            System.out.println("Student found: ");
            System.out.println(foundStudent);
        } else {
            System.out.println("Student with ID " + id + " was not found!");
        }
    }

    public void deleteStudent(int par) {
        System.out.print("Enter the student ID to delete: ");
        int deleteId = scanner.nextInt();

        Student foundStudent = null;

        for (Student student : studentList) {
            if (student.getId() == deleteId) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            studentList.remove(foundStudent);
            System.out.println("Student with ID " + deleteId + " was successfully deleted.");
        } else {
            System.out.println("Student with ID " + deleteId + " was not found!");
        }
    }

    public  void printStudentReport() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to display.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
                System.out.println("--------------------------------------------");
            }
        }
    }

    public void exitApplication() {
    System.out.println("Exiting application. Goodbye!");
    System.exit(0);
}


    public void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(10111, "John Doe", 18, "john.doe@gmail.com", "CS");
                    break;
                case 2:
                    searchStudentById(10111);
                    break;
                case 3:
                    deleteStudent(10111);
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid menu item.");
            }
        } while (choice != 5);

        scanner.close();
    }

}