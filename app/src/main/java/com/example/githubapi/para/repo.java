package com.example.githubapi.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class repo {
    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("full_name")
    @Expose
    String full_name;

    @SerializedName("private")
    @Expose
    String privat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPrivat() {
        return privat;
    }

    public void setPrivat(String privat) {
        this.privat = privat;
    }
}
