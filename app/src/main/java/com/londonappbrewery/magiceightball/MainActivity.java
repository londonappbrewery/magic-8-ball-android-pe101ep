package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button Bask;
    ImageView IVball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate Views from XML
        Bask = (Button) findViewById(R.id.Bask);
        IVball = (ImageView) findViewById(R.id.IVball);

        // Create a random Object for the images to chose
        final Random randGen = new Random();

        // array List of all id for the images to be displayed
        final ArrayList<Integer> ballResId = new ArrayList<Integer>();
        ballResId.add(R.drawable.ball1);
        ballResId.add(R.drawable.ball2);
        ballResId.add(R.drawable.ball3);
        ballResId.add(R.drawable.ball4);
        ballResId.add(R.drawable.ball5);

        // hide image first time app is opened
        IVball.setVisibility(View.INVISIBLE);

        // handles the ask button
        // check for nullability
        if(Bask != null) {
            Bask.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int randNum = randGen.nextInt(5);

                    // set the correct image
                    IVball.setImageResource(ballResId.get(randNum));

                    // make image visible
                    IVball.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}