package com.example.administrator.test8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else {
            init();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //同意
                    init();
                }else {
                    //拒绝
                }
                break;
        }
    }
    public void init(){
        try {
            Log.d("result","haha");
            mediaPlayer=new MediaPlayer();
            Log.d("result", Environment.getExternalStorageDirectory().toString());
            File f=new File(Environment.getExternalStorageDirectory(),"music.mp3");
            mediaPlayer.setDataSource(f.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startMusic(View view){


        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }
    public void pauseMusic(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    public void stopMusic(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.reset();
            init();
        }
    }



}
