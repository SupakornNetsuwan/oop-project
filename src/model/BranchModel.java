package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchModel {

    private Branch branch;
    private ArrayList<Branch> branchList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private PreparedStatement statement2 = null;
    private String inFaculty = "";
    private int quantityStudent = 0;

    public BranchModel() {
        branchList = new ArrayList<Branch>();
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public String getInFaculty() {
        return inFaculty;
    }

    public void setInFaculty(String inFaculty) {
        this.inFaculty = inFaculty;
    }
    

    public void setBranchList(ArrayList<Branch> BranchList) {
        this.branchList = BranchList;
    }

    public boolean insert(String nameBranch, String inFaculty) {
        try {
            statement = con.prepareStatement("INSERT INTO branch (name, in_faculty) VALUES (?, ?)");
            statement.setString(1, nameBranch);
            statement.setString(2, inFaculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(String nameBranch) {
        try {
            statement = con.prepareStatement("DELETE  FROM branch WHERE name = ?");
            statement.setString(1, nameBranch);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean deleteAllInFaculty(String in_faculty) {
        try {
            statement = con.prepareStatement("DELETE  FROM branch WHERE in_faculty = ?");
            statement.setString(1, in_faculty);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void readBranch(String inFaculty) {
        try {
            statement = con.prepareStatement("SELECT * FROM branch WHERE in_faculty = ?");
            statement.setString(1, inFaculty);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                quantityStudent = 0;
                branch = new Branch();
                branch.setNameBranch(result.getString("name"));
                statement2 = con.prepareStatement("SELECT * FROM student WHERE branch = ?");
                statement2.setString(1, result.getString("name"));
                ResultSet result2 = statement2.executeQuery();
                while (result2 != null && result2.next()) {
                    quantityStudent++;
                }
                branch.setQuantity(quantityStudent);
                branchList.add(branch);
            
            }
        } catch (SQLException e) {
//            e.printStackTrace();
             System.out.println(e.getMessage());
        }
            }

    public Object[][] getRecordsForTableContent() {
        readBranch(inFaculty);
        Object[][] recordsForTableContent = new Object[branchList.size()][4];

        for (int i = 0; i < branchList.size(); i++) {
            Object[] eachBranch = {false, branchList.get(i).getNameBranch(), branchList.get(i).getQuantity(), null};
            recordsForTableContent[i] = eachBranch;
        }
        branchList.clear();

        return recordsForTableContent;
    }

}

   

