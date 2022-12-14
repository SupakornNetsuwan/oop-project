package model;

import java.sql.*;
import java.util.*;

public class ProfessorModel {

    private final Connection con = Connect.ConnectDB();
    private PreparedStatement statement = null;
    private Professor professor;
    private ResultSet result = null;

    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professorList = new ArrayList();

        try {
            statement = con.prepareStatement("SELECT * FROM professor");
            result = statement.executeQuery();

            while (result != null && result.next()) {
                professor = new Professor(
                        result.getString("fullname"),
                        result.getString("degree"),
                        result.getString("gender"),
                        result.getString("age"),
                        result.getString("phone")
                );

                professorList.add(professor);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return professorList;
    }

    public Professor getProfessor(String fullname) {
        Professor professor = null;

        try {
            statement = con.prepareStatement("SELECT * FROM professor WHERE fullname = (?)");
            statement.setString(1, fullname);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                professor = new Professor(
                        result.getString("fullname"),
                        result.getString("degree"),
                        result.getString("gender"),
                        result.getString("age"),
                        result.getString("phone")
                );
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return professor;
    }

    public boolean addProfessor(String professorFullName, String professorDegree, String professorOwnSubject, String professorGender, String professorAge, String professorPhone) {
        try {
            statement = con.prepareStatement("INSERT INTO professor (fullname, degree,  gender, age, phone) VALUES (?, ?, ?,  ?, ?)");
            statement.setString(1, professorFullName);
            statement.setString(2, professorDegree);
            statement.setString(3, professorGender);
            statement.setString(4, professorAge);
            statement.setString(5, professorPhone);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    public boolean deleteProfessor(String professorFullname) {
        try {
            statement = con.prepareStatement("DELETE FROM professor WHERE fullname = (?)");
            statement.setString(1, professorFullname);
            statement.executeUpdate();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    public String[] getRecordsForComboBox() {
        ArrayList<Professor> professorList = this.getProfessors();
        String[] recordsForComboBox = new String[getProfessors().size() + 1];
        recordsForComboBox[0] = "";
        for (int i = 1; i < professorList.size() + 1; i++) {
            recordsForComboBox[i] = professorList.get(i - 1).getFullname();
        }
        professorList.clear();
        return recordsForComboBox;
    }

    public ArrayList<String> getSubjetList(String professorFullname) {
        ArrayList<String> subjectName = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT * FROM subject WHERE professor_fullname = (?)");
            statement.setString(1, professorFullname);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                subjectName.add(result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERR : " + e.getMessage());
        }
        return subjectName;
    }
}
