package com.example.demo1.model;

public class User {

    private int id;

    private String userName;

    private String password;

    private String passwordConfirm;


    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return this.id+" "+this.userName+" "+this.password;
    }

    public User(int id, String userName, String password, String passwordConfirm) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
}
