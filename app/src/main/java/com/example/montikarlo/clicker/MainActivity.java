package com.example.montikarlo.clicker;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {


    NumberPicker numRoundMin;
    NumberPicker numRoundSec;
    NumberPicker numBreakMin;
    NumberPicker numBreakSec;
    NumberPicker roundCount;
    TextView displayTotal;

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

        numRoundSec.setMinValue(00);
        numRoundSec.setMaxValue(59);
        numRoundSec.setValue(00);
        numRoundSec.setWrapSelectorWheel(false);

        // Break NumberPicker Values ---------------------------------------
        numBreakMin.setMinValue(0);
        numBreakMin.setMaxValue(10);
        numBreakMin.setValue(0);
        numBreakMin.setWrapSelectorWheel(false);

        numBreakSec.setMinValue(00);
        numBreakSec.setMaxValue(59);
        numBreakSec.setValue(00);
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
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        switch (picker.getId()){
            case R.id.numberPicker_min:
                displayTotal.setText(String.valueOf(((numRoundMin.getValue() +
                        numRoundSec.getValue() + numBreakMin.getValue() +
                        numBreakSec.getValue())* roundCount.getValue())));
                break;
            case R.id.numberPicker_sec:
                displayTotal.setText(String.valueOf(((numRoundMin.getValue() +
                        numRoundSec.getValue() + numBreakMin.getValue() +
                        numBreakSec.getValue())* roundCount.getValue())));
                break;
            case R.id.breakPicker_min:
                displayTotal.setText(String.valueOf(((numRoundMin.getValue() +
                        numRoundSec.getValue() + numBreakMin.getValue() +
                        numBreakSec.getValue())* roundCount.getValue())));
                break;
            case R.id.breakPicker_sec:
                displayTotal.setText(String.valueOf(((numRoundMin.getValue() +
                        numRoundSec.getValue() + numBreakMin.getValue() +
                        numBreakSec.getValue())* roundCount.getValue())));
                break;
            case R.id.roundCountPicker:
                displayTotal.setText(String.valueOf(((numRoundMin.getValue() +
                        numRoundSec.getValue() + numBreakMin.getValue() +
                        numBreakSec.getValue())* roundCount.getValue())));
                break;
            default:
                break;
        }
    }
}
