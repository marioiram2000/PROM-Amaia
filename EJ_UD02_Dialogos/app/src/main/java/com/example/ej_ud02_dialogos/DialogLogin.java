package com.example.ej_ud02_dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogLogin extends DialogFragment {

    private DialogLogin.OnDialogoConfirmacionListener listener;
    private String error;

    static DialogLogin newInstance(String err) {
        DialogLogin f = new DialogLogin();
        Bundle args = new Bundle();
        args.putString("error", err);
        f.setArguments(args);

        return f;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        error = getArguments().getString("error");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        setCancelable(false);
        builder.setView(inflater.inflate(R.layout.dialog_login, null))
                //Añadimos un botón de aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onPossitiveButtonClick();
                            }
                        })
                //Añadimos un botón de cancelar
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onNegativeButtonClick();
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_login, null);
        TextView tv = v.findViewById(R.id.textViewError);
        tv.setText(error);
        return v;
    }

    //Creamos una interfaz con las funciones asociadas a los botones.
    //Luego en el main activity, implementaremos la interfaz y las funciones
    public interface OnDialogoConfirmacionListener{
        void onPossitiveButtonClick(); //Eventos Botón Positivos
        void onNegativeButtonClick();  //Eventos Botón Negativo
    }

    //Hay que añadir esto para que no salga un error
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (DialogLogin.OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +" no Implemento OnDialogoConfirmacionListener");
        }
    }
}


