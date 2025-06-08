# 🎓 Student Course Registration System 

This is a console-based Java application that allows administrators and students to interact with a simple student course registration system. The app uses **JDBC** for database operations and follows the **DAO Design Pattern** for clean separation of concerns.

🚀 Features
- 🧑‍🎓 Add and view students
- 📚 Add and view courses
- 📝 Register students to courses
- 👀 View all course registrations
- 🔐 Admin authentication for protected operations
- 🗃️ Uses MySQL database with JDBC connection

👩‍💼 Admin Access
- Secure login with password
- Add new students and courses
- View all students and courses
- View course registrations

👨‍🎓 User Access
- View available courses
- Register for a course using student ID
- View student’s registered courses
- 
👤🔐 **Admin Login**
- Username: Admin
- Password: admin123

📦 🛠️ Tech Stack
- **Java (Core, Collections)**
- **JDBC** (Java Database Connectivity)
- **MySQL**
- **Design Pattern:** DAO (Data Access Object)
- **IDE Support:** VS Code / IntelliJ / Eclipse

🧱 Project Structure

Student-Course-Registration-System/
├── bin/ # Compiled .class files
├── lib/
│ └── mysql-connector-j-9.3.0.jar # JDBC driver
├── src/
│ ├── dao/ # DAO classes (StudentDAO, CourseDAO, etc.)
│ ├── model/ # POJO classes (Student, Course, etc.)
│ ├── util/ # DB connection class
│ └── Main.java # Main entry point
├── sql/
│ ├── create_tables.sql # SQL to create DB tables
│ └── insert_sample_data.sql # Sample data to insert
├── run.bat # Windows batch file to compile and run
└── README.md
