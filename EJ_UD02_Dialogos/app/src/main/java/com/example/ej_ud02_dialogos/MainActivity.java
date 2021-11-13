package com.example.ej_ud02_dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogLogin.OnDialogoConfirmacionListener {

    private DialogLogin dialogLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLogin("");
    }

    private void showLogin(String error) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        dialogLogin = new DialogLogin().newInstance(error);
        dialogLogin.show(fragmentManager, "Login dialog");
    }

    private void checklogin() {
        String username = ((EditText) dialogLogin.getDialog().findViewById(R.id.editTextUsername)).getText().toString();
        String password = ((EditText) dialogLogin.getDialog().findViewById(R.id.editTextPassword)).getText().toString();
        Log.println(Log.DEBUG, "username", username);
        Log.println(Log.DEBUG, "password", password);
        if (username.equals("usuario1") && password.equals("123456")) {
            Log.println(Log.DEBUG, "BIEN", "Login correcto");
        } else {
            Log.println(Log.DEBUG, "MAL", "Login incorrecto");
            showLogin("Datos incorrectos");
        }
    }

    @Override
    public void onPossitiveButtonClick() {
        checklogin();
    }

    @Override
    public void onNegativeButtonClick() {
        finish();
    }

    public void openIndex() {
        Intent intent = new Intent(this, index.class);
        startActivity(intent);
    }

    public void exitConfirmation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Salir");
        builder.setMessage("¿Estás seguro de querer salir de la aplicación?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                });
        builder.setNegativeButton("No", null);
        builder.show();
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void salir(View view) {
        exitConfirmation();
    }
    public void onBackPressed(){
        exitConfirmation();
    }
}