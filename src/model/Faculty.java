package model;

public class Faculty {

    private String nameFaculty;
    private int quantity;

    public Faculty() {
        this("",0);
    }
    
    
    public Faculty(String nameFaculty, int quantity) {
        this.nameFaculty = nameFaculty;
        this.quantity = quantity;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

}
