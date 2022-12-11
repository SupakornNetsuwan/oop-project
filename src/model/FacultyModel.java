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
    private PreparedStatement statement2 = null;
    private String sql;
    private String inFaculty = "";
    private int QuantityBranch = 0;

    public FacultyModel() {
        facultyList = new ArrayList<Faculty>();
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> FacultyList) {
        this.facultyList = FacultyList;
    }

    public String getInFaculty() {
        return inFaculty;
    }

    public void setInFaculty(String inFaculty) {
        this.inFaculty = inFaculty;
    }

    public int getQuantityBranch() {
        return QuantityBranch;
    }

    public void setQuantityBranch(int QuantityBranch) {
        this.QuantityBranch = QuantityBranch;
    }

    public boolean insert(String nameFaculty) {
        sql = "INSERT INTO faculty (name) VALUES (?)";
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
//    public boolean update(String nameFaculty,int QuantityBranch) {
//        sql = "UPDATE Faculty SET QuantityBranch = ? WHERE nameFaculty = ?;";
//        try {
//            statement = con.prepareStatement(sql);
//            statement.setString(1, String.valueOf(QuantityBranch));
//            statement.setString(2, nameFaculty);
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }

    public boolean delete(String nameFaculty) {
        sql = "DELETE  FROM faculty WHERE name = ?";
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
        sql = "SELECT * FROM faculty";
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                QuantityBranch = 0;
                Faculty = new Faculty();
                Faculty.setNameFaculty(result.getString("name"));
                String sql2 = "SELECT * FROM branch WHERE in_faculty = ?";
                statement2 = con.prepareStatement(sql2);
                statement2.setString(1, result.getString("name"));
                ResultSet result2 = statement2.executeQuery();
                while (result2 != null && result2.next()) {
                    QuantityBranch++;
                }
                Faculty.setQuantity(QuantityBranch);
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
