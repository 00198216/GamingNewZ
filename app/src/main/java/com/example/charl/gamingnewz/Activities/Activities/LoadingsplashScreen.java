package com.example.charl.gamingnewz.Activities.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.charl.gamingnewz.Activities.Activities.Login;
import com.example.charl.gamingnewz.R;

public class LoadingsplashScreen extends AppCompatActivity {

    private SharedPreferences SavedLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingsplash_screen);
        getSupportActionBar().hide(); //La escondemos para  simular una loading screen


        SavedLogin = getSharedPreferences("LToken", Context.MODE_PRIVATE); //Jalamos los datos

        Intent Login = new Intent(this, Login.class);
        Intent Main = new Intent(this, MainActivity.class);

        if (TextUtils.isEmpty(SavedLogin.getString("usuario", "")) &&
                TextUtils.isEmpty(SavedLogin.getString("password", ""))
                && TextUtils.isEmpty(SavedLogin.getString("Token", ""))) {
            Login.setFlags(Login.FLAG_ACTIVITY_NEW_TASK | Login.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(Login);

        } else {
            Main.setFlags(Main.FLAG_ACTIVITY_NEW_TASK | Main.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(Main);
        }
    }
}
