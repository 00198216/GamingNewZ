package com.example.charl.gamingnewz.Activities.Interfaces;

import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class PlayerDeserializer implements JsonDeserializer<Players> {

    private Players players;

    @Override
    public Players deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        players = new Players();

        JsonObject jsonObject = json.getAsJsonObject();
        players.set_id(jsonObject.get("_id").getAsString());
        players.setName(jsonObject.get("name").getAsString());
        players.setBiografia(jsonObject.get("biografia").getAsString());
        players.setAvatar(jsonObject.get("avatar").getAsString());
        players.setGame(jsonObject.get("game").getAsString());
        return players;
    }
}
