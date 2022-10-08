package win.academy;

import java.util.Scanner;

public class CollegeService {
  static Scanner collegeInfo = new Scanner(System.in);  // Create a Scanner object

  public static College addCollegeService() {

    System.out.println("enter College details:");
    System.out.print("college id: ");
    int collegeId = collegeInfo.nextInt();
    System.out.println("college Name: ");
    collegeInfo.nextLine();
    String collegeName = collegeInfo.nextLine();

    System.out.println("college added successfully!");

    return new College(collegeId, collegeName, new Address());
  }

  public static College deleteCollegeService() {
    System.out.println("enter college's id to delete");
    int collegeToDelete = collegeInfo.nextInt();
    System.out.println();

    //removing college
    return Main.colleges.stream()
      .filter(college -> college.getId() == collegeToDelete)
      .findAny().orElse(null);
  }

  public static void updateCollegeService() {
    System.out.println("enter college's id to update");
    int studentToUpdate = collegeInfo.nextInt();
    System.out.println();
    College collegeObjectToUpdate = Main.colleges.stream()
      .filter(student -> student.getId() == studentToUpdate)
      .findAny().orElse(null);

    assert collegeObjectToUpdate != null;
    System.out.println("provide a new name for this college");
    collegeInfo.nextLine();
    collegeObjectToUpdate.setName(collegeInfo.nextLine());
    System.out.println("updated successfully");
  }

}
