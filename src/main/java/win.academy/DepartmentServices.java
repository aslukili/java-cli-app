package win.academy;

import java.util.Scanner;

public class DepartmentServices {
  static Scanner departmentInfo = new Scanner(System.in);  // Create a Scanner object

  public static Department addDepartmentToCollegeService() {
    System.out.println("enter Department details:");
    System.out.print("department id: ");
    int departmentId = departmentInfo.nextInt();
    System.out.println("department Name: ");
    departmentInfo.nextLine();
    String departmentName = departmentInfo.nextLine();
    return new Department(departmentId, departmentName);
  }

  public static void removeDepFromCollegeService() {
    System.out.println("enter the id of which college you want to remove the department from");
    int departmentCollege = departmentInfo.nextInt(); /* @var departmentCollege is the id of college we want to add our new dep to*/
    College collegeToDeleteDepFrom = Main.colleges.stream()
      .filter(college -> college.getId() == departmentCollege)
      .findAny().orElse(null);

    assert collegeToDeleteDepFrom != null;

    System.out.println("the id of department you want to remove: ");
    int depToRemoveId = departmentInfo.nextInt();
    Department depToRemove = collegeToDeleteDepFrom.getDepartments().stream()
      .filter(department -> department.getId() == depToRemoveId)
      .findAny().orElse(null);

    collegeToDeleteDepFrom.getDepartments().remove(depToRemove);
  }

  public static void updateDepartmentService() {
    // TODO find and update a specific department
  }
}
