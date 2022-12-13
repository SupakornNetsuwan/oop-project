package model;

public class Human {

    public String fullname;
    public String age;
    public String gender;
    public String phone;

    public Human() {
        this("", "", "", "");
    }
    
    public Human(String fullname, String age, String gender, String phone) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
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

}
