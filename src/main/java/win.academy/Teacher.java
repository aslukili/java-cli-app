package win.academy;

public class Teacher extends User {
  private Room room;

  public Teacher(int id, String fullName, String email, String role, Room room) {
    super(id, fullName, email, role);
    this.room = room;
  }

  public Teacher() {
    super();
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }
}
