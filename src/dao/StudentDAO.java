package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.executeUpdate();
            System.out.println("✅ Student added.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return students;
    }

    public void viewStudents() {
        List<Student> students = getAllStudents();
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }
}
 