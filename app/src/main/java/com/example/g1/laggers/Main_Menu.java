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

    boolean showOptions = false;

    Button butStart;
    Button butExit;
    Button oneHand, twoHand;

    public void startGame(View view){
        if (showOptions){
            butStart.setText("Start");
            oneHand.setVisibility(View.INVISIBLE);
            twoHand.setVisibility(View.INVISIBLE);
            showOptions = false;
        }else{
            butStart.setText("Return");
            oneHand.setVisibility(View.VISIBLE);
            twoHand.setVisibility(View.VISIBLE);
            showOptions = true;
        }
    }

    public void startOne(View view){
        if(showOptions){
            Intent i = new Intent(getApplicationContext(), GamePane.class);
            i.putExtra("num_of_controllers", 1);
            startActivity(i);
        }
    }

    public void startTwo(View view){
        if(showOptions){
            Intent i = new Intent(getApplicationContext(), GamePane.class);
            i.putExtra("num_of_controllers", 2);
            startActivity(i);
        }
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

        butStart = (Button)findViewById(R.id.gameButton);
        butStart.setText("Start");

        butExit = (Button)findViewById(R.id.exitButton);
        butExit.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        oneHand = (Button)findViewById(R.id.oneStart);
        twoHand = (Button)findViewById(R.id.twoStart);

        showOptions = false;
        oneHand.setVisibility(View.INVISIBLE);
        twoHand.setVisibility(View.INVISIBLE);
    }
}
