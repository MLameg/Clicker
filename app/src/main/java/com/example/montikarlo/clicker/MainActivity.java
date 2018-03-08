package com.example.montikarlo.clicker;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int counterInt = 0;
    EditText timer_ET;
    int userTime = 0;
    TextView counterDisplay;
    TextView timerDisplay;
    private static final String FORMAT = "%02d:%02d:%02d";
    private static final String counterFormat ="%03d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer_ET = findViewById(R.id.timerET);
        counterDisplay = findViewById(R.id.counterDisplay);
        timerDisplay = findViewById(R.id.timerDisplay);

        Button timerBtn = findViewById(R.id.timerBtn);
        Button counterBtn = findViewById(R.id.counterBtn);

        userTime = Integer.parseInt(timer_ET.getText().toString());




        timerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(userTime, 1000){
                    public void onTick(long millisUntilFinished) {
                        timerDisplay.setText(""
                                +String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                        TimeUnit.HOURS.toMinutes(
                                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
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
