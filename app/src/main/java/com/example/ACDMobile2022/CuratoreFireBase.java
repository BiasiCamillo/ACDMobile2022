package com.example.ACDMobile2022;

public class CuratoreFireBase {
    private String nickName;
    private String email;
    private String password;
    public CuratoreFireBase(){}
    public CuratoreFireBase(String nickName, String email, String password){
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
