package com.example.charl.gamingnewz.Activities.Room.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.Activities.Room.Repositories.PlayersRepository;

import java.util.List;

public class PlayersViewModel extends AndroidViewModel {

    private PlayersRepository PlaRep;
    private LiveData<List<Players>> list;

    public PlayersViewModel(@NonNull Application application){
        super(application);
        PlaRep = new PlayersRepository(application);
        list= PlaRep.getCatPlayers();
    }



    public LiveData<List<Players>> getCatPlayers(){
        return list;
    }


    public void GetPlayers(){
        PlaRep.GetPlayers();
    }
}
