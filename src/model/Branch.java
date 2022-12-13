package model;

public class Branch {

    private String nameBranch;
    private int quantity;
    public Branch() {
        this(" ", 0);
    }

    public Branch(String nameBranch, int quantity) {
        this.nameBranch = nameBranch;
        this.quantity = quantity;
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

}
