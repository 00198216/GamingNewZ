package com.example.charl.gamingnewz.Activities.Room.Room_Entities_and_Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.Room.DAOs.NewsDAO;

@Database(entities = {News.class}, version = 1)
public abstract class GamingNewZDatatbase extends RoomDatabase {

    private static GamingNewZDatatbase INSTANCE;

    public abstract NewsDAO newsDAO();

    //Singleton. Solo la instanciaremos una vez.

    public static GamingNewZDatatbase getAppDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), GamingNewZDatatbase.class, "Lucina-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
