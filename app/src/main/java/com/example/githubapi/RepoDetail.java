package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.githubapi.para.login;
import com.example.githubapi.para.repoName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoDetail extends AppCompatActivity {
    TextView name,fullname,privat,created,fork,description,url;
    String username,rname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_detail);
        Intent intent = getIntent();
        username=intent.getStringExtra("username");
        rname=intent.getStringExtra("name");

        name=findViewById(R.id.name);
        fullname=findViewById(R.id.fullname);
        privat=findViewById(R.id.privat);
        created=findViewById(R.id.created);
        fork=findViewById(R.id.fork);
        description=findViewById(R.id.description);
        url=findViewById(R.id.url);
        fetchJson();

    }

    private void fetchJson() {
        Interface call1= Clienth.getRetrofitInstance().getApi();
        Call<repoName> call=call1.getRepo2(username,rname);

        call.enqueue(new Callback<repoName>() {


            @Override
            public void onResponse(Call<repoName> call, Response<repoName> response) {
                if (response.isSuccessful() && response.body()!=null){
                    name.setText("Name: "+response.body().getName());
                    fullname.setText("Full Name: "+response.body().getFull_name());
                    privat.setText("Private: "+response.body().getPrivat());
                    created.setText("Created At: "+response.body().getCreated_at());
                    description.setText("Description: "+response.body().getDescription());
                    fork.setText("Fork: "+response.body().getFork());
                    url.setText("URL: "+response.body().getHtml_url());




                }
                else{
                    Toast.makeText(RepoDetail.this, "not found"+username+rname, Toast.LENGTH_LONG).show();

                }
            }



            @Override
            public void onFailure(Call<repoName> call, Throwable t) {
                Toast.makeText(RepoDetail.this, "not found", Toast.LENGTH_LONG).show();


            }
        });
    }


}
