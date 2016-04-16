package com.example.g1.laggers;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        Bundle extras = getIntent().getExtras();
        int num = extras.getInt("num_of_controllers");

        setContentView(R.layout.activity_game_pane);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;

        final Button button1, button2;

        button1 = (Button)findViewById(R.id.butP1);
        button2 = (Button)findViewById(R.id.butP2);

        if(num == 1){
            button2.setVisibility(View.INVISIBLE);

        }else if(num ==2){
            button1.setX(button1.getX() - 200);
            button2.setX(button2.getX() + 200);

            button2.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_MOVE:
                            button2.setX((int) event.getRawX() - button2.getWidth());
                            button2.setY((int) event.getRawY() - button2.getHeight());
                            if (button2.getX() < 0) {
                                button2.setX(0);
                            }
                            if(button2.getX() > width - button2.getWidth()){
                                button2.setX(width - button2.getWidth());
                            }
                            if (button2.getY() < 0){
                                button2.setY(0);
                            }
                            if(button2.getY() > height - button2.getHeight()*1.5){
                                button2.setY(height - button2.getHeight()*2);
                            }


                            break;
                    }
                    return true;
                }
            });
        }

        button1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        button1.setX((int) event.getRawX() - button1.getWidth());
                        button1.setY((int) event.getRawY() - button1.getHeight());
                        if (button1.getX() < 0) {
                            button1.setX(0);
                        }
                        if(button1.getX() > width - button1.getWidth()){
                            button1.setX(width - button1.getWidth());
                        }
                        if (button1.getY() < 0){
                            button1.setY(0);
                        }
                        if(button1.getY() > height - button1.getHeight()*1.5){
                            button1.setY(height - button1.getHeight()*2);
                        }

                        break;
                }
                return true;
            }
        });

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
