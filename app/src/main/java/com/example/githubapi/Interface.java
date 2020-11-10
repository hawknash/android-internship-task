package com.example.githubapi;

import com.example.githubapi.para.login;
import com.example.githubapi.para.repo;
import com.example.githubapi.para.repoName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface {
    @GET("{path}")
    Call<login> getLogin(@Path("path") String path);

    @GET("{path}/repos")
    Call<List<repo>> getRepo(@Path("path") String path);

    @GET("/repos/{path}/{name}")
    Call<repoName> getRepo2(@Path("path") String path, @Path("name") String name);


}