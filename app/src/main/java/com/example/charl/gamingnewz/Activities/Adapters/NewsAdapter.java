package com.example.charl.gamingnewz.Activities.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Objects.News;
import com.example.charl.gamingnewz.R;

import java.util.ArrayList;

public  class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
        private ArrayList<News> news;

        public static class NewsViewHolder extends RecyclerView.ViewHolder {
            CardView card;
            TextView name;
            ImageView img;
            Context cxt;




            public NewsViewHolder(View itemView){
                super(itemView);
                cxt=itemView.getContext();
                card=itemView.findViewById(R.id.card_view);
                name=itemView.findViewById(R.id.name);
                img=itemView.findViewById(R.id.img);



            }

        }

        public NewsAdapter(ArrayList<News> news) {
            this.news = news;
        }

        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
            return (new NewsViewHolder(v));
        }

        @Override
        public void onBindViewHolder(NewsViewHolder holder, final int position){
            holder.name.setText(news.get(position).getName());
            holder.img.setImageResource(news.get(position).getImg());

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


