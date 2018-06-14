package com.example.charl.gamingnewz.Activities.Room.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.charl.gamingnewz.Activities.POJO.Players;

import java.util.List;

@Dao  //La marca como DAO
public interface PlayersDAO {
    //Como podemos ver. Todos los metodos relacionados con la base. Como los Query Insert and such.

    //@Insert(onConflict = REPLACE) Forma Alternatica de usar replace visto en labo.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlayer(Players... players);

    @Query("SELECT * FROM Players_Table WHERE game like '%lol%' ")
    LiveData<List<Players>> getLolPlayers();  //Livedata permite que este objeto sea Observado.

    @Query("SELECT * FROM Players_Table WHERE game like '%overwatch%' ")
    LiveData<List<Players>> getOverPlayers();  //Livedata permite que este objeto sea Observado.

    @Query("SELECT * FROM Players_Table WHERE game like '%csgo%' ")
    LiveData<List<Players>> getCsgoPlayers();  //Livedata permite que este objeto sea Observado.
}
