package studentsManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student{


   private final String Name;
   private final int Roll;
    private final String Grade;
    Student(String Name,int Roll,String Grade){
        this.Name=Name;
        this.Roll=Roll;
        this.Grade=Grade;
    }
    public String getName(){

        return Name;
    }
    public int getRoll(){
        return Roll;
    }
    public String getGrade(){
        return Grade;
    }
    public String toString() {

        return "Name: " + Name + ", Roll Number: " + Roll + ", Grade: " + Grade;
    }
}
class Management{
    private final List<Student> students;
    public Management() {

        students = new ArrayList<>();
    }
    //here I have taken student1 as a Parameter
    public void addStudent(Student student1){

        students.add(student1);
    }
    public boolean RemoveStudent(int Roll){
        for (Student student : students) {
            if (student.getRoll() == Roll) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int Roll) {
        for (Student student : students) {
            if (student.getRoll() == Roll) {
                return student;
            }
        }
        return null;
    }
    public void DisplayAllStudents(){
        for (Student student:students){
            System.out.println(student);
        }
    }
}
public class Student_Management {

    public static void main(String[] args) {
        Management sm=new Management();
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to Student Management");
        while (true){
            System.out.println("Student Management System");
            System.out.println("1 - Add a student");
            System.out.println("2 -Remove a student");
            System.out.println("3 -Search for a student");
            System.out.println("4 -Display all students");
            System.out.println("5 -Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    sc.nextLine(); // newline character
                    String Name = sc.nextLine();
                    System.out.print("Enter student roll number: ");
                    int Roll = sc.nextInt();
                    System.out.print("Enter student grade: ");
                    sc.nextLine();
                    String Grade = sc.nextLine();
                    Student st = new Student(Name, Roll, Grade);
                    sm.addStudent(st);
                    System.out.println("Student added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter roll number of the student to remove: ");
                    int removeRollNumber = sc.nextInt();
                    boolean removed = sm.RemoveStudent(removeRollNumber);
                    if (removed) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter roll number of the student to search: ");
                    int searchRollNumber = sc.nextInt();
                    Student foundStudent = sm.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> sm.DisplayAllStudents();
                case 5 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
