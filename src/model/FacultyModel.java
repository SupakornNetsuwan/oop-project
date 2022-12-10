package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyModel {

    private Faculty Faculty ;
    private ArrayList<Faculty> FacultyList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private String sql;

    public FacultyModel() {
        FacultyList = new ArrayList<Faculty>();
        readFaculty();
         
    }

    public ArrayList<Faculty> getFacultyList() {
        return FacultyList;
    }

    public void setFacultyList(ArrayList<Faculty> FacultyList) {
        this.FacultyList = FacultyList;
    }

    public boolean insert(String nameFaculty) {
        sql = "INSERT INTO Faculty (nameFaculty) VALUES (?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void readFaculty() {
        sql = "SELECT * FROM Faculty";
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                System.out.println(result.getString("nameFaculty"));
//                Faculty = new Faculty();
//                Faculty.setNameFaculty(result.getString("nameFaculty"));
//                FacultyList.add(Faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new FacultyModel();
    }
    


}
