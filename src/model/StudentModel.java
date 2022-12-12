package model;

import java.sql.*;
import java.util.*;

public class StudentModel {

    private Subject subject;
    private ArrayList<Subject> subjectList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private PreparedStatement statement2 = null;
    private String sql;

    public StudentModel() {
        subjectList = new ArrayList<Subject>();
    }
    
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT * FROM student");
            result = statement.executeQuery();

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
        } catch (SQLException err) {
            err.printStackTrace();
            System.out.println(err.getMessage());
        }

        return students;
    }

    public Student getStudent(String studentId) {
        Student student = null;

        try {
            statement = con.prepareStatement("SELECT * FROM student WHERE student_id = (?)");
            statement.setString(1, studentId);
            ResultSet result = statement.executeQuery();
            while (result != null && result.next()) {
                student = new Student(
                        result.getString("fullname"),
                        result.getString("student_id"),
                        result.getString("age"),
                        result.getString("gender"),
                        result.getString("phone"),
                        result.getString("faculty"),
                        result.getString("branch")
                );
            }
        } catch (SQLException err) {
            err.printStackTrace();
            System.out.println(err.getMessage());
        }

        return student;
    }

    public boolean addStudent(String studentName, String studentId, String studentGender, String studentAge, String studentPhone) {
        try {
            statement = con.prepareStatement("INSERT INTO student (fullname, age, gender, phone, faculty, branch, student_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, studentName);
            statement.setString(2, studentAge);
            statement.setString(3, studentGender);
            statement.setString(4, studentPhone);
            statement.setString(5, "-");
            statement.setString(6, "-");
            statement.setString(7, studentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            System.out.println(err.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(String studentId) {
        try {
            statement = con.prepareStatement("DELETE FROM student WHERE student_id = (?)");
            statement.setString(1, studentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }
    
public String[] studySubjectList(String studentId) {
        sql = "SELECT * FROM student_in_subject WHERE student = (?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, studentId);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                subject = new Subject();
                statement2 = con.prepareStatement("SELECT * FROM subject WHERE id = ?");
                statement2.setString(1, String.valueOf(result.getInt("subject")));
                ResultSet result2 = statement2.executeQuery();
                while (result2 != null && result2.next()) {
                    subject.setIdDB(result2.getInt("id"));
                    subject.setName(result2.getString("name"));
                    subject.setId(result2.getString("subject_id"));
                    subject.setProfessorName(result2.getString("professor_fullname"));
                    subject.setDetail(result2.getString("details"));            
                    subjectList.add(subject);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] studySubjectList = new String [subjectList.size()];
         for (int i = 0; i < subjectList.size(); i++) {
            studySubjectList[i] = subjectList.get(i).getName();
        }
        subjectList.clear();
        return studySubjectList;
    }
}

//    public static void main(String args[]) {
//        StudentModel studentModel = new StudentModel();
//        System.out.println(studentModel.getStudents().size());
//    }
