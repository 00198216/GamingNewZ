package com.example.charl.gamingnewz.Activities.Interfaces;

import com.example.charl.gamingnewz.Activities.Objects.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GamingNewZAPI {

    public static final String FINISH= "http://gamenewsuca.herokuapp.com";

    //Metodo Get
    @GET("/news")
    Call<List<News>> getNews();

    //Metodo Post
    @FormUrlEncoded
    @POST("/login")
    Call<String> login(@Field("user") String username, @Field("password") String password);
    //                 El field de usuario              El field de password       Ambos van en String.
}