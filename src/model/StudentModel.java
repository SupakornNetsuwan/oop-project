package model;

import java.sql.*;
import java.util.*;

public class StudentModel {

    private final Connection con = Connect.ConnectDB();
    private PreparedStatement statement = null;

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT * FROM student");
            ResultSet result = statement.executeQuery();

            while (result != null && result.next()) {
                Student student = new Student(
                        result.getString("fullname"),
                        result.getString("student_id"),
                        result.getString("age"),
                        result.getString("gender"),
                        result.getString("phone"),
                        result.getString("faculty"),
                        result.getString("branch")
                );

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void getStudent(String studentId) {

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

    public void deleteStudent(String studentId) {

    }
}

//    public static void main(String args[]) {
//        StudentModel studentModel = new StudentModel();
//        System.out.println(studentModel.getStudents().size());
//    }
