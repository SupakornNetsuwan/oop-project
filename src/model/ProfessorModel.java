package model;

import java.sql.*;
import java.util.*;

public class ProfessorModel {

    private final Connection con = Connect.ConnectDB();
    private PreparedStatement statement = null;
    private Professor professor;
    private ArrayList<Professor> professorList;
    private ResultSet result = null;
    private int QuantityBranch = 0;
    
    public ArrayList<Professor> getProfessors() {
            professorList = new ArrayList<Professor>();
        try {
            statement = con.prepareStatement("SELECT * FROM professor");
            result = statement.executeQuery();

            while (result != null && result.next()) {
                        professor = new Professor(
                        result.getString("fullname"),
                        result.getString("degree"),
                        result.getString("own_subject"),
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
                        result.getString("own_subject"),
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
            statement = con.prepareStatement("INSERT INTO professor (fullname, degree, own_subject, gender, age, phone) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, professorFullName);
            statement.setString(2, professorDegree);
            statement.setString(3, professorOwnSubject);
            statement.setString(4, professorGender);
            statement.setString(5, professorAge);
            statement.setString(6, professorPhone);
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
        String[] recordsForComboBox = new String [getProfessors().size()+1];
        recordsForComboBox[0] = "";
        for (int i = 1; i < professorList.size()+1; i++) {
            recordsForComboBox[i] = professorList.get(i-1).getFullname();
        }
        professorList.clear();
        return recordsForComboBox;
    }
}
