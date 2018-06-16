package com.example.charl.gamingnewz.Activities.Room.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.Activities.Room.Room_Entities_and_Database.NewsEntity;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao  //La marca como DAO
public interface NewsDAO {

    //Como podemos ver. Todos los metodos relacionados con la base. Como los Query Insert and such.

    //@Insert(onConflict = REPLACE) Forma Alternatica de usar replace visto en labo.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(News... news);

    @Query("SELECT * FROM News_Table ORDER BY CreatedDate DESC")
    LiveData<List<News>> getAllNews();  //Livedata permite que este objeto sea Observado.

    @Query("SELECT DISTINCT Game FROM News_Table ")
    LiveData<List<String>> getGame();  //Livedata permite que este objeto sea Observado.

    @Query("SELECT * FROM News_Table WHERE Game = :CGame ORDER BY CreatedDate DESC")
    LiveData<List<News>> getCatNews(String CGame);  //Livedata permite que este objeto sea Observado.

}


