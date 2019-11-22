package com.example.jugandoconlasalarmas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonStart, buttonStop;

    final static int CODIGO_ALARMA = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.buttonPlay);
        buttonStop = findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent intent = new Intent(getBaseContext(), Alarma.class);

                PendingIntent pendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 30 * 1000, pendingIntent);

            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), Alarma.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.cancel(pendingIntent);

            }
        });


    }
}
