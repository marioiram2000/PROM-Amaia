package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class actividad01_NA extends AppCompatActivity {

    EditText name;
    EditText lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad01_na);
        name = (EditText) findViewById(R.id.name);
        lastname = (EditText) findViewById(R.id.lastname);

    }

    public void volver(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void condiciones(View view){
        Intent intent = new Intent(this, actividad01_C.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("lastname", lastname.getText().toString());
        startActivityForResult(intent, 111);
    }

    protected void onActivityResult (int requestCode, int resultCode,
                                     Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            Boolean res = data.getExtras().getBoolean("aceptada");
        }
    }
}