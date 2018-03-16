package com.example.montikarlo.clicker;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {


    NumberPicker numRoundMin;
    NumberPicker numRoundSec;
    NumberPicker numBreakMin;
    NumberPicker numBreakSec;
    NumberPicker roundCount;
    TextView displayTotal;
    Button compBtn;
    public long totalTime;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab Number Pickers ---------------------------------------------
        numRoundMin = findViewById(R.id.numberPicker_min);
        numRoundSec = findViewById(R.id.numberPicker_sec);
        numBreakMin = findViewById(R.id.breakPicker_min);
        numBreakSec = findViewById(R.id.breakPicker_sec);
        roundCount = findViewById(R.id.roundCountPicker);

        // Sets OnValueChangeListener
        numRoundMin.setOnValueChangedListener(this);
        numRoundSec.setOnValueChangedListener(this);
        numBreakMin.setOnValueChangedListener(this);
        numBreakSec.setOnValueChangedListener(this);
        roundCount.setOnValueChangedListener(this);

        // Round NumberPicker Values ---------------------------------------
        numRoundMin.setMinValue(0);
        numRoundMin.setMaxValue(12);
        numRoundMin.setValue(0);
        numRoundMin.setWrapSelectorWheel(true);

        numRoundSec.setMinValue(0);
        numRoundSec.setMaxValue(59);
        numRoundSec.setValue(0);
        numRoundSec.setWrapSelectorWheel(false);

        // Break NumberPicker Values ---------------------------------------
        numBreakMin.setMinValue(0);
        numBreakMin.setMaxValue(10);
        numBreakMin.setValue(0);
        numBreakMin.setWrapSelectorWheel(false);

        numBreakSec.setMinValue(0);
        numBreakSec.setMaxValue(59);
        numBreakSec.setValue(0);
        numBreakSec.setWrapSelectorWheel(false);

        // Round Counter NumberPicker Values
        roundCount.setMinValue(0);
        roundCount.setMaxValue(12);
        roundCount.setValue(0);
        roundCount.setWrapSelectorWheel(true);

        displayTotal = findViewById(R.id.totalDisplay);

        numRoundSec.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d" , value);
            }
        });

        /*
        numRoundMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv.setText(String.valueOf(numRoundMin.getValue() + numBreakSec.getValue()));
            }
        });
        */

        compBtn = findViewById(R.id.compBtn);
        intent = new Intent(this, TimerActivity.class);


        compBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("total",totalTime);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        int rdCt = roundCount.getValue();
        int rdMin = numRoundMin.getValue() * rdCt;
        int rdSec = numRoundSec.getValue() * rdCt;
        int brkMin = numBreakMin.getValue() * rdCt;
        int brkSec = numBreakSec.getValue() * rdCt;

        /*long totalTemp = ( (rdMin+rdSec+brkMin+brkSec) *rdCt);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, rdMin);
        c.set(Calendar.SECOND, rdSec);
        c.set(Calendar.MINUTE, brkMin);
        c.set(Calendar.SECOND, brkSec);*/

        long totalSeconds = TimeUnit.SECONDS.toMillis(rdSec+brkSec);
        long totalMinutes = TimeUnit.MINUTES.toMillis(rdMin+brkMin);
        totalTime = totalMinutes + totalSeconds;

        switch (picker.getId()){
            case R.id.numberPicker_min:
                displayTotal.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime)
                                - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(totalTime))));
                break;
            case R.id.numberPicker_sec:
                displayTotal.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime)
                                - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(totalTime))));
                break;
            case R.id.breakPicker_min:
                displayTotal.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime)
                                - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(totalTime))));
                break;
            case R.id.breakPicker_sec:
                displayTotal.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime)
                                - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(totalTime))));
                break;
            case R.id.roundCountPicker:
                displayTotal.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime)
                                - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(totalTime))));
                break;
            default:
                break;
        }




        /*switch (picker.getId()){
            case R.id.numberPicker_min:
                displayTotal.setText(String.valueOf( ( (rdMin+rdSec+brkMin+brkSec)* rdCt) ));
                break;
            case R.id.numberPicker_sec:
                displayTotal.setText(String.valueOf(( (rdMin+rdSec+brkMin+brkSec)* rdCt)));
                break;
            case R.id.breakPicker_min:
                displayTotal.setText(String.valueOf(( (rdMin+rdSec+brkMin+brkSec)* rdCt)));
                break;
            case R.id.breakPicker_sec:
                displayTotal.setText(String.valueOf(( (rdMin+rdSec+brkMin+brkSec)* rdCt)));
                break;
            case R.id.roundCountPicker:
                displayTotal.setText(String.valueOf(( (rdMin+rdSec+brkMin+brkSec)* rdCt)));
                break;
            default:
                break;
        }*/
    }
}
