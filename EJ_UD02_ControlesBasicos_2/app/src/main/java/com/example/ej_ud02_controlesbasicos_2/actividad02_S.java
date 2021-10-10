package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        setContentView(R.layout.activity_actividad02_s);

        Bundle bundle = getIntent().getExtras();
        if(bundle==null || bundle.isEmpty()){
            aciertos = 0;
            fallos = 0;
        }else{
            aciertos = bundle.getInt("aciertos");
            fallos = bundle.getInt("fallos");
        }
        TextView tvr = findViewById(R.id.textView5);
        tvr.setText("Has acertado "+aciertos+" y fallado "+fallos);
        sacarNums();
    }

    public void comprobarResultado(View v){

        EditText et3 = findViewById(R.id.editTextNumber3);
        if(et3.getText()!=null && !et3.getText().equals("")){
            int result = Integer.parseInt(et3.getText().toString());
            String c;
            if(result == (n1+n2)){
                aciertos ++;
                c = "CORRECTO";
            }else{
                fallos ++;
                c = "INCORRECTO";
            }
            et3.setText("");

            Intent intent = new Intent(this, actividad_02_R.class);
            intent.putExtra("correcto", c);
            intent.putExtra("aciertos", aciertos);
            intent.putExtra("fallos", fallos);
            startActivity(intent);
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