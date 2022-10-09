package win.academy;

import java.util.Date;

public class Student extends User{
  private Date startingDate;
  public Student(int id, String fullName, String email, String role, Date startingDate) {
    super(id, fullName, email, role);
    this.startingDate = startingDate;
  }

  public Date getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(Date startingDate) {
    this.startingDate = startingDate;
  }
}
