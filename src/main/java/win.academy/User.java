package win.academy;

public abstract class User {
  private int id;
  private String fullName;
  private String email;
  private String role; /*we add role as a string instead of creating a class for role*/
  private boolean isActive;

  public User(int id, String fullName, String email, String role) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.role = role;
  }

  public User(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
