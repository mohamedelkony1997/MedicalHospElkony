package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Loading_Activity extends AppCompatActivity {
ProgressBar progressBar;
int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
     onprogressloading();
    }
   public  void onprogressloading(){
        progressBar=(ProgressBar) findViewById(R.id.progress);
        Timer timer=new Timer();
       TimerTask timerTask=new TimerTask() {
           @Override
           public void run() {
               counter++;
               progressBar.setProgress(counter);
               if(counter==100){
                   Intent intent=new Intent(Loading_Activity.this,Login.class);
                   startActivity(intent);
                   timer.cancel();

               }
           }
       };
       timer.schedule(timerTask,0,100);

   }
}