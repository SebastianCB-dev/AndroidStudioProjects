package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSuma;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonIgual;
    Button buttonResta;
    Button buttonMultiplicacion;
    Button buttonDivision;
    Button buttonNegativo;
    Button buttonComa;
    Button buttonClear;
    TextView display;


    float primerOperando = 0.0f;
    float segundoOperando = 0.0f;
    String operacion = "";
    String displayText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         buttonSuma = findViewById(R.id.suma);
         button0 = findViewById(R.id.cero);
         button1 = findViewById(R.id.uno);
         button2 = findViewById(R.id.dos);
         button3 = findViewById(R.id.tres);
         button4 = findViewById(R.id.cuatro);
         button5 = findViewById(R.id.cinco);
         button6 = findViewById(R.id.seis);
         button7 = findViewById(R.id.siete);
         button8 = findViewById(R.id.ocho);
         button9 = findViewById(R.id.nueve);
         buttonIgual = findViewById(R.id.igual);
         buttonResta = findViewById(R.id.resta);
         buttonMultiplicacion = findViewById(R.id.multiplicacion);
         buttonDivision = findViewById(R.id.buttonDivision);
         buttonNegativo = findViewById(R.id.negativo);
         buttonComa = findViewById(R.id.buttonComa);
         buttonNegativo = findViewById(R.id.negativo);
         display = findViewById(R.id.displayOperacion);
        buttonClear = findViewById(R.id.buttonClear);

        buttonSuma.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonResta.setOnClickListener(this);
        buttonMultiplicacion.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        buttonNegativo.setOnClickListener(this);
        buttonComa.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

    }

    boolean isPrimerOperando = true;
    boolean isSegundoOperando = false;
    @Override
    public void onClick(View view) {

    Button buttonClick = findViewById( view.getId() );

    if( buttonClick.getText().equals("X") || buttonClick.getText().equals("/") || buttonClick.getText().equals("-")  || buttonClick.getText().equals("+")) {
        isPrimerOperando = false;
        isSegundoOperando = true;
        display.setText("");
        displayText = "";
        operacion = (String) buttonClick.getText();

    }

    else if( buttonClick.getText().equals("=") ) {
        calcularValor();
    }
    else if(buttonClick.getText().equals("Clear")) {
        limpiar();
    }
    else if( buttonClick.getId() == buttonNegativo.getId() ) {
        if( isPrimerOperando) {
            if( primerOperando != 0) {
                primerOperando *= -1;
                display.setText( String.valueOf(primerOperando));
            }

        }
        else{
            if(segundoOperando != 0) {
                segundoOperando *= -1;
                display.setText(String.valueOf(segundoOperando));
            }

        }
    }
    else if( buttonClick.getText().equals(".") && displayText.length() == 0) {
        return;
    }
    else if( isPrimerOperando ) {
            if(!(displayText.contains(".") && buttonClick.getText().equals("."))) {

                    displayText += buttonClick.getText();
                    display.setText(displayText);
                    primerOperando = Float.parseFloat(displayText);

            }
        }
    else if(isSegundoOperando){
        if(!(displayText.contains(".") && buttonClick.getText().equals("."))) {
            displayText += buttonClick.getText();
            display.setText(displayText);
            segundoOperando = Float.parseFloat(displayText);
        }
    }
}

    private void limpiar() {
        primerOperando = 0;
        segundoOperando = 0;
        isPrimerOperando = true;
        isSegundoOperando = false;
        displayText = "";
        display.setText(displayText);
    }

    private void calcularValor() {
        float resultado = 0;

        switch (operacion) {
            case "X":
                resultado = primerOperando * segundoOperando;
                break;
            case "+":
                resultado = primerOperando + segundoOperando;
                break;
            case "-":
                resultado = primerOperando - segundoOperando;
                break;
            case "/":
                resultado = primerOperando / segundoOperando;
                break;
            default:
                break;
        }
        isPrimerOperando = true;
        isSegundoOperando = false;
        primerOperando = resultado;
        segundoOperando = 0;
        operacion = "";
        String[] resultadoString = String.valueOf(resultado).split("\\.");
        if( Integer.parseInt(resultadoString[1]) == 0 ) {
            displayText = resultadoString[0];
            display.setText(resultadoString[0]);
            return;
        }
        displayText = String.valueOf(resultado);
        display.setText(String.valueOf(resultado));

    }


}