package com.example.g1.laggers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Main_Menu extends AppCompatActivity {

    Button butExit;

    public void startGame(View view){

    }

    public void startInstructions(View view){
        startActivity(new Intent(this, Instructions.class));
    }

    public void startLeaderboards(View vew){
        startActivity(new Intent(this, Leaderboards.class));
    }

    public void startAboutUs(View view){
        startActivity(new Intent(this, Credits.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        butExit = (Button)findViewById(R.id.exitButton);
        butExit.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}
