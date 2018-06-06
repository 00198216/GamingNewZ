package com.example.charl.gamingnewz.Activities.POJO;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable,Comparable<News> {

    private String id;  //Id de la noticia
    private int image;  //Imagen de la noticia
    private String title; //Titulo de la noticia.
    private String body; //Subtitulo de la noticia.
    private String game;      //De que juego es. ***De esto dependera a la hora de jalar las noticias para juegos individuales.
    private String created_date; //Date de la noticia en cuestion.
    private String coverImage;   //Cover Image del juego. Otra vez, Esta imagen dependerade el dato "game"
    private String createdDate; //Fecha de creacion del juego. Otra vez, Ese dato dependerade el dato "game"
    private String description; //Descripcion del juego. Otra vez, Ese dato dependerade el dato "game"


    public News() {  //Constructor vacio
    }

    //Constructor sin Check. For testing purposes.
    public News(int image, String titulo, String subtitulo) {
        this.image = image;
        this.title = titulo;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Metodo de comparacion para Comparable<News>
    @Override
    public int compareTo(@NonNull News o) {
        return 0;
    }
}
