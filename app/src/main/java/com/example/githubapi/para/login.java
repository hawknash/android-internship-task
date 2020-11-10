package com.example.githubapi.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class login {


    @SerializedName("login")
    @Expose
    String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
