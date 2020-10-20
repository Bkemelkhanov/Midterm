package com.example.mobilemidterm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobilemidterm.activity.WakeUpActivity;
import com.example.mobilemidterm.listcomponent.ListItem;
import com.example.mobilemidterm.util.DatabaseHelper;
import com.example.mobilemidterm.util.Util;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String TAG = AlarmReceiver.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {

        String requestCode = intent.getData().toString();
        DatabaseHelper helper = DatabaseHelper.getInstance(context);
        ListItem item = Util.getAlarmsByID(Integer.parseInt(requestCode), helper);

        Util.setAlarm(context, item);

        Intent startActivityIntent = new Intent(context, WakeUpActivity.class);
        startActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startActivityIntent);
    }
}
