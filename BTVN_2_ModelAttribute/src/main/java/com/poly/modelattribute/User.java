package com.poly.modelattribute;

public class User {
    private String userName;
    private int yearOfBirth;
    private String address;

    public User() {
    }

    public User(String userName, int yearOfBirth, String address) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
