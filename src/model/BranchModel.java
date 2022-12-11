package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchModel {

    private Branch Branch;
    private ArrayList<Branch> BranchList;
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private String sql;
    private String inFaculty = "";
    private int quantity = 0;

    public BranchModel() {
        BranchList = new ArrayList<Branch>();
    }

    public ArrayList<Branch> getBranchList() {
        return BranchList;
    }

    public String getInFaculty() {
        return inFaculty;
    }

    public void setInFaculty(String inFaculty) {
        this.inFaculty = inFaculty;
    }
    

    public void setBranchList(ArrayList<Branch> BranchList) {
        this.BranchList = BranchList;
    }

    public boolean insert(String nameBranch, String inFaculty) {
        sql = "INSERT INTO Branch (nameBranch, inFaculty) VALUES (?, ?)";
        try {
            statement = con.prepareStatement(sql);
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
        sql = "DELETE  FROM Branch WHERE nameBranch = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, nameBranch);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void readBranch(String inFaculty) {
        sql = "SELECT * FROM Branch WHERE inFaculty = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, inFaculty);
            result = statement.executeQuery();
            while (result != null && result.next()) {
                Branch = new Branch();
                Branch.setNameBranch(result.getString("nameBranch"));
                BranchList.add(Branch);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getRecordsForTableContent() {
        readBranch(inFaculty);
        Object[][] recordsForTableContent = new Object[BranchList.size()][4];

        for (int i = 0; i < BranchList.size(); i++) {
            Object[] eachBranch = {null, BranchList.get(i).getNameBranch(), BranchList.get(i).getQuantity(), null};
            recordsForTableContent[i] = eachBranch;
        }
        BranchList.clear();

        return recordsForTableContent;
    }

}

   

