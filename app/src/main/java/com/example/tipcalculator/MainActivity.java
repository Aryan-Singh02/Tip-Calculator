package com.example.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText enterAmount;
    SeekBar enterTip;
    TextView displayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = findViewById(R.id.editAmount);
        enterTip = findViewById(R.id.tipPercent);
        displayResult = findViewById(R.id.finalResult);

        enterTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String strText = enterAmount.getText().toString();
                double value = Double.parseDouble(strText);
                double tipPercent = (progress/100.0) * value;
                double totalTip = tipPercent + value;
                String result = String.valueOf(totalTip);
                displayResult.setText(result);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}