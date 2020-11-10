package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.githubapi.para.login;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=findViewById(R.id.submit);
        username=findViewById(R.id.username);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJson(username.getText().toString());
            }
        });

    }
    private void fetchJson(final String username) {
        Interface call1= Clienth.getRetrofitInstance().getApi();
        Call<login> call=call1.getLogin(username);
        call.enqueue(new Callback<login>() {


            @Override
            public void onResponse(Call<login> call, Response<login> response) {
                if (response.isSuccessful() && response.body()!=null){

                    Log.e("yes","yes"+response.body().getLogin());

                    Intent intent=new Intent(MainActivity.this,RepoActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);



                }
                else{
                    Log.e("doooo","doooo"+call+response.isSuccessful()+response.body());
                    Toast.makeText(MainActivity.this, "Username Not Found", Toast.LENGTH_LONG).show();
                }
            }



            @Override
            public void onFailure(Call<login> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Username Not Found", Toast.LENGTH_LONG).show();

            }
        });
    }
}
