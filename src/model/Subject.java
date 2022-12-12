package model;

public class Subject {
    private int idDB;
    private String name;
    private String id;
    private String professorName;
    private String detail;
    private int quantityStudent;

    public Subject() {
        this(0, "", "", "", "", 0);
    }
    
    

    public Subject(int idDB, String name, String id, String professorName, String detail, int quantityStudent) {
        this.idDB = idDB;
        this.name = name;
        this.id = id;
        this.professorName = professorName;
        this.detail = detail;
        this.quantityStudent = quantityStudent;
    }

    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuantityStudent() {
        return quantityStudent;
    }

    public void setQuantityStudent(int quantityStudent) {
        this.quantityStudent = quantityStudent;
    }

    
    

    
    
}
