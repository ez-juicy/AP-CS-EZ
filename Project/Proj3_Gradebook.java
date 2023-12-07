import java.util.*;
import java.io.*;


public class Proj3_Gradebook {
  

  static String [] names = {"Zorawar", "Justin", "Alex", "David"};
  static String [] categories = {"HW", "Quiz", "Test", "Final"};
  static double [] weights = {.3, .15, .25, .3};
  static String [] labels = {"HW 1", "HW 2", "HW 3", "HW 4", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", 
                      		 "Test 1", "Test 2", "Test 3", "Test 4", "Final"};
  static double [][] grades = {{90, 91, 80, 77, 78, 89, 87, 81, 92, 81, 80, 91, 81},
                               {83, 73, 79, 93, 73, 81, 76, 87, 90, 88, 76, 96, 95},
                               {77, 93, 83, 88, 83, 89, 74, 82, 77, 79, 86, 92, 76},
                               {79, 91, 93, 78, 84, 92, 82, 84, 86, 79, 87, 72, 74}};
  
  static double [] overallGrade;
  
  public static void main(String[] args) {
    
    Course course = new Course("Java Programming", "CS50");
    
    Teacher teacher = new Teacher("Daniel", "cui", course);
    
    // Add some initial students
    course.addStudent(new Student("Zorawar", "Mundi", course));
    course.addStudent(new Student("Justin", "hao", course));
    course.addStudent(new Student("Alex", "Bai", course));
    course.addStudent(new Student("David", "le", course));

    Scanner scanner = new Scanner(System.in);
    String userName;
    String password;
    User currentUser = null;
    
    // Login loo
    while (true) {
      System.out.println("Enter username (or type 'exit' to quit): ");
      userName = scanner.nextLine();
      if (userName.equalsIgnoreCase("exit")) {
        System.out.println("Goodbye!");
        break;
      }
      
      System.out.println("Enter password: ");
      password = scanner.nextLine();
      
      if (teacher.authenticate(userName, password)) {
        currentUser = teacher;
        break;
      } else {
        Student student = course.findStudent(userName);
        if (student != null && student.authenticate(userName, password)) {
          currentUser = student;
          break;
        } else {
          System.out.println("Invalid login. Try again.");
        }
      }
    }
    
    System.out.println("Welcome to gradebook.");
    /*System.out.println("Here are everyone's grades:");
    
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + ": ");
      System.out.println(Arrays.toString(grades[i]));
    }*/

        // User interaction loop
    while (currentUser != null) {
      currentUser.displayAction();
      System.out.println("Enter your choice: ");
      String choice = scanner.nextLine();
      
      switch (choice) {
        case "1":
          if (currentUser instanceof Teacher) {
            ((Teacher) currentUser).viewAllStudentsGrades();
          } else if (currentUser instanceof Student) {
            ((Student) currentUser).viewAllGrades();
          }
          break;
        case "2":
        if (currentUser instanceof Teacher) {
            ((Teacher) currentUser).viewAllStudentsGradesByCategory();
        } else if (currentUser instanceof Student) {
          ((Student) currentUser). viewGradesByCategory();
        }
        break;
    case "3":
        if (currentUser instanceof Teacher) {
            ((Teacher) currentUser).viewAllStudentsOverallGrades();
        } else if (currentUser instanceof Student) {
          ((Student) currentUser).viewOverallGrade();
        }
        break;
    case "4":
        System.out.println("Exiting...");
        currentUser = null;
        break;
    default:
        System.out.println("Invalid choice. Try again.");
}

        }

        scanner.close();
    }

}



class Teacher extends User {

  private Course course;
  private Scanner scanner = new Scanner(System.in);

  Teacher(String userName, String password, Course course) {
    super(userName, password, course);
    this.course = course;
    course.setTeacher(this); // Set the teacher for the course
  }

  public void displayAction() {
    System.out.println("1. View all students' grades");
    System.out.println("2. View all students' grades by category");
        System.out.println("3. View all students' overall grades");
        System.out.println("4. View grades of a single student");
        System.out.println("5. View grades by category for a single student");
        System.out.println("6. Add assignment category");
        System.out.println("7. Change category weights");
        System.out.println("8. Add a student to the course");
        System.out.println("9. Drop a student from the course");
        System.out.println("10. Add a new assignment to the course");
        System.out.println("11. Add a new assignment to a specific student");
        System.out.println("12. Exit");
    }

