package com.example.tdd.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText Celsius;
    EditText Fahrenheit;
    double fah;
    int change = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Celsius = (EditText)findViewById(R.id.txtCelsius);
        Fahrenheit = (EditText)findViewById(R.id.txtFah);

        Celsius.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Celsius.hasFocus()) {
                    String celsius = s.toString();
                    if(celsius.equals("")) {
                        celsius = "0";
                        Celsius.setText(("0"));
                    }
                    double fah = (double) ((9 / 5) * Double.valueOf(celsius) + 32);
                    Fahrenheit.setText(String.valueOf(fah));
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Fahrenheit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //   change=1;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Fahrenheit.hasFocus() && !s.equals("")) {
                    String fahrenheit = s.toString();
                    if(fahrenheit.equals("")) {
                        fahrenheit = "0";
                        Fahrenheit.setText(("0"));

                    }
                    double cel = (double) ((5.0 / 9.0) * (Double.valueOf(fahrenheit) - 32));
                    Celsius.setText(String.valueOf(cel));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
