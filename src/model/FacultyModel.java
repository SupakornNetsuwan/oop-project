package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyModel {

    private Faculty Faculty;
    private ArrayList<Faculty> facultyList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private String sql;
    private String inFaculty = "";

    public FacultyModel() {
        facultyList = new ArrayList<Faculty>();
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> FacultyList) {
        this.facultyList = FacultyList;
    }

    public boolean insert(String nameFaculty) {
        sql = "INSERT INTO Faculty (nameFaculty) VALUES (?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean update(String nameFaculty,int QuantityBranch) {
        sql = "UPDATE Faculty SET QuantityBranch = ? WHERE nameFaculty = ?;";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, String.valueOf(QuantityBranch));
            statement.setString(2, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(String nameFaculty) {
        sql = "DELETE  FROM Faculty WHERE nameFaculty = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void readFaculty() {
        sql = "SELECT * FROM Faculty";
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                Faculty = new Faculty();
                Faculty.setNameFaculty(result.getString("nameFaculty"));
                facultyList.add(Faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getRecordsForTableContent() {
        readFaculty();
        Object[][] recordsForTableContent = new Object[facultyList.size()][4];

        for (int i = 0; i < facultyList.size(); i++) {
            Object[] eachFaculty = {null, facultyList.get(i).getNameFaculty(), facultyList.get(i).getQuantity(), null};
            recordsForTableContent[i] = eachFaculty;
        }
        facultyList.clear();

        return recordsForTableContent;
    }

}
