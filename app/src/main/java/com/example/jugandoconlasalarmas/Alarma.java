package com.example.jugandoconlasalarmas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Alarma extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MI ALARMA","La alarma ha saltado");
        Toast.makeText(context,"Alarma alarmaádote",Toast.LENGTH_LONG).show();
    }
}
