package org.example.entities;

public class Student {

    private int s_id;
    private String name;
    private String address;

    public Student() {}

    public Student(int s_id, String name, String address) {
        this.s_id = s_id;
        this.name = name;
        this.address = address;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
