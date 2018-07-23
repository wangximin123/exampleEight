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
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoView);
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
            File f=new File(Environment.getExternalStorageDirectory(),"movie.mp4");
           videoView.setVideoPath(f.getPath());

    }
    public void startMovie(View view){


        if (!videoView.isPlaying()){
            videoView.start();
        }
    }
    public void pauseMovie(View view){
        if (videoView.isPlaying()){
            videoView.pause();
        }
    }
    public void resumeMovie(View view){
        if (videoView.isPlaying()){
            videoView.resume();
        }
    }



}
