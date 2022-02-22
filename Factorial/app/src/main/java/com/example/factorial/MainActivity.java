package com.example.factorial;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumber;
    Button btnCalcular;
    ArrayAdapter adapter;
    ListView lvFactorial;
    ArrayList<String> historial = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber    = findViewById(R.id.inputNumber);
        btnCalcular = findViewById(R.id.buttonResult);

        lvFactorial = (ListView) findViewById(R.id.listView);

        adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historial);
        lvFactorial.setAdapter(adapter);
        btnCalcular.setOnClickListener(this);

    }

    public double factorial (int numero) {
        double acum = 1;
        for (int i = numero; i > 0; i--) {
            acum *= i;
        }
        SystemClock.sleep(1000);
        return acum;
    }

    @Override
    public void onClick(View v) {

        if(etNumber.getText().toString().length() == 0 ) {
            Toast.makeText(this,"El campo numero es requerido!", Toast.LENGTH_LONG).show();
            return;
        }

        int numero = Integer.parseInt(etNumber.getText().toString());
        /*historial.add( numero + "! = " + factorial(numero) );
        lvFactorial.setAdapter(adapter);*/
        try {
            MiHilo hilo = new MiHilo(numero);
            hilo.start();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error " + e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    class MiHilo extends Thread {
        int n = 2;
        double fact;

        public MiHilo(int x) {
            this.n = x;
        }

        public void run() {
            Toast.makeText(getApplicationContext(),"asd", Toast.LENGTH_LONG).show();
            /*
            try {
                historial.add( this.n + "! = " + factorial(this.n) );
                lvFactorial.setAdapter(adapter);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "error " + e.getMessage(), Toast.LENGTH_LONG).show();
            }*/

        }

    }

}