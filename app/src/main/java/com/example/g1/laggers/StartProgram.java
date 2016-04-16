package com.example.g1.laggers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class StartProgram extends AppCompatActivity {

    TextView tV;

    public void menuStartUpCountDown(){
        int animWelcome = R.anim.welcome_fade;
        tV = (TextView)findViewById(R.id.welcomeText);
        tV.setAnimation(AnimationUtils.loadAnimation(StartProgram.this, animWelcome));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_program);

        menuStartUpCountDown();

        Thread menuThread = new Thread(){

            @Override
            public void run(){
                try{
                    super.run();
                    sleep(2000);
                }catch(Exception e){

                }finally{
                    Intent i = new Intent(StartProgram.this, Main_Menu.class);
                    startActivity(i);
                }
                finish();
            }
        };
        menuThread.start();
    }

}
