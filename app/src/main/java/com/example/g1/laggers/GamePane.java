package com.example.g1.laggers;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GamePane extends AppCompatActivity {
    private ImageView ball1;
    private int[] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;

    RelativeLayout glayout;

    public void nextImage(){
        ball1.setImageResource(imageArray[currentIndex]);
        currentIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentIndex>endIndex){
                    currentIndex--;
                    previousImage();
                }else{
                    nextImage();
                }

            }
        },1000); // here 1000(1 second) interval to change from current  to next image

    }
    public void previousImage(){
        ball1.setImageResource(imageArray[currentIndex]);

        currentIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentIndex < startIndex) {
                    currentIndex++;
                    nextImage();
                } else {
                    previousImage(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        }, 1000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pane);

        glayout = (RelativeLayout) findViewById(R.id.gamelayout);
        ball1 = (ImageView)findViewById(R.id.iv1);
        imageArray = new int[8];
        imageArray[0] = R.drawable.ball1;
        imageArray[1] = R.drawable.ball2;
        imageArray[2] = R.drawable.ball3;
        imageArray[3] = R.drawable.ball4;
        imageArray[4] = R.drawable.ball5;
        imageArray[5] = R.drawable.ball1;
        imageArray[6] = R.drawable.ball2;
        imageArray[7] = R.drawable.ball3;
        startIndex = 0;
        endIndex = 7;
        nextImage();
    }

}
