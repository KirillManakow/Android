package com.example.myapplication;

public class User_Model {
    private String email;
    private String password;

    public User_Model(String email,String password)
    {
        this.email=email;
        this.password=password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
