package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class actividad02_S extends AppCompatActivity {

    int n1, n2;
    int aciertos;
    int fallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aciertos = 0;
        fallos = 0;
        setContentView(R.layout.activity_actividad02_s);
        sacarNums();
    }

    public void comprobarResultado(View v){
        EditText et3 = findViewById(R.id.editTextNumber3);
        if(!et3.getText().equals("")){
            int result = Integer.parseInt(et3.getText().toString());
            TextView tvr = findViewById(R.id.textView5);
            if(result == (n1+n2)){
                aciertos ++;
            }else{
                fallos ++;
            }
            et3.setText("");
            tvr.setText("Has acertado "+aciertos+" y fallado "+fallos);
            sacarNums();
        }
    }

    private void sacarNums(){
        n1 = (int)(Math.random() * (100 + 1));
        n2 = (int)(Math.random() * (100 + 1));

        EditText et1 = findViewById(R.id.editTextNumber1);
        EditText et2 = findViewById(R.id.editTextNumber2);

        et1.setText(n1+"");
        et2.setText(n2+"");
    }


}