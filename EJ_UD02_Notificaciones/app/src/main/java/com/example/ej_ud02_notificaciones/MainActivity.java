package com.example.ej_ud02_notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;

    private int cont;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private TextView tvResult;
    private int n1;
    private int n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont = 0;
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        editText3 = findViewById(R.id.editTextNumber3);
        tvResult = findViewById(R.id.textView5);
        sacarNums();
    }

    public void comprobarResultado(View v){
        if(editText3.getText()!=null && !editText3.getText().equals("")){
            int result = Integer.parseInt(editText3.getText().toString());
            String c;
            if(result == (n1+n2)){
                c = "CORRECTO";
            }else{
                c = "INCORRECTO";
            }
            editText3.setText("");
            tvResult.setText(c);
            sacarNums();
            cont ++;
        }
        if(cont == 2){
            sacarNotificacion();
        }
    }

    private void sacarNums(){
        n1 = (int)(Math.random() * (100 + 1));
        n2 = (int)(Math.random() * (100 + 1));

        editText1.setText(n1+"");
        editText2.setText(n2+"");
    }

    private void sacarNotificacion(){
        //Creamos notificacion
        notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        //Creamos el canal. SOLO puede hacerse en dispositivos con ver. 8 o más.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CANAL_ID, "Mis notificaciones",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripción del canal");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificacion =
                new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                        .setSmallIcon(R.drawable.outline_android_black_24dp)
                        .setContentTitle("Titulo de la notificación")
                        .setContentText("Este es el texto de la notificacion");
        notificationManager.notify(NOTIFICACION_ID, notificacion.build());
    }
}