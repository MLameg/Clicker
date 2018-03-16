package com.example.montikarlo.clicker;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by MontiKarlo on 3/10/2018.
 */

public class TimerActivity extends AppCompatActivity{

    int counterInt = 0;

    TextView counterDisplay;
    TextView timerDisplay;
    private static final String FORMAT = "%02d:%02d:%02d";
    private static final String counterFormat ="%03d";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        counterDisplay = findViewById(R.id.counterDisplay);
        timerDisplay = findViewById(R.id.timerDisplay);

        Button timerBtn = findViewById(R.id.timerBtn);
        Button counterBtn = findViewById(R.id.counterBtn);



        Intent intent = getIntent();
        final long userInput = intent.getLongExtra("total", 0);





        timerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(userInput, 1000){
                    public void onTick(long millisUntilFinished) {
                        timerDisplay.setText(""
                                +String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                                        - TimeUnit.HOURS.toMinutes(
                                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
                                        - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        timerDisplay.setText("done!");
                    }

                }.start();

            }
        });




        counterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterInt++;
                counterDisplay.setText(String.valueOf(String.format(counterFormat,counterInt)));

            }
        });



    }

}
