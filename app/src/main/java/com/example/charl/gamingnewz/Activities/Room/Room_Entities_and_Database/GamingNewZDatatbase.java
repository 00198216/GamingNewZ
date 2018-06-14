package com.example.charl.gamingnewz.Activities.Room.Room_Entities_and_Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.Activities.Room.DAOs.NewsDAO;
import com.example.charl.gamingnewz.Activities.Room.DAOs.PlayersDAO;

@Database(entities = {News.class, Players.class},exportSchema = false, version = 1)
public abstract class GamingNewZDatatbase extends RoomDatabase {

    private static GamingNewZDatatbase INSTANCE;

    public abstract NewsDAO newsDAO();
    public abstract PlayersDAO playersDAO();


    //Singleton. Solo la instanciaremos una vez.

    public static GamingNewZDatatbase getAppDataBase(Context context) {
        if(INSTANCE == null) {
            synchronized (GamingNewZDatatbase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), GamingNewZDatatbase.class, "Lucina-database").build();
                }

            }
        }
        return INSTANCE;
    }
}
