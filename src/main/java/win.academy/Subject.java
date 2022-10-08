package win.academy;

import java.util.ArrayList;

public class Subject {
  private int id;
  private String name;
  private Teacher teacher;
  private ArrayList<Student> students = new ArrayList<>();

  public Subject(int id, String name, Teacher teacher) {
    this.id = id;
    this.name = name;
    this.teacher = teacher;
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

  public ArrayList<Student> getStudents() {
    return students;
  }

  public void setStudents(ArrayList<Student> students) {
    this.students = students;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
}
