package win.academy;

import java.util.Date;
import java.util.Scanner;

public class StudentServices {

  static Scanner studentInfo = new Scanner(System.in);  // Create a Scanner object

  public static Student addStudentService() {
      System.out.println("enter Student details:");
      System.out.print("student id: ");
      int studentId = studentInfo.nextInt();

      System.out.println("Student Full Name: ");
      studentInfo.nextLine();
      String studentName = studentInfo.nextLine();

      System.out.println("Student email address: ");
      String studentEmail = studentInfo.nextLine();



      System.out.println("Student added successfully!");

      return new Student(studentId, studentName, studentEmail, "student", new Date());
    }

  public static Student deleteStudentService() {
    System.out.println("enter student's id to delete");
    int studentToDelete = studentInfo.nextInt();
    System.out.println();

    //removing student
    return Main.students.stream()
      .filter(student -> student.getId() == studentToDelete)
      .findAny().orElse(null);
  }

  public static void attachStudentToSubjectService() {
    System.out.println("the following info are needed to add a student to a subject: student id, college id, dep id, and subject id");
    System.out.println("student id you want to attach");
    Student studentToAttach = Main.students.stream()
        .filter(student -> student.getId() == studentInfo.nextInt())
        .findAny().orElse(null);

    System.out.println("college id");
    College fatherCollege = Main.colleges.stream()
      .filter(college -> college.getId() == studentInfo.nextInt())
      .findFirst().orElse(null);

    System.out.println("dep id");
    assert fatherCollege != null;
    Department fatherDep = fatherCollege.getDepartments().stream()
      .filter(department -> department.getId() == studentInfo.nextInt())
      .findFirst().orElse(null);

    System.out.println("subject id");
    assert fatherDep != null;
    Subject subjectToAttachTo = fatherDep.getSubjects().stream()
      .filter(subject -> subject.getId() == studentInfo.nextInt())
      .findFirst().orElse(null);


    assert subjectToAttachTo != null;
    subjectToAttachTo.getStudents().add(studentToAttach);
  }
}
