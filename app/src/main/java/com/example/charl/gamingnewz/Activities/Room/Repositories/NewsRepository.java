package com.example.charl.gamingnewz.Activities.Room.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Adapters.NewsAdapter;
import com.example.charl.gamingnewz.Activities.Interfaces.GamingNewZAPI;
import com.example.charl.gamingnewz.Activities.POJO.News;
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
    private String UsrToken;
    private Context ctx;


    public NewsRepository(Application application){ //Application es para Viewmodel.

        GamingNewZDatatbase db= GamingNewZDatatbase.getAppDataBase(application);
        newsDao = db.newsDAO();

        //Recuperando el Token
        SharedPreferences sharedPref = application.getSharedPreferences("LToken",Context.MODE_PRIVATE);
        UsrToken = sharedPref.getString("Token","");


        ConsumeNews();
        list= newsDao.getAllNews();
    }


    public LiveData<List<News>> getAllNews(){
        return  list;
    }

    public void ConsumeNews(){
        new ConsNews(UsrToken,newsDao).execute();
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

        public ConsNews(String UsrToken,NewsDAO newsDAO){
            this.UsrToken= UsrToken;
            this.newsDao= newsDAO;
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
                        Collections.reverse(newz); // Por este medio le damos vuelta a la lista de mas nuevo a mas viejo.
                        new AsyncTaskI(newsDao).execute(newz);

                    }else {
                        System.out.println("Error al cargar noticias");
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<News>> call, Throwable t) {
                    System.out.println("Error de connexion");
                }
            });
            return null;
        }
    }




}
