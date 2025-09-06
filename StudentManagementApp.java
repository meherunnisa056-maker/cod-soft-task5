import java.util.ArrayList;
import java.util.Scanner;
// Student class
class Student {
    String name;
    int rollNumber;
    String grade;
    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}
// Student Management System
class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    // Add a student
    public void addStudent(String name, int rollNumber, String grade) {
        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully!");
    }
    // Remove a student
    public void removeStudent(int rollNumber) {
        students.removeIf(s -> s.rollNumber == rollNumber);
        System.out.println("Student removed successfully!");
    }
    // Search for a student
    public void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.rollNumber == rollNumber) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
// Main class
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = sc.next();
                    sms.addStudent(name, roll, grade);
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = sc.nextInt();
                    sms.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    sms.searchStudent(rollToSearch);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}
