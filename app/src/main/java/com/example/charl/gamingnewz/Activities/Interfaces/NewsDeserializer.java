package com.example.charl.gamingnewz.Activities.Interfaces;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

//Se encarga de pasar a Json a formato deseado. En este caso lo queremos pasar a un Objeto News.
public class NewsDeserializer implements JsonDeserializer<News> {

    private News Gnews; // Creamos un objeto tipo news donde la informacion sera cargada.
    @Override
    public News deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
       Gnews = new News(); //Inicializamos las noticias.

        //System.out.println(json.getAsJsonObject()); // Debido a ser tantos datos. No es recomendable imprimirlos todos.

        JsonObject jsonObject = json.getAsJsonObject(); //Crea un objeto tipo Json Object

        //Proseguimos a cargar Gnews con la informacion por cada campo.

        Gnews.setId(jsonObject.get("_id").getAsString());
        Gnews.setTitulo(jsonObject.get("title").getAsString());
        Gnews.setSubtitulo(jsonObject.get("body").getAsString());
        Gnews.setGame(jsonObject.get("game").getAsString());
        Gnews.setCreated_date(jsonObject.get("created_date").getAsString());
        Gnews.setCoverImage(jsonObject.get("coverImage").getAsString());
        Gnews.setDescription(jsonObject.get("description").getAsString());

        return Gnews;
    }
}
