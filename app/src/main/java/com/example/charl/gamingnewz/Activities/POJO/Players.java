package com.example.charl.gamingnewz.Activities.POJO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "Players_Table") //El nombre que le daremos a nuestra tabla.
public class Players implements Serializable {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "_id")
    private String _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "biografia")
    private String biografia;

    @ColumnInfo(name = "avatar")
    private String avatar;

    @ColumnInfo(name = "game")
    private String game;


    public Players(){

    }

    public Players( String name, String biografia, String avatar, String game) {
        this.name = name;
        this.biografia = biografia;
        this.avatar = avatar;
        this.game = game;
    }

    @NonNull
    public String get_id() {
        return _id;
    }

    public void set_id(@NonNull String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
