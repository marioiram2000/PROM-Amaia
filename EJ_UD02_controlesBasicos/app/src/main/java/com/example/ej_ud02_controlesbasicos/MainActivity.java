package com.example.ej_ud02_controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSimple;
    private EditText ed1;
    private EditText ed2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSimple = (Button) findViewById(R.id.button);
        btnSimple.setOnClickListener(this);
        ed1 = (EditText) findViewById(R.id.editTextTextPersonName);
        ed1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        tv = (TextView) findViewById(R.id.textView4);
    }

    public void onClick(View v) {
        int n1 = Integer.parseInt(ed1.getText().toString());
        int n2 = Integer.parseInt(ed2.getText().toString());
        int result = n1+n2;
        tv.setText(result);
    }

}