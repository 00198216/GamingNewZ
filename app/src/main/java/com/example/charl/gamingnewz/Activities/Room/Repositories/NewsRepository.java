package com.example.charl.gamingnewz.Activities.Room.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Activities.Login;
import com.example.charl.gamingnewz.Activities.Adapters.NewsAdapter;
import com.example.charl.gamingnewz.Activities.Interfaces.GamingNewZAPI;
import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.Activities.Room.DAOs.NewsDAO;
import com.example.charl.gamingnewz.Activities.Room.Room_Entities_and_Database.GamingNewZDatatbase;
import com.example.charl.gamingnewz.Activities.Room.Room_Entities_and_Database.NewsEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {

    private NewsDAO newsDao;  //El DAO
    private LiveData<List<News>> list;   // La lista donde recibiremos los datos
    private LiveData<List<News>> LolNews;   // La lista donde recibiremos los datos
    private LiveData<List<News>> OverNews;
    private LiveData<List<News>> CsgoNews;
    private LiveData<List<String>> Game;
    private String UsrToken;
    private Context ctx;
    private Application app;



    public NewsRepository(Application application){ //Application es para Viewmodel.

        GamingNewZDatatbase db= GamingNewZDatatbase.getAppDataBase(application);
        newsDao = db.newsDAO();

        app= application;

        //Recuperando el Token
        SharedPreferences sharedPref = application.getSharedPreferences("LToken",Context.MODE_PRIVATE);
        UsrToken = sharedPref.getString("Token","");


        ConsumeNews();
        list= newsDao.getAllNews();
        LolNews = newsDao.getLolNews();
        OverNews = newsDao.getOverNews();
        CsgoNews = newsDao.getCsgoNews();
        Game = newsDao.getGame();
    }

    public LiveData<List<News>> getLolNews() {
        return LolNews;
    }

    public LiveData<List<News>> getOverNews() {
        return OverNews;
    }

    public LiveData<List<News>> getCsgoNews() {
        return CsgoNews;
    }

    public LiveData<List<String>> getGames() {
        return Game;
    }


    public LiveData<List<News>> getAllNews(){
        return  list;
    }

    public void ConsumeNews(){
        new ConsNews(UsrToken,newsDao,app).execute();
    }

    //Subclase para Jalar la noticia de la Base
    private static class AsyncTaskI extends AsyncTask<ArrayList<News>,Void,Void>{

        private NewsDAO newsDao;

        AsyncTaskI(NewsDAO newsDao){
            this.newsDao= newsDao;
        }

        @Override
        protected Void doInBackground(ArrayList<News>... arrayLists) {
            ArrayList<News> Not = arrayLists[0]; //Nos vamos a la posicion 0
            for(int e=0; e<Not.size(); e++){
                News news = Not.get(e); //Vamos una por una
                newsDao.insertNews(news);
            }
            return null;
        }


    }

    //Subclase para Consumir la API.
    private static class ConsNews extends AsyncTask<Void,Void,Void>{

        private String UsrToken;
        private NewsDAO newsDao;
        private Application app;

        public ConsNews(String UsrToken,NewsDAO newsDAO,Application app){
            this.UsrToken= UsrToken;
            this.newsDao= newsDAO;
            this.app = app;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(GamingNewZAPI.FINISH).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
            GamingNewZAPI GNZAPI = retrofit.create(GamingNewZAPI.class);


            Call<ArrayList<News>> news = GNZAPI.getNews("Beared " + UsrToken);
            news.enqueue(new Callback<ArrayList<News>>() {


                @Override
                public void onResponse(Call<ArrayList<News>> call, Response<ArrayList<News>> response) {
                    if(response.isSuccessful()){

                        ArrayList<News> newz =(ArrayList<News>) response.body();
                        //Collections.reverse(newz); // Por este medio le damos vuelta a la lista de mas nuevo a mas viejo.
                        new AsyncTaskI(newsDao).execute(newz);

                    }else {
                        Toast.makeText(app,response.code()+""+" Token Vencido. Por favor iniciar seccion.",Toast.LENGTH_SHORT).show();
                         SharedPreferences SavedLogin = app.getSharedPreferences("LToken", Context.MODE_PRIVATE);;
                        SavedLogin.edit().clear().apply();
                        Intent intent = new Intent(app,Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        app.startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<News>> call, Throwable t) {
                    Toast.makeText(app,"Error de Conexion",Toast.LENGTH_SHORT).show();
                }
            });
            return null;
        }
    }




}
