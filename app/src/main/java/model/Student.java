package model;

public class Student {
    private String name,age,address,gender;
    private int std_id;

    public Student(String name, String age, String address, String gender, int std_id) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.std_id = std_id;
    }

    public Student(int std_id) {
        this.std_id = std_id;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
