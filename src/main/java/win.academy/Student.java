package win.academy;

public class Student extends User{
  private String startingDate;
  public Student(int id, String fullName, String email, String role, String startingDate) {
    super(id, fullName, email, role);
    this.startingDate = startingDate;
  }

  public String getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(String startingDate) {
    this.startingDate = startingDate;
  }
}
