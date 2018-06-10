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

    public NewsViewModel(@NonNull Application application){
        super(application);
        NwsRep = new NewsRepository(application);
        list= NwsRep.getAllNews();
    }

    public LiveData<List<News>> getAllNews(){
        return list;
    }

    public void consumirNoticias(){
        NwsRep.ConsumeNews();
    }
}
