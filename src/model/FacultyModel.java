package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class FacultyModel {

    private Faculty faculty;
    private ArrayList<Faculty> facultyList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private PreparedStatement statement2 = null;
    private PreparedStatement s1 = null;
    private ResultSet r1 = null;
    private PreparedStatement s2 = null;
    private ResultSet r2 = null;
    private String sql;
    private int quantityBranch = 0;

    public FacultyModel() {
        facultyList = new ArrayList<Faculty>();
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> FacultyList) {
        this.facultyList = FacultyList;
    }

    public int getQuantityBranch() {
        return quantityBranch;
    }

    public void setQuantityBranch(int QuantityBranch) {
        this.quantityBranch = QuantityBranch;
    }

    public boolean insert(String nameFaculty) {
        if (!nameFaculty.isBlank()){
        sql = "INSERT INTO faculty (name) VALUES (?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        }
        else{
            return false;
        }
    }

    public boolean delete(String nameFaculty) {
        sql = "DELETE FROM faculty WHERE name = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void selectFaculty() {
        sql = "SELECT * FROM faculty";
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                quantityBranch = 0;
                faculty = new Faculty();
                faculty.setNameFaculty(result.getString("name"));
                String sql2 = "SELECT * FROM branch WHERE in_faculty = ?";
                statement2 = con.prepareStatement(sql2);
                statement2.setString(1, result.getString("name"));
                ResultSet result2 = statement2.executeQuery();
                while (result2 != null && result2.next()) {
                    quantityBranch++;
                }
                faculty.setQuantity(quantityBranch);
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getRecordsForTableContent() {
        selectFaculty();
        Object[][] recordsForTableContent = new Object[facultyList.size()][4];
        for (int i = 0; i < facultyList.size(); i++) {
            Object[] eachFaculty = {false, facultyList.get(i).getNameFaculty(), facultyList.get(i).getQuantity(), null};
            recordsForTableContent[i] = eachFaculty;
        }
        facultyList.clear();

        return recordsForTableContent;
    }
    
    public Map<String,Map> getFacultyDataForBarchart() {
        Map<String,Map> faculties = new HashMap<>();
        ArrayList<String> eachName = new ArrayList();
        
        try {
            s1 = con.prepareStatement("SELECT * FROM faculty");
            r1 = s1.executeQuery();
            while (r1 != null && r1.next()) {
                eachName.add(r1.getString("name"));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        eachName.forEach((f) -> {
            Map<String,Integer> branches = new HashMap<>();
            try {
                s1 = con.prepareStatement("SELECT * FROM branch WHERE in_faculty = (?)");
                s1.setString(1, f);
                r1 = s1.executeQuery();
                while (r1 != null && r1.next()) {
                    String branchName = r1.getString("name");
                    try {
                        s2 = con.prepareStatement("SELECT COUNT(*) FROM student WHERE branch = (?)");
                        s2.setString(1, branchName);
                        r2 = s2.executeQuery();
                        while (r2 != null && r2.next()) {
                            int studentAmount = Integer.parseInt(r2.getString("COUNT(*)"));
                            if (studentAmount != 0) {
                                branches.put(branchName, studentAmount);
                            }
                        }
                    } catch (SQLException err) {
                        System.out.println(err.getMessage());
                    }
                }
            } catch (SQLException err) {
                System.out.println(err.getMessage());
            }
            if (!branches.isEmpty()) {
                faculties.put(f, branches);
            }
        });
        
        return faculties;
    }

}
