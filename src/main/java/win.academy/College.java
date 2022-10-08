package win.academy;

import java.util.ArrayList;

public class College {
  private int id;
  private String name;
  private Address address;
  private ArrayList<Department> departments = new ArrayList<>();
  public College(int id, String name, Address address) {
    this.id = id;
    this.name = name;
    this.address = address;
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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ArrayList<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(ArrayList<Department> departments) {
    this.departments = departments;
  }
}
