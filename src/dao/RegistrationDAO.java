package dao;

import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class RegistrationDAO {

    public void registerStudentToCourse(int studentId, int courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO registrations VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
            System.out.println("✅ Student registered to course.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("⚠️ Registration already exists.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void viewRegistrations() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                    SELECT s.name AS student_name, c.name AS course_name
                    FROM registrations r
                    JOIN students s ON r.student_id = s.id
                    JOIN courses c ON r.course_id = c.id
                    """;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("student_name") + " → " + rs.getString("course_name"));
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
