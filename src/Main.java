import dao.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        RegistrationDAO registrationDAO = new RegistrationDAO();

        while (true) {
            System.out.println("\n=== Student Course Registration System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. User Access");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Admin Password: ");
                String pass = sc.nextLine();
                if (pass.equals("admin123")) {
                    adminMenu(sc, studentDAO, courseDAO, registrationDAO);
                } else {
                    System.out.println("❌ Incorrect password.");
                }
            } else if (choice == 2) {
                userMenu(sc, studentDAO, courseDAO, registrationDAO);
            } else if (choice == 0) {
                System.out.println("✅ Exiting. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }

    static void adminMenu(Scanner sc, StudentDAO sdao, CourseDAO cdao, RegistrationDAO rdao) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. View Registrations");
            System.out.println("0. Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();
                    sdao.addStudent(new Student(sid, sname));
                    break;
                case 2:
                    sdao.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cname = sc.nextLine();
                    cdao.addCourse(new Course(cid, cname));
                    break;
                case 4:
                    cdao.viewCourses();
                    break;
                case 5:
                    rdao.viewRegistrations();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void userMenu(Scanner sc, StudentDAO sdao, CourseDAO cdao, RegistrationDAO rdao) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Students");
            System.out.println("2. View Courses");
            System.out.println("3. Register for Course");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    sdao.viewStudents();
                    break;
                case 2:
                    cdao.viewCourses();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    rdao.registerStudentToCourse(sid, cid);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

/*javac -cp "lib/mysql-connector-j-9.3.0.jar" -d bin src/model/*.java src/dao/*.java src/util/*.java src/Main.java*/
/*java -cp "bin;lib/mysql-connector-j-9.3.0.jar" Main*/