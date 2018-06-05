package com.example.charl.gamingnewz.Activities.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//Pojo asociado con todo acerca del usuario.
//Esto incluye noticias favoritas su contraseña y el token de login.

public class Users {

    @SerializedName("_id")
    private String id; //Identification del  usuario

    @SerializedName("created_date")
    private String date; //La fecha

    @SerializedName("__v")
    private int version; // Version

    @SerializedName("favoriteNews")
    private List<News> favouriteNews; //Lista de Noticias Favoritas de cada usuario.

    //Otros campos del Usuario a utilizar.

    private String Token; //Token unico que confirma el Login
    private String user; //Username
    private String password; //Contraseña.

    //Constructor

    public Users(String user, String password){
        this.user = user;
        this.password = password;
    }

    //Setters and Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<News> getFavouriteNews() {
        return favouriteNews;
    }

    public void setFavouriteNews(List<News> favouriteNews) {
        this.favouriteNews = favouriteNews;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