    public void performAction(String action) {
    switch (action.toLowerCase()) {
        case "1":
            viewAllStudentsGrades();
            break;
        case "2":
            viewAllStudentsGradesByCategory();
            break;
        case "3":
            viewAllStudentsOverallGrades();
            break;
        case "4":
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            viewSingleStudentGrades(studentName);
            break;
        case "5":
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();
            viewSingleStudentGradesByCategory(studentName);
            break;
        case "6":
            addAssignmentCategory();
            break;
        case "7":
            changeCategoryWeights();
            break;
        case "8":
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();
            System.out.print("Enter student password: ");
            String studentPassword = scanner.nextLine();
            addStudentToCourse(studentName, studentPassword);
            break;
        case "9":
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();
            dropStudentFromCourse(studentName);
            break;
        case "10":
            System.out.print("Enter assignment name: ");
            String assignmentName = scanner.nextLine();
            System.out.print("Enter assignment grade: ");
            double assignmentGrade = scanner.nextDouble();
            addNewAssignmentToCourse(assignmentName, assignmentGrade);
            break;
        case "11":
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();
            System.out.print("Enter assignment name: ");
            assignmentName = scanner.nextLine();
            System.out.print("Enter assignment grade: ");
            assignmentGrade = scanner.nextDouble();
            addNewAssignmentToStudent(studentName, assignmentName, assignmentGrade);
            break;
        case "12":
            System.out.println("Exiting...");
            System.exit(0);
        default:
            System.out.println("Invalid action. Try again.");
    }
}

     public void viewAllStudentsGrades() {
        ArrayList<Student> students = course.getStudents();
        for (Student student : students) {
            System.out.println("Student: " + student.getName() + ", Grades: " + student.getGrades());
        }
    }

    public void viewAllStudentsGradesByCategory() {
        ArrayList<Student> students = course.getStudents();
        ArrayList<String> categories = course.getCategories();

        for (String category : categories) {
            System.out.println("Category: " + category);
            for (Student student : students) {
                System.out.println("Student: " + student.getName() + ", " + category + ": " +
                        student.getGrades().get(course.getLabels().indexOf(category)));
            }
        }
    }

    public void viewAllStudentsOverallGrades() {
        ArrayList<Student> students = course.getStudents();
        for (Student student : students) {
            System.out.println("Student: " + student.getName() + ", Overall Grade: " + student.getOverallGrade());
        }
    }

