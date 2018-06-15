package com.example.charl.gamingnewz.Activities.POJO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "News_Table") //El nombre que le daremos a nuestra tabla.
public class News implements Serializable{

    @NonNull                   // Para evitar campos nulos
    @PrimaryKey
    //(autoGenerate = true) Esto es si hubieramos querido autogenerar cada id. En este caso pues, ya vienen con las noticias
    @ColumnInfo(name = "Id") // Las Ids
    private String _id;  //Id de la noticia

    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "Title") //Titulo
    private String title;

    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "CoverImg") // La imagen de la noticia
    private String coverImage;


    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "CreatedDate") //Fecha de creacion de la noticia
    private String created_date;

    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "Description") //Descripcion de la noticia
    private String description;

    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "Body") //Cuerpo de la noticia
    private String body;

    //@NonNull Puede que este vacio y no es vital como la primary key
    @ColumnInfo(name = "Game") //Juego de la noticia
    private String game;


    public News() {  //Constructor vacio
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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


    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
