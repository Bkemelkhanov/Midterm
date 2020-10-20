package com.example.mobilemidterm.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RawRes;

import com.example.mobilemidterm.R;

import java.io.IOException;


public class SoundService extends Service implements MediaPlayer.OnCompletionListener{

    MediaPlayer mediaPlayer;

    public SoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.wakeup);
        mediaPlayer.setOnCompletionListener(this);
        play();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void play() {
        mediaPlayer.start();
    }

    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        play();
    }
}
