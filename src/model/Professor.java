package model;

public class Professor extends Human {

    private String degree;
    private String ownSubject;

    public Professor(String professorFullName, String professorDegree, String professorOwnSubject, String professorGender, String professorAge, String professorPhone) {
        super(professorFullName, professorAge, professorGender, professorPhone);
        this.degree = professorDegree;
        this.ownSubject = professorOwnSubject;
    }

    @Override
    public String toString() {
        return ("Fullnmae : " + this.fullname + "\n"
                + "Degree: " + this.degree + "\n"
                + "Own subject : " + this.ownSubject + "\n"
                + "Age : " + this.age + "\n"
                + "Gender : " + this.gender + "\n"
                + "Phone : " + this.phone + "\n");
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOwnSubject() {
        return ownSubject;
    }

    public void setOwnSubject(String ownSubject) {
        this.ownSubject = ownSubject;
    }

}
