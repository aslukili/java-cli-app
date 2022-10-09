package win.academy;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

  // let's assume it all starts from an array of colleges
  static ArrayList<College> colleges = new ArrayList<>();
  //array list of students where all students are added
  static ArrayList<Student> students = new ArrayList<>();
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

    // mock data
//    colleges.clear();
    colleges.add(new College(1, "UAE", new Address()));
    colleges.add(new College(2, "UM6P", new Address()));
    colleges.add(new College(3, "UMI", new Address()));
    colleges.add(new College(4, "YC", new Address()));
    colleges.add(new College(5, "OTHER", new Address()));
    // deps
    colleges.get(0).getDepartments().add(new Department(1, "physics"));
    colleges.get(0).getDepartments().add(new Department(2, "maths"));
    colleges.get(0).getDepartments().add(new Department(3, "info"));
    // subjects
    colleges.get(0).getDepartments().get(0).getSubjects().add(new Subject(1, "Classical Mechanics", new Teacher()));
    colleges.get(0).getDepartments().get(0).getSubjects().add(new Subject(1, "Quantum Physics", new Teacher()));
    colleges.get(0).getDepartments().get(0).getSubjects().add(new Subject(1, "French", new Teacher()));

    //students
    students.add(new Student(1, "Abdeslam Loukili", "email@email.com", "student", new Date()));
    students.add(new Student(2, "Abdeslam Lkili", "email@email.co", "student", new Date()));
    students.add(new Student(3, "Abdeslam Li", "email@emal.com", "student", new Date()));
    students.add(new Student(4, "Abdeslam Louli", "email@eail.com", "student", new Date()));


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
        studentOperations();
        break;
      case 5:
        // TODO subjectOperations()
        subjectOperations();
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
        // TODO CollegeService.deleteCollegeService() can be replaced with AppServices.DeleteObjectService() using generics
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
        departmentOperations();
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


  private static void studentOperations() {
    System.out.println("*** students operations ***");

    System.out.println("1> add a student");
    System.out.println("2> list all students");
    System.out.println("3> delete a student");
    System.out.println("4> update a student info");
    System.out.println("5> add student to subject");
    System.out.println("or press any key to return to main menu");

    int choice =  userInput.nextInt();

    switch (choice){
      case 1:
        students.add(StudentServices.addStudentService());
        studentOperations();
        break;
      case 2:
        // we use a lambda expression instead of writing the method as a separated service
        students.forEach(student -> System.out.println("Student Id: " + student.getId() + ",  Student Name: " + student.getFullName() + ", enroll date: "
          + student.getStartingDate()
        ));
        System.out.println();
        studentOperations();
        break;
      case 3:
        // TODO StudentServices.deleteStudentService() can be replaced with AppServices.DeleteObjectService() using generics
        students.remove(StudentServices.deleteStudentService());
        System.out.println("Student deleted successfully!");
        studentOperations();
        break;
      case 4:
        // TODO  updating a record
        break;
      case 5:
        StudentServices.attachStudentToSubjectService();
        System.out.println("student added successfully!");
        // call to subjectOperations
        subjectOperations();
        studentOperations();
        break;
      default: main(null);
    }
  }

  private static void subjectOperations(){
    System.out.println("*** students operations ***");

    System.out.println("1> count of students of a subject");

    int choice =  userInput.nextInt();

    switch (choice){
      case 1:
        System.out.print("there are ");
        System.out.print(Main.colleges.get(0).getDepartments().get(0).getSubjects().get(0).getStudents().size());
        System.out.print(" enrolled in this subject");
        break;
      case 2:
        break;
      default: main(null);
    }

  }
}
