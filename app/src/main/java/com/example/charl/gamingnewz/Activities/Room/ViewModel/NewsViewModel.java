package com.example.charl.gamingnewz.Activities.Room.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.Room.Repositories.NewsRepository;

import java.util.List;

public class NewsViewModel extends AndroidViewModel{

    private NewsRepository NwsRep;
    private LiveData<List<News>> list;
    private LiveData<List<News>> list1;
    private LiveData<List<News>> list2;
    private LiveData<List<News>> list3;


    public NewsViewModel(@NonNull Application application){
        super(application);
        NwsRep = new NewsRepository(application);
        list= NwsRep.getAllNews();
        list1= NwsRep.getLolNews();
        list2= NwsRep.getOverNews();
        list3= NwsRep.getCsgoNews();
    }

    public LiveData<List<News>> getAllNews(){
        return list;
    }

    public LiveData<List<News>> getLolNews(){
        return list1;
    }

    public LiveData<List<News>> getOverNews(){
        return list2;
    }

    public LiveData<List<News>> getCsgoNews(){
        return list3;
    }

    public void consumirNoticias(){
        NwsRep.ConsumeNews();
    }
}
