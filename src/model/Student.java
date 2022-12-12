package model;

public class Student extends Human {

    private String studentId;
    private String faculty;
    private String branch;

    public Student(
            String fullname,
            String studentId,
            String age,
            String gender,
            String phone,
            String faculty,
            String branch) {

        super(fullname, age, gender, phone);
        this.studentId = studentId;
        this.faculty = faculty;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return ("Fullnmae : " + this.fullname + "\n"
                + "Student ID: " + this.studentId + "\n"
                + "Age : " + this.age + "\n"
                + "Gender : " + this.gender + "\n"
                + "Phone : " + this.phone + "\n"
                + "Faculty : " + this.faculty + "\n"
                + "Branch : " + this.branch) + "\n";
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String student_id) {
        this.studentId = student_id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
