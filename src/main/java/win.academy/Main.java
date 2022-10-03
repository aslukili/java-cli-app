package win.academy;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  // let's assume it all starts from an array of colleges
  static ArrayList<College> colleges = new ArrayList<>();
  //array list of students where all students are added
  static ArrayList<Student> students = new ArrayList<>();
  static Scanner userInput = new Scanner(System.in);  // Create a Scanner object

  public static void main(String[] args) {
    int choice; /*for storing user choice*/


    System.out.println("Welcome! what are you doing today?");

    System.out.println("1> add a student");
    System.out.println("2> list all students");
    System.out.println("3> delete a student");
    System.out.println("4> add a college");
    System.out.println("5> managing departments");
    choice = userInput.nextInt(); // reading user choice


    switch (choice) {
      case 1:
        students.add(addStudentProcess());
        main(null);
        break;
      case 2:
        students.forEach(student -> System.out.println(student.getEmail() + student.getFullName()));
        System.out.println();
        main(null);
        break;
      case 3:
        // delete a student
        System.out.println("enter student's id to delete");
        int studentToDelete = userInput.nextInt();
//        students.remove(studentToDelete);

        System.out.println();
        Student studentObjectToDelete = students.stream()
          .filter(student -> student.getId() == studentToDelete)
          .findAny().orElse(null);
        System.out.println(studentObjectToDelete);

        students.remove(studentObjectToDelete);

//        students.remove();

        main(null);
        break;
      case 4:
        // adding a college
        System.out.println("enter college id");
        int collegeId = userInput.nextInt();
        System.out.println("enter college name");
        userInput.nextLine();
        String collegeName = userInput.nextLine();
        System.out.println("college added successfully");
        Address collegeAddress = new Address();
        colleges.add(new College(collegeId, collegeName, collegeAddress));
        System.out.println(colleges.get(0).getName());
        main(null);
    }


  }

  private static Student addStudentProcess() {
    int studentId;
    String studentFullName;
    String studentEmail;
    Department studentDepartment;
    System.out.println("Enter student's details:");
    System.out.print("student id: ");
    studentId = userInput.nextInt();
    System.out.print("student full name: ");
    userInput.nextLine();
    studentFullName = userInput.nextLine();
    System.out.print("student email: ");
    studentEmail = userInput.nextLine();
    return StudentServices.addStudent(studentId, studentFullName, studentEmail,"student");
  }
}
