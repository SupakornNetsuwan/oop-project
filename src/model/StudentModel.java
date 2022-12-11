package model;

import java.sql.*;

public class StudentModel {

    private Student student;
    private final Connection con = Connect.ConnectDB();
    private PreparedStatement statement = null;

    public void getStudents() {

    }

    public void getStudent() {

    }

    public boolean addStudent(String studentName, String studentId, String studentGender, String studentAge, String studentPhone) {
        String sql = "INSERT INTO student (fullname, age, gender, phone, faculty, branch, student_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, studentName);
            statement.setString(2, studentAge);
            statement.setString(3, studentGender);
            statement.setString(4, studentPhone);
            statement.setString(5, "-");
            statement.setString(6, "-");
            statement.setString(7, studentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void deleteStudent() {

    }

}
