package model;

public class Professor extends Human {

    private String degree;

    public Professor(String professorFullName, String professorDegree, String professorGender, String professorAge, String professorPhone) {
        super(professorFullName, professorAge, professorGender, professorPhone);
        this.degree = professorDegree;
    }

    @Override
    public String toString() {
        return ("Fullnmae : " + this.fullname + "\n"
                + "Degree: " + this.degree + "\n"
                + "Age : " + this.age + "\n"
                + "Gender : " + this.gender + "\n"
                + "Phone : " + this.phone + "\n");
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
