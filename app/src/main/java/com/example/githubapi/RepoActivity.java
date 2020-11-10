package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.githubapi.para.login;
import com.example.githubapi.para.repo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoActivity extends AppCompatActivity {
    public static String username;
    List<repo> repo=new ArrayList<>();
    RecyclerView recyclerView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        recyclerView=  findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RepoActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
      fetchJson(username);

    }


    private void fetchJson(final String username) {
        Interface call1 = Clienth.getRetrofitInstance().getApi();
        Call<List<repo>> call = call1.getRepo(username);
        call.enqueue(new Callback<List<repo>>() {


            @Override
            public void onResponse(Call<List<repo>> call, Response<List<repo>> response) {
                if (response.isSuccessful() && response.body() != null) {


                    repo=response.body();

                    adapter =new CustomAdapter(RepoActivity.this, repo);
                    recyclerView.setAdapter(adapter);


                } else {
                    Log.e("doooo", "doooo" + call + response.isSuccessful() + response.body());
                    Toast.makeText(RepoActivity.this, "NO "+response.body(), Toast.LENGTH_LONG).show();

                }
            }


            @Override
            public void onFailure(Call<List<repo>> call, Throwable t) {
                Toast.makeText(RepoActivity.this, "NOOOOO "+t, Toast.LENGTH_LONG).show();
                Log.e("yes", "yes" + call + " "+ t);


            }
        });

    }
}
