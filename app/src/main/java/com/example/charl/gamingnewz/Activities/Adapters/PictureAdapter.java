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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charl.gamingnewz.Activities.Activities.MoreInfo;
import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder>{

    public ArrayList<News> news; //Creamos un arrayList de noticias
    Context Contxt;

    public static class PictureViewHolder extends RecyclerView.ViewHolder {
      CardView card;
      ImageView img;
      Context cxt;



    //Donde inicializamos los objetos
    public PictureViewHolder(View itemView){
        super(itemView);
        cxt=itemView.getContext();
        card=itemView.findViewById(R.id.CVPhoto);
        img=itemView.findViewById(R.id.imgP);

    }

}

    //Constructor
    public PictureAdapter(ArrayList<News> news,Context con) {
        this.news = news;
        Contxt= con;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_picture_card_view,parent,false);
        return (new PictureViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, final int position){


        //Cargando la imagen via Picasso
        if (!(news.get(position).getCoverImage() == null) &&
                news.get(position).getCoverImage().length() > 20) {
            Picasso.with(holder.cxt).load(news.get(position).getCoverImage()).error(R.drawable.wdd).into(holder.img);
        } else {
            Picasso.with(holder.cxt).load(R.drawable.wdd).error(R.drawable.wdd).into(holder.img);
        }

    }



    @Override
    public int getItemCount(){
        return news.size();
    }






}
