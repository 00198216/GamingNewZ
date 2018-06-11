package com.example.charl.gamingnewz.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.R;
import com.squareup.picasso.Picasso;

public class MoreInfo extends AppCompatActivity {

    ImageView img;
    TextView name;
    TextView desc;
    TextView date;
    TextView body;
    TextView game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);


        body = findViewById(R.id.NBody);
        game = findViewById(R.id.NJuego);
        img = findViewById(R.id.ImgV);
        desc = findViewById(R.id.NDesc);
        name = findViewById(R.id.Ntitulo);
        date = findViewById(R.id.NFecha);


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final News news = (News) bundle.getSerializable("info");

        if (!(news.getCoverImage() == null)) {
            Picasso.with(getApplicationContext()).load(news.getCoverImage()).error(R.drawable.wdd).into(img);
        } else {
            Picasso.with(getApplicationContext()).load(R.drawable.wdd).error(R.drawable.wdd).into(img);
        }

        name.setText(news.getTitle());
        desc.setText(news.getDescription());
        game.setText(news.getGame());
        body.setText(news.getBody());
        date.setText(news.getCreated_date());


    }
}
