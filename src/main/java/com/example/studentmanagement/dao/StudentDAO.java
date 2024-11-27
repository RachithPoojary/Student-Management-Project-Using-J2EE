package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.Student;
import java.sql.*;

public class StudentDAO {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectDB", "postgres", "root");
    }

    public static int registerStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, email, phone, standard, password) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, student.getUsername());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getPhone());
        ps.setString(4, student.getStandard());
        ps.setString(5, student.getPassword());
        return ps.executeUpdate();
    }

    public static Student loginStudent(String email, String password) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            student.setStandard(rs.getString("standard"));
            return student;
        }
        return null;
    }

    public static Student getStudentDetails(String email) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            student.setStandard(rs.getString("standard"));
            return student;
        }
        return null;
    }

    public static int updateStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE users SET username = ?, phone = ? WHERE email = ?");
        ps.setString(1, student.getUsername());
        ps.setString(2, student.getPhone());
        ps.setString(3, student.getEmail());
        return ps.executeUpdate();
    }

    public static int deleteStudent(String email) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE email = ?");
        ps.setString(1, email);
        return ps.executeUpdate();
    }
}
