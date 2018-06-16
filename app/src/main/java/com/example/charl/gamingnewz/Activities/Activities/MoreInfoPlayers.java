package com.example.charl.gamingnewz.Activities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.R;
import com.squareup.picasso.Picasso;

public class MoreInfoPlayers extends AppCompatActivity {

    ImageView img;
    TextView name;
    TextView Bio;
    TextView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_players);


        game = findViewById(R.id.NJuego2);
        img = findViewById(R.id.ImgV2);
        name = findViewById(R.id.Ntitulo2);
        Bio = findViewById(R.id.NDesc2);


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        final Players player = (Players) bundle.getSerializable("info2");

        if (!(player.getAvatar() == null)) {
            Picasso.with(getApplicationContext()).load(player.getAvatar()).error(R.drawable.wdd).into(img);
        } else {
            Picasso.with(getApplicationContext()).load(R.drawable.wdd).error(R.drawable.wdd).into(img);
        }

        name.setText(player.getName());
        game.setText(player.getGame());
        Bio.setText(player.getBiografia());

    }

}
