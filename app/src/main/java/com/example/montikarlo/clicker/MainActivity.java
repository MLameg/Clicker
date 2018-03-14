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

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NumberPicker numPickMin = findViewById(R.id.numberPicker_min);
        NumberPicker numPickSec = findViewById(R.id.numberPicker_sec);


        numPickMin.setMinValue(0);
        numPickMin.setMaxValue(12);
        numPickMin.setValue(0);
        numPickMin.setWrapSelectorWheel(false);

        numPickSec.setMinValue(00);
        numPickSec.setMaxValue(59);
        numPickSec.setValue(00);
        numPickSec.setWrapSelectorWheel(false);

        Button btn = findViewById(R.id.btn);
        final TextView tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(numPickMin.getValue()));
            }
        });







    }
}
