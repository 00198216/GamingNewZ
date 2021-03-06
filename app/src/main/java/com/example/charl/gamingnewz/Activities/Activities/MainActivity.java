package com.example.charl.gamingnewz.Activities.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Fragments.DinamicDrawer;
import com.example.charl.gamingnewz.Activities.Fragments.MainNews;
import com.example.charl.gamingnewz.Activities.Fragments.PictureFragment;
import com.example.charl.gamingnewz.Activities.Fragments.PlayerFragment;
import com.example.charl.gamingnewz.Activities.Fragments.TabbedFragment;
import com.example.charl.gamingnewz.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , MainNews.OnFragmentInteractionListener,TabbedFragment.OnFragmentInteractionListener,PlayerFragment.OnFragmentInteractionListener, PictureFragment.OnFragmentInteractionListener,DinamicDrawer.OnFragmentInteractionListener{

   public static Boolean flag = true;
   private TextView name;
   private String Usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if(flag) {
            //Para solo cargarlo una vez

            getSupportFragmentManager().beginTransaction().replace(R.id.content, new MainNews()).commit();

            SharedPreferences sharedPreferences = this.getSharedPreferences("Game", Context.MODE_PRIVATE); //Inicializamos el SharedPreference
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Games","Ultimas Noticias");
            editor.apply();

            flag= false;
        }

        name= findViewById(R.id.UsrW);
        SharedPreferences sharedPref = getSharedPreferences("LToken",Context.MODE_PRIVATE);
        Usr = sharedPref.getString("usuario","");
        name.setText(Usr);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view3);
        navigationView2.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.incluido, new DinamicDrawer()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        Fragment f = null;

        boolean state =false;

        SharedPreferences Game = getSharedPreferences("Game", Context.MODE_PRIVATE);

        int id = item.getItemId();

        if (id == R.id.newsD) {

            f= new MainNews();

            Game.edit().putString("Games",(String) item.getTitle()).apply();

            state= true;

        } else if (id == R.id.SettingsD) {

            Intent intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);

        } else if (id == R.id.FavD) {

        }

        if(state){
            getSupportFragmentManager().beginTransaction().replace(R.id.content,f).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