    public void viewSingleStudentGrades(String studentName) {
        Student student = course.findStudent(studentName);
        if (student != null) {
            System.out.println("Student: " + student.getName() + ", Grades: " + student.getGrades());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewSingleStudentGradesByCategory(String studentName) {
        Student student = course.findStudent(studentName);
        if (student != null) {
            ArrayList<String> categories = course.getCategories();
            for (String category : categories) {
                System.out.println("Category: " + category);
                System.out.println("Student: " + student.getName() + ", " + category + ": " +
                        student.getGrades().get(course.getLabels().indexOf(category)));
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public void addAssignmentCategory() {
        System.out.println("Enter new assignment category name:");
        String category = scanner.nextLine();
        System.out.println("Enter category weight:");
        double weight = scanner.nextDouble();
        course.addCategory(category, weight);
        System.out.println("Assignment category added successfully.");
    }

    public void changeCategoryWeights() {
        course.changeWeights();
    }

    public void addStudentToCourse(String studentName, String studentPassword) {
        course.addStudent(new Student(studentName, studentPassword, course));
        System.out.println("Student added to the course.");
    }

    public void dropStudentFromCourse(String studentName) {
        Student student = course.findStudent(studentName);
        if (student != null) {
            course.dropStudent(student);
            System.out.println("Student dropped from the course.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void addNewAssignmentToCourse(String assignmentName, double grade) {
        course.addAssignment(assignmentName, grade);
        System.out.println("New assignment added to the course.");
    }

    public void addNewAssignmentToStudent(String studentName, String assignmentName, double grade) {
        Student student = course.findStudent(studentName);
        if (student != null) {
            student.addGrade(grade);
            System.out.println("New assignment added to the student.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public boolean authenticate(String userName, String password) {
    return validateLogin(password);
}
}

class Student extends User {

    private String name;
    private String password;
    private Course course;
    private double overallGrade;
    private String assignmentName;
    private double grade;
    private ArrayList<Student> students;
    public Scanner s = new Scanner(System.in);
    public ArrayList<String> assignmentLabels;
    public ArrayList<Double> assignmentGrades;

    Student(String userName, String password, Course course) {
    super(userName, password, course);
    this.name = userName; // Set the name field to the provided userName
    course.addStudent(this);
    }


   public void performAction(String action) {
    switch (action.toLowerCase()) {
        case "1":
            viewAllGrades();
            break;
        case "2":
            viewGradesByCategory();
            break;
        case "3":
            viewOverallGrade();
            break;
        case "4":
            System.out.println("Exiting...");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid action. Try again.");
    }
    
}


    public void viewAllGrades() {
        System.out.println("All Grades:");
        for (int i = 0; i < assignmentLabels.size(); i++) {
            System.out.println(assignmentLabels.get(i) + ": " + assignmentGrades.get(i));
        }
    }

    public void viewGradesByCategory() {

        System.out.println("Available Categories:");
        for (String category : course.getCategories()) {
            System.out.println(category);
        }

        System.out.print("Enter the category to view grades: ");

        String selectedCategory = s.next();

        System.out.println("Grades for Category '" + selectedCategory + "':");

        for (int i = 0; i < assignmentLabels.size(); i++) {
            if (course.getLabels().get(i).contains(selectedCategory)) {
                System.out.println(assignmentLabels.get(i) + ": " + assignmentGrades.get(i));
            }
        }
    }

    public void viewOverallGrade() {
        updateOverallGrade();
        System.out.println("The Overall Grade is  " + overallGrade);
    }

    public void displayAction() {
        System.out.println(" 1. View all Grade");
        System.out.println("2. View Grade by category");
        System.out.println("3. View Overall Grade");
        System.out.println("4. Exit");
    }

    public String getName() {
    return this.name;

    }


    public double getOverallGrade() {
        return overallGrade;
    }

      public void addGrade(double grade) {
        assignmentGrades.add(grade);
    }

    public ArrayList<Double> updateOverallGrade() {
        ArrayList<Double> overall = new ArrayList<Double>();

        for (Student student : students) {
            double[] categoryAvg = new double[course.getCategories().size()];
            for (int j = 0; j < course.getCategories().size(); j++) {
                int count = 0;
                int sum = 0;
                for (int k = 0; k < course.getLabels().size(); k++) {
                    if (course.getLabels().get(k).contains(course.getCategories().get(j))) {
                        sum += course.getGrades().get(k);
                        count++;
                    }
                }
                categoryAvg[j] = (double) (sum / count);
            }

            double weightedGrade = 0;
            for (int j = 0; j < categoryAvg.length; j++)
                weightedGrade += categoryAvg[j] * course.getWeights().get(j);
            overall.add(weightedGrade);
        }
        return overall;
    }
    public ArrayList<Double> getGrades() {
    return assignmentGrades;
}

public Student findStudent(String studentName) {
    for (Student student : students) {
        if (student.getName().equals(studentName)) {
            return student;
        }
    }
    return null;
}

public boolean authenticate(String userName, String password) {
    return validateLogin(password);
}

}

class Course {
   public String courseName;
    public String courseID;
    private ArrayList<Student> students;
    private ArrayList<String> categories;
    private ArrayList<Double> weights;
    private ArrayList<String> labels;
    private Teacher teacher;
    private ArrayList<Double> studentGrades;
    public Scanner s = new Scanner(System.in);

    public Course(String courseName, String courseID) {
      this.courseName = courseName;
      this.courseID = courseID;
        students = new ArrayList<>();
        categories = new ArrayList<>();
        weights = new ArrayList<>();
        labels = new ArrayList<>();
        studentGrades = new ArrayList<>();
    }

    public void addStudent(Student student) {
    students.add(student);
}

    public void dropStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addAssignment(String assignmentName, double grade) {
        labels.add(assignmentName);
        for (Student student : students) {
            student.addGrade(grade); // check the student class
        }
    }

    public void addGrade(double grade) {
        studentGrades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return studentGrades;
    }

    public void addCategory(String categoryName, double weight) {
        categories.add(categoryName);
        weights.add(weight);
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

   public void changeWeights() {
    System.out.println("You are going to change the weights of each category.");
    while (true) {
        double[] tempWeights = new double[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            System.out.println("What is the new weight for category " + categories.get(i) + "?");
            tempWeights[i] = s.nextDouble();
        }
        s.nextLine();
        double sum = 0;
        for (double w : tempWeights) sum += w;
        if ((double) Math.round(sum * 100000d) / 100000d == 1) {
            for (int i = 0; i < tempWeights.length; i++) weights.set(i, tempWeights[i]);
            break;
        }
        System.out.println("Your weights do not add up to 1. Please re-enter valid weights.");
    }

    System.out.println("Weights have been updated.");
}


public Student findStudent(String studentName) {
    for (Student student : students) {
        if (student.getName().equals(studentName)) {
            return student;
        }
    }
    return null;
}


}

// admin or student - abstract
abstract class User {

    private String userName;
    private String password;
    private Course course;

    User(String userName, String password, Course course) {
        this.userName = userName;
        this.password = password;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public boolean validateLogin(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse(Course course) {
        return course;
    }

    public abstract void performAction(String action);

    public abstract void displayAction();

}
