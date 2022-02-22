package com.example.juego;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.support.v4.app.NavUtils;

public class JuegoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_juego);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(new juegoView(this) );
        setContentView(new surfaceView(this) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_juego, menu);
        return true;
    }

    
}
