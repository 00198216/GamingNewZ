package com.example.charl.gamingnewz.Activities.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Activities.Login;
import com.example.charl.gamingnewz.R;

import java.util.ArrayList;

public  abstract class ListGameAdapter  extends RecyclerView.Adapter<ListGameAdapter.ListGameViewHolder> {
    private ArrayList<String> news;
    public Context context;
    public Context ctx;
    SharedPreferences Game;


    public static class ListGameViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView text;
        Context ctx;



        public ListGameViewHolder(View itemView){
            super(itemView);
            card=itemView.findViewById(R.id.DrawerCV);
            text=itemView.findViewById(R.id.GameName);
            ctx= itemView.getContext();



        }

    }
    public ListGameAdapter(ArrayList<String> news, Context context) {
        this.news = news;
        this.context = context;

    }

    @Override
    public ListGameAdapter.ListGameViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_drawer_card_view,parent,false);
        return (new ListGameAdapter.ListGameViewHolder(v));
    }

    @Override
    public void onBindViewHolder(ListGameAdapter.ListGameViewHolder holder, final int position) {

        final String noticia = news.get(position);



        if(noticia==null){
            holder.text.setText("Juego");
        }else{
            holder.text.setText(noticia.toString());
        }
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Game= context.getSharedPreferences("Game", Context.MODE_PRIVATE);

                Game.edit().putString("Games",(String) noticia).apply();


                up(noticia);
            }
        });

    }
    public abstract void up (String nt);


    @Override
    public int getItemCount(){
        return news.size();
    }
}
