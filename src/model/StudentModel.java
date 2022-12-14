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

    public ArrayList<Student> getStudyInBranch(String branchName) {
        ArrayList<Student> students = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT * FROM student WHERE branch = (?)");
            statement.setString(1, branchName);
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

    public Student getStudentFromFullname(String studentFullname) {
        Student student = null;

        try {
            statement = con.prepareStatement("SELECT * FROM student WHERE fullname = (?)");
            statement.setString(1, studentFullname);
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

    public boolean updateStudent(String studentId, String studentFaculty, String studentBranch) {
        try {
            statement = con.prepareStatement("UPDATE student SET faculty = (?), branch = (?) WHERE student_id = (?)");
            statement.setString(1, studentFaculty);
            statement.setString(2, studentBranch);
            statement.setString(3, studentId);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    public boolean deleteBranch(String studentID) {
        try {
            statement = con.prepareStatement("UPDATE student SET faculty = '-', branch = '-' WHERE student_id = (?)");
            statement.setString(1, studentID);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
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

        String[] studySubjectList = new String[subjectList.size()];
        for (int i = 0; i < subjectList.size(); i++) {
            studySubjectList[i] = subjectList.get(i).getName();
        }
        subjectList.clear();
        return studySubjectList;
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

    public String[] getRecordsForComboBox() {
        String[] recordsForComboBox = new String[getStudents().size() + 1];
        recordsForComboBox[0] = "";
        for (int i = 1; i < getStudents().size() + 1; i++) {
            recordsForComboBox[i] = getStudents().get(i - 1).getFullname() + " (" + getStudents().get(i - 1).getStudentId() + ")";
        }
        getStudents().clear();
        return recordsForComboBox;
    }

    public StringBuilder exportStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        // SQL query
        try {
            statement = con.prepareStatement("SELECT * FROM student");
            result = statement.executeQuery();
            stringBuilder.append("fullname");
            stringBuilder.append(",");
            stringBuilder.append("age");
            stringBuilder.append(",");
            stringBuilder.append("gender");
            stringBuilder.append(",");
            stringBuilder.append("phone");
            stringBuilder.append(",");
            stringBuilder.append("faculty");
            stringBuilder.append(",");
            stringBuilder.append("branch");
            stringBuilder.append(",");
            stringBuilder.append("student_id");
            stringBuilder.append("\r\n");
            while (result != null && result.next()) {
                stringBuilder.append(result.getString("fullname"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("age"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("gender"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("phone"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("faculty"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("branch"));
                stringBuilder.append(",");
                stringBuilder.append(result.getString("student_id"));
                stringBuilder.append("\r\n");
            }
        } catch (SQLException err) {
            System.out.println("ERR : " + err.getMessage());
        }
        return stringBuilder;
    }

}
