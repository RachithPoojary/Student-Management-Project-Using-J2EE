//
//package com.company.doa;
//
//import java.sql.*;
//
//import com.company.dao.User;
//
//
//
//public class StudentDAO {
//    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
//        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectDB", "postgres", "root");
//    }
//
//    public static int registerStudent(User user) throws SQLException, ClassNotFoundException {
//        Connection con = getConnection();
//        PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, email, phone, std, password) VALUES (?, ?, ?, ?, ?)");
//        ps.setString(1, user.getUsername());
//        ps.setString(2, user.getEmail());
//        ps.setString(3, user.getPhone());
//        ps.setString(4, user.getStd());
//        ps.setString(5, user.getPassword());
//        return ps.executeUpdate();
//    }
//
//    public static User loginStudent(String email, String password) throws SQLException, ClassNotFoundException {
//        Connection con = getConnection();
//        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
//        ps.setString(1, email);
//        ps.setString(2, password);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            User user = new User();
//            
//            user.setUsername(rs.getString("username"));
//            user.setEmail(rs.getString("email"));
//            user.setPhone(rs.getString("phone"));
//            user.setStd(rs.getString("standard"));
//            user.setPassword(rs.getString("pasword"));
//            return user;
//        }
//        return null;
//    }
//
//    public static User getStudentDetails(String email) throws SQLException, ClassNotFoundException {
//        Connection con = getConnection();
//        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
//        ps.setString(1, email);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            User user = new User();
//            
//            user.setUsername(rs.getString("username"));
//            user.setEmail(rs.getString("email"));
//            user.setPhone(rs.getString("phone"));
//            user.setStd(rs.getString("standard"));
//            user.setPassword(rs.getString("pasword"));
//            return user;
//        }
//        return null;
//    }
//
//    public static int updateStudent(User user) throws SQLException, ClassNotFoundException {
//        Connection con = getConnection();
//        PreparedStatement ps = con.prepareStatement("UPDATE users SET username = ?, phone = ? WHERE email = ?");
//        ps.setString(1, user.getUsername());
//        ps.setString(2, user.getPhone());
//        ps.setString(3, user.getEmail());
//        return ps.executeUpdate();
//    }
//
//    public static int deleteStudent(String email) throws SQLException, ClassNotFoundException {
//        Connection con = getConnection();
//        PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE email = ?");
//        ps.setString(1, email);
//        return ps.executeUpdate();
//    }
//
//	
//}
