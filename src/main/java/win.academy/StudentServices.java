package win.academy;

public class StudentServices {
  public static Student addStudent(int studentId, String studentFullName, String studentEmail, String role){
    // TODO create new student object and add it to students list
    return new Student(studentId, studentFullName, studentEmail, role);
  }


}
