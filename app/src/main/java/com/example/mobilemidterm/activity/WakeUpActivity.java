package com.example.mobilemidterm.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobilemidterm.R;
import com.example.mobilemidterm.service.SoundService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class WakeUpActivity extends AppCompatActivity {

    Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_wake_up);
        Toolbar toolbar = findViewById(R.id.toolbarWakeUp);
        setSupportActionBar(toolbar);


        startService(new Intent(this, SoundService.class));

        stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(WakeUpActivity.this, SoundService.class));
            }
        });


    }

}
