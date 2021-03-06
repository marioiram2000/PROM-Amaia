package com.example.ej_ud02_controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    private Button btnSimple;
    private Button btn1;
    private EditText ed1;
    private EditText ed2;
    private TextView tv;
    private int n1;
    private int n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ed1 = (EditText) findViewById(R.id.editTextTextPersonName);
        //ed2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        //tv = (TextView) findViewById(R.id.textView4);
        //btnSimple = (Button) findViewById(R.id.button);
        //btnSimple.setOnClickListener(this);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView iv = (ImageView) findViewById(R.id.imgCam1);
                if(isChecked){iv.setImageResource(R.drawable.camara);}
                else{iv.setImageDrawable(null);}
            }
        });

        Switch switch2 =(Switch) findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView iv = (ImageView) findViewById(R.id.imgLuz1);
                if(isChecked){iv.setImageResource(R.drawable.luzon);}
                else{iv.setImageResource(R.drawable.luzoff);}
            }
        });
/*
        ToggleButton toggle1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggle1.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView iv = (ImageView) findViewById(R.id.imgCam2);
                if(isChecked){iv.setImageResource(R.drawable.camara);}
                else{iv.setImageDrawable(null);}
            }
        });*/
/*
        ToggleButton toggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle2.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView iv = (ImageView) findViewById(R.id.imgLuz2);
                if(isChecked){iv.setImageResource(R.drawable.luzon);}
                else{iv.setImageResource(R.drawable.luzoff);}
            }
        });
*/
    }

    public void onClick(View v) {
        /*
        int n1 = Integer.parseInt(ed1.getText().toString());
        int n2 = Integer.parseInt(ed2.getText().toString());
        int result = n1+n2;
        tv.setText(result+"");

         */
    }

    public void operar(View v) {
        /*
        n1 = Integer.parseInt(ed1.getText().toString());
        n2 = Integer.parseInt(ed2.getText().toString());
        switch (v.getId()){
            case R.id.button1:
                tv.setText(n1+n2+"");
                break;
            case R.id.button2:
                tv.setText(n1-n2+"");
                break;
            case R.id.button3:
                tv.setText(n1*n2+"");
                break;
            case R.id.button4:
                tv.setText((float)n1/(float)n2+"");
                break;
        }

         */
    }

    public void encender(View v){
        //LinearLayout bgElement = (LinearLayout) findViewById(R.id.linear);
        //bgElement.setBackgroundColor(Color.RED);
    }

    public void apagar(View v){
        //LinearLayout bgElement = (LinearLayout) findViewById(R.id.linear);
        //bgElement.setBackgroundColor(Color.WHITE);
    }

    public void validarDNI(View v){
        /*
        EditText numeros = (EditText) findViewById(R.id.editTextNumber);
        EditText letra = (EditText) findViewById(R.id.editTextTextPersonName);
        String dniAComprobar = numeros.getText()+""+letra.getText();
        TextView tv = (TextView) findViewById(R.id.textView2);
        if(validador(dniAComprobar)){
            tv.setText("valido");
        }else{
            tv.setText("invalido");
        }

         */
    }

    private boolean validador(String dniAComprobar){
        // Array con las letras posibles del dni en su posici??n
        char[] letraDni = {
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
        String num= "";
        int ind = 0;
        // boolean que nos indicara si es un dni correcto o no
        boolean valido;
        // existen dnis con 7 digitos numericos, si fuese el caso
        // le a??ado un cero al principio
        if(dniAComprobar.length() == 8) {
            dniAComprobar = "0" + dniAComprobar;
        }
        // compruebo que el 9?? digito es una letra
        if (!Character.isLetter(dniAComprobar.charAt(8))) {
            return false;
        }
        // compruebo su longitud que sea 9
        if (dniAComprobar.length() != 9){
            return false;
        }
        // Compruebo que lo 8 primeros digitos sean numeros
        for (int i=0; i<8; i++) {
            if(!Character.isDigit(dniAComprobar.charAt(i))){
                return false;
            }
            // si es numero, lo recojo en un String
            num += dniAComprobar.charAt(i);
        }
        // paso a int el string donde tengo el numero del dni
        ind = Integer.parseInt(num);
        // calculo la posici??n de la letra en el array que corresponde a este dni
        ind %= 23;
        // verifico que la letra del dni corresponde con la del array
        if ((Character.toUpperCase(dniAComprobar.charAt(8))) != letraDni[ind]){
            return false;
        }
        // si el flujo de la funcion llega aqu??, es que el dni es correcto
        return true;
    }

    public void changeImg(View v){
        /*
        ImageView iv = (ImageView) findViewById(R.id.imgFoto);
        switch (v.getId()){
            case R.id.buttonBing:
                iv.setImageResource(R.drawable.bing);
                break;
            case R.id.buttonGoogle:
                iv.setImageResource(R.drawable.google);
                break;
            case R.id.buttonYahoo:
                iv.setImageResource(R.drawable.yahoo);
                break;
        }
        */
    }

}