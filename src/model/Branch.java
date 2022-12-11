package model;

public class Branch {

    private String nameBranch;
    private int quantity;
    private String inFaculty;

    public Branch() {
        this(" ", 0, " ");
    }

    public Branch(String nameBranch, int quantity, String inFaculty) {
        this.nameBranch = nameBranch;
        this.quantity = quantity;
        this.inFaculty = inFaculty;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInFaculty() {
        return inFaculty;
    }

    public void setInFaculty(String inFaculty) {
        this.inFaculty = inFaculty;
    }
    
    
    
    
    

}
