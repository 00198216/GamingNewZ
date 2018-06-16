package com.example.charl.gamingnewz.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charl.gamingnewz.Activities.Activities.MoreInfo;
import com.example.charl.gamingnewz.Activities.Activities.MoreInfoPlayers;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JugadoresAdapter extends RecyclerView.Adapter<JugadoresAdapter.JugadoresViewHolder> {
    public ArrayList<Players> players; //Creamos un arrayList de noticias
    Context Contxt;

    public static class JugadoresViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        TextView Sname;
        ImageView img;
        Context cxt;


        //Donde inicializamos los objetos
        public JugadoresViewHolder(View itemView) {
            super(itemView);
            cxt = itemView.getContext();
            card = itemView.findViewById(R.id.CVP);
            name = itemView.findViewById(R.id.PNC);
            Sname = itemView.findViewById(R.id.PBC);
            img = itemView.findViewById(R.id.imgPlayer);

        }

    }

    //Constructor
    public JugadoresAdapter(ArrayList<Players> players, Context con) {
        this.players = players;
        Contxt = con;
    }

    @NonNull
    @Override
    public JugadoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_player_card_view, parent, false);
        return (new JugadoresAdapter.JugadoresViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull JugadoresViewHolder holder, final int position) {
        holder.name.setText(players.get(position).getName());//Holder para el nombre
        holder.Sname.setText(players.get(position).getBiografia()); //Holder para el subtitulo

        //Cargando la imagen via Picasso
        if (!(players.get(position).getAvatar() == null) &&
                players.get(position).getAvatar().length() > 20) {
            Picasso.with(holder.cxt).load(players.get(position).getAvatar()).error(R.drawable.wdd).into(holder.img);
        } else {
            Picasso.with(holder.cxt).load(R.drawable.wdd).error(R.drawable.wdd).into(holder.img);
        }


        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(Contxt,MoreInfoPlayers.class);
                Bundle caja = new Bundle();
                caja.putSerializable("info2",players.get(position));
                newIntent.putExtras(caja);
                Contxt.startActivity(newIntent);
            }
        });

        //En el titulo:

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(Contxt, MoreInfoPlayers.class);
                Bundle caja = new Bundle();
                caja.putSerializable("info2", players.get(position));
                newIntent.putExtras(caja);
                Contxt.startActivity(newIntent);
            }
        });

        //En el body:

        holder.Sname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(Contxt, MoreInfoPlayers.class);
                Bundle caja = new Bundle();
                caja.putSerializable("info2",players.get(position));
                newIntent.putExtras(caja);
                Contxt.startActivity(newIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return players.size();
    }

}


