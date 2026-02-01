import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    String rollNo;   // Roll number can be alphanumeric
    String name;
    int marks;

    Student(String rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

// Main class
public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number from 1 to 4.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add new student
    static void addStudent() {
        sc.nextLine(); // clear buffer

        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks;
        try {
            marks = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid marks! Please enter a number.");
            sc.nextLine(); // clear invalid input
            return;
        }

        students.add(new Student(roll, name, marks));
        System.out.println("Student added successfully!");
    }

    // View all students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\nRoll No\tName\tMarks");
        for (Student s : students) {
            System.out.println(s.rollNo + "\t" + s.name + "\t" + s.marks);
        }
    }

    // Search student by roll number
    static void searchStudent() {
        sc.nextLine(); // clear buffer

        System.out.print("Enter Roll No to search: ");
        String roll = sc.nextLine();

        for (Student s : students) {
            if (s.rollNo.equals(roll)) {
                System.out.println("Student Found:");
                System.out.println("Roll No: " + s.rollNo);
                System.out.println("Name: " + s.name);
                System.out.println("Marks: " + s.marks);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
