package win.academy;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  // let's assume it all starts from an array of colleges
  static ArrayList<College> colleges = new ArrayList<>();
  //array list of students where all students are added
  static Scanner userInput = new Scanner(System.in);  // Create a Scanner object

  public static void main(String[] args) {
    int choice; /*for storing user choice*/



    //  menu:

    System.out.println("Welcome to win academy");

    System.out.println("1> manage colleges");
    System.out.println("2> manage departments");
    System.out.println("3> manage teachers");
    System.out.println("4> manage students");
    System.out.println("5> manage subjects");
    System.out.println("6> manage rooms");


    choice = userInput.nextInt(); // reading user choice

    switch (choice) {
      case 1:
        collegeOperations();
        break;
      case 2:
        departmentOperations();
        break;
      case 3:
        // TODO teacherOperations();
        break;
      case 4:
        // TODO studentOperations()
        break;
      case 5:
        // TODO subjectOperations()
        break;
      case 6:
        // TODO roomOperations()
        break;
      default:
        System.out.println("invalid choice, try again!");
        main(null);
    }
  }


  private static void collegeOperations() {
    System.out.println("*** colleges' operations ***");

    System.out.println("1> add a college");
    System.out.println("2> list all colleges");
    System.out.println("3> delete a college");
    System.out.println("4> update a college info");
    System.out.println("or press any key to return to main menu");


    int choice =  userInput.nextInt();

    switch (choice){
      case 1:
        colleges.add(CollegeService.addCollegeService());
        collegeOperations();
        break;
      case 2:
        // we use a lambda expression instead of writing the method as a separated service
        colleges.forEach(college -> System.out.println("College Id: " + college.getId() + ",  College Name: " + college.getName() + ", number of deps: "
        + college.getDepartments().size()
        ));
        System.out.println();
        collegeOperations();
        break;
      case 3:
        // delete a college
        colleges.remove(CollegeService.deleteCollegeService());
        System.out.println("College deleted successfully!");
        collegeOperations();
        break;
      case 4:
        // updating a record
        CollegeService.updateCollegeService();
        collegeOperations();
        break;
      default: main(null);
    }
  }


  private static void departmentOperations() {
    System.out.println("*** departments' operations ***");

    System.out.println("1> add a new Department");
    System.out.println("2> list all departments");
    System.out.println("3> delete a department");
    System.out.println("4> update a department info");
    System.out.println("or press any key to return to main menu ");


    int choice =  userInput.nextInt();

    switch (choice){
      case 1:
        System.out.println("enter the id of which college you want to add the new department to");
        int departmentCollege = userInput.nextInt(); /* @var departmentCollege is the id of college we want to add our new dep to*/
        College collegeToAddDepTo = colleges.stream()
          .filter(college -> college.getId() == departmentCollege)
          .findAny().orElse(null);

        assert collegeToAddDepTo != null;
        collegeToAddDepTo.getDepartments().add(DepartmentServices.addDepartmentToCollegeService());
        System.out.println("department added successfully!");
        departmentOperations();
        break;
      case 2:
        // we use a lambda expression instead of writing the method as a separated service
        colleges.forEach(college -> {
          System.out.println(college.getName() + " has the following departments");
          college.getDepartments().forEach(department -> System.out.println(department.getId() + department.getName()));
          System.out.println();
        });
        System.out.println();
        collegeOperations();
        break;
      case 3:
        // delete a department
        DepartmentServices.removeDepFromCollegeService();
        System.out.println("department deleted successfully!");
        departmentOperations();
        break;
      case 4:
        // updating a record
        DepartmentServices.updateDepartmentService();
        collegeOperations();
        break;
      default: main(null);
    }
  }

}
