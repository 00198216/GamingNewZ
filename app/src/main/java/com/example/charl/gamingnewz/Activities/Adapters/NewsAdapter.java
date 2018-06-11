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
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Activities.Login;
import com.example.charl.gamingnewz.Activities.Activities.MoreInfo;
import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public  class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
        public ArrayList<News> news; //Creamos un arrayList de noticias
         Context Contxt;

        public static class NewsViewHolder extends RecyclerView.ViewHolder {
            CardView card;
            TextView name;
            TextView Sname;
            ImageView img;
            CheckBox Cb;
            Context cxt;



            //Donde inicializamos los objetos
            public NewsViewHolder(View itemView){
                super(itemView);
                cxt=itemView.getContext();
                card=itemView.findViewById(R.id.card_view);
                name=itemView.findViewById(R.id.name);
                Sname=itemView.findViewById(R.id.Subname);
                img=itemView.findViewById(R.id.img);
                Cb= itemView.findViewById(R.id.star);

            }

        }

        //Constructor
        public NewsAdapter(ArrayList<News> news,Context con) {
            this.news = news;
            Contxt= con;
        }

        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
            return (new NewsViewHolder(v));
        }

        @Override
        public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position){

            holder.name.setText(news.get(position).getTitle());//Holder para el nombre
            holder.Sname.setText(news.get(position).getDescription()); //Holder para el subtitulo

            //Cargando la imagen via Picasso
            if (!(news.get(position).getCoverImage() == null) &&
                    news.get(position).getCoverImage().length() > 20) {
                Picasso.with(holder.cxt).load(news.get(position).getCoverImage()).error(R.drawable.wdd).into(holder.img);
            } else {
                Picasso.with(holder.cxt).load(R.drawable.wdd).error(R.drawable.wdd).into(holder.img);
            }

            //Preparamos para mandar el intent para mostrar las noticias full:

            //En la imagen:

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newIntent = new Intent(Contxt, MoreInfo.class);
                    Bundle caja = new Bundle();
                    caja.putSerializable("info",news.get(position));
                    newIntent.putExtras(caja);
                    Contxt.startActivity(newIntent);
                }
            });

            //En el titulo:

            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newIntent = new Intent(Contxt, MoreInfo.class);
                    Bundle caja = new Bundle();
                    caja.putSerializable("info", news.get(position));
                    newIntent.putExtras(caja);
                    Contxt.startActivity(newIntent);
                }
            });

            //En el body:

            holder.Sname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newIntent = new Intent(Contxt, MoreInfo.class);
                    Bundle caja = new Bundle();
                    caja.putSerializable("info",news.get(position));
                    newIntent.putExtras(caja);
                    Contxt.startActivity(newIntent);
                }
            });


        }

        public boolean validar(int estado){
            int act=1;
            boolean flag;
            int desactivado;
            if(act!=estado){
                act=1;
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public int getItemCount(){
            return news.size();
        }



    }


