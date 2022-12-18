package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentInSubjectModel {

    private SubjectModel subjectModel = new SubjectModel();
    private StudentModel studentModel = new StudentModel();
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;

    public StudentInSubjectModel() {

    }

    public boolean addStudentToSubject(String subjectId, String studentId) {
        try {

            statement = con.prepareStatement("SELECT * FROM student_in_subject WHERE (subject=(?) AND student=(?))");
            statement.setString(1, subjectId);
            statement.setString(2, studentId);
            result = statement.executeQuery();

            if (result.next()) {
                // If there's a result
                System.out.println("This student has already been inserted");
                return false;
            }

            statement = con.prepareStatement("INSERT INTO student_in_subject (subject, student) VALUES (?, ?)");
            statement.setString(1, subjectId);
            statement.setString(2, studentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println("ERR : " + err.getMessage());
        }
        return false;
    }

//    public static void main(String args[]){
//        StudentInSubjectModel studentInSubjectModel = new StudentInSubjectModel();
//        studentInSubjectModel.addStudentToSubject("7","นายศุภกร เนตรสุวรรณ");
//    }
    public boolean deleteStudentFromSubject(String subjectId, String studentId) {
        try {
            String sql = "DELETE FROM student_in_subject WHERE subject=" + subjectId + " AND student=" + studentId;
            con.createStatement().executeUpdate(sql);
            return true;
        } catch (SQLException err) {
            System.out.println("ERR : " + err.getMessage());
        }

        return false;
    }

    public ArrayList<Student> studentInSubjectList(String subjectId) {
        ArrayList<Student> studentList = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT * FROM student_in_subject JOIN subject ON student_in_subject.subject = subject.id JOIN student ON student_in_subject.student = student.student_id WHERE subject.id = (?) ");
            statement.setString(1, subjectId);
            result = statement.executeQuery();

            while (result != null && result.next()) {
                Student student = new Student(result.getString("fullname"), result.getString("student_id"), result.getString("age"), result.getString("gender"), result.getString("phone"), result.getString("faculty"), result.getString("branch"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERR : " + e.getMessage());
        }
        return studentList;
    }
}
