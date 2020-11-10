package com.example.githubapi.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class repoName {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("full_name")
    @Expose
    String full_name;

    @SerializedName("private")
    @Expose
    String privat;

    @SerializedName("created_at")
    @Expose
    String created_at;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("fork")
    @Expose
    String fork;

    @SerializedName("html_url")
    @Expose
    String html_url;

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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
