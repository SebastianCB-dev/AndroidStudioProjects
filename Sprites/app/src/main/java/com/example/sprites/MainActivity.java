package com.example.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    Button btnUp, btnDown, btnLeft, btnRight, btnAttack;
    ImageView character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUp     = findViewById(R.id.buttonUp);
        btnDown   = findViewById(R.id.buttonDown);
        btnLeft   = findViewById(R.id.buttonLeft);
        btnRight  = findViewById(R.id.buttonRight);
        btnAttack = findViewById(R.id.buttonAttack);
        character = findViewById(R.id.imageChar);
        character.setImageDrawable(getResources().getDrawable(R.drawable.idle000));
        btnAttack.setOnClickListener(this::atacar);


    }

    private void atacar(View view) {

        character.setImageDrawable(getResources().getDrawable(R.drawable.attack000));

        character.setImageDrawable(getResources().getDrawable(R.drawable.attack001));
        /*character.setImageDrawable(getResources().getDrawable(R.drawable.attack001));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack002));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack003));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack004));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack005));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack006));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack007));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack008));
        SystemClock.sleep(1000);
        character.setImageDrawable(getResources().getDrawable(R.drawable.attack009));
        SystemClock.sleep(1000);
        //character.setImageDrawable(getResources().getDrawable(R.drawable.idle000));*/
    }




}