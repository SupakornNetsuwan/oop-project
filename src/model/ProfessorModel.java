package model;

import java.sql.*;
import java.util.*;

public class ProfessorModel {

    private final Connection con = Connect.ConnectDB();
    private PreparedStatement statement = null;

    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professors = new ArrayList();

        try {
            statement = con.prepareStatement("SELECT * FROM professor");
            ResultSet result = statement.executeQuery();

            while (result != null && result.next()) {
                Professor professor = new Professor(
                        result.getString("fullname"),
                        result.getString("degree"),
                        result.getString("own_subject"),
                        result.getString("gender"),
                        result.getString("age"),
                        result.getString("phone")
                );

                professors.add(professor);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return professors;
    }

    public Professor getProfessor(String fullname) {
        Professor professor = null;

        try {
            statement = con.prepareStatement("SELECT * FROM professor WHERE fullname = (?)");
            statement.setString(1, fullname);
            ResultSet result = statement.executeQuery();
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
}
