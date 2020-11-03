package ru.itis.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1;
    private String nickName;
    private String email;
    private String password;

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}