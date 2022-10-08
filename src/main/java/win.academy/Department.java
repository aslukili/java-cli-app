package win.academy;

import javax.jws.Oneway;
import java.util.ArrayList;

public class Department {
  private int id;
  private String name;
  private ArrayList<Subject> subjects = new ArrayList<>();

  public Department(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(ArrayList<Subject> subjects) {
    this.subjects = subjects;
  }
}
