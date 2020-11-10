package com.example.githubapi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubapi.para.repo;

import java.util.List;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    List<repo> cases;
    CustomAdapter(Context context, List<repo> cases){
        this.context=  context;

        this.cases=cases;
        Log.e("cases","cases "+cases);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.repo,parent,false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter.ViewHolder holder, int position) {
        final repo repos=cases.get(position);

        holder.name.setText("Name: "+repos.getName());
        holder.fullname.setText("Full Name: "+repos.getFull_name());
        holder.privat.setText("Private: "+repos.getPrivat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,RepoDetail.class);
                intent.putExtra("name",repos.getName());
                intent.putExtra("username",RepoActivity.username);


                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {


        return cases.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView name,fullname,privat;


        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            fullname=itemView.findViewById(R.id.fullname);
            privat=itemView.findViewById(R.id.privat);

        }

        @Override
        public void onClick(View v) {


        }
    }

}

