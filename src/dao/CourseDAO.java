package dao;

import model.Course;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class CourseDAO {

    public void addCourse(Course course) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO courses VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, course.getId());
            ps.setString(2, course.getName());
            ps.executeUpdate();
            System.out.println("✅ Course added.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM courses";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                courses.add(new Course(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return courses;
    }

    public void viewCourses() {
        List<Course> courses = getAllCourses();
        for (Course c : courses) {
            System.out.println(c.getId() + " - " + c.getName());
        }
    }
}
