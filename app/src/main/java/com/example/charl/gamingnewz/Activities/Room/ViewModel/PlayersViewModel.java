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
    private LiveData<List<Players>> list2;
    private LiveData<List<Players>> list3;

    public PlayersViewModel(@NonNull Application application){
        super(application);
        PlaRep = new PlayersRepository(application);
        list= PlaRep.getLolPlayers();
        list2= PlaRep.getOverPlayers();
        list3= PlaRep.getCsgoPlayers();
    }



    public LiveData<List<Players>> getLolPlayers(){
        return list;
    }
    public LiveData<List<Players>> getOverPlayers(){
        return list2;
    }
    public LiveData<List<Players>> getCsgoPlayers(){
        return list3;
    }

    public void GetPlayers(){
        PlaRep.GetPlayers();
    }
}
