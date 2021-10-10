package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class actividad03_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad031);
    }

    public void enviar(View v){
        String data = "";
        data += ((EditText)findViewById(R.id.editTextTextPersonName)).getText()+ "\t";
        data += ((EditText)findViewById(R.id.editTextTextPersonLastame)).getText()+ "\t";
        int radioButtonID = ((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        RadioButton radioButton = ((RadioGroup)findViewById(R.id.radioGroup)).findViewById(radioButtonID);
        data += radioButton.getText().toString()+"\t";

        CheckBox c = (CheckBox) findViewById(R.id.checkBoxMusica);
        if(c.isChecked()){
            data += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.checkBoxLectura);
        if(c.isChecked()){
            data += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.checkBoxDeporte);
        if(c.isChecked()){
            data += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.checkBoxViajar);
        if(c.isChecked()){
            data += c.getText().toString()+"\t";
        }

        Intent intent = new Intent(this, actividad03_2.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }

}