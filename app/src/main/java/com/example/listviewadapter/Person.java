package com.example.listviewadapter;

public class Person {
    private String name;
    private String dob;
    private String gender;
    private String imageUrl;

    public Person(String name, String dob, String gender, String imageUrl) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
