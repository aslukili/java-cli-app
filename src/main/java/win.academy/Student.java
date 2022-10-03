package win.academy;

public class Student extends User{
  private Department department;

  public Student(int id, String fullName, String email, String role) {
    super(id, fullName, email, role);
  }
}
