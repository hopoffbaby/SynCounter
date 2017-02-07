package com.example.neil.syncounterfirsttry;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    double i=15.0;
    double synValue = 0.0;
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        final TextView synRemainingTB = (TextView) findViewById(R.id.synRemainingTB);
        synRemainingTB.setText(Double.toString(i));
        synRemainingTB.setTextColor(Color.GREEN);

        final Button gobbleButton = (Button) findViewById(R.id.gobbleButton);
        gobbleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                i=i-synValue;
                synRemainingTB.setText(Double.toString(i));
                if (i<0){
                    synRemainingTB.setTextColor(Color.RED);
                }
                else if (i < 5){
                    synRemainingTB.setTextColor(Color.CYAN);
                }
                else
                {
                    synRemainingTB.setTextColor(Color.GREEN);
                }

            }
        });

        final Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                i=15.0;
                synRemainingTB.setText(Double.toString(i));
                synRemainingTB.setTextColor(Color.GREEN);
            }
        });

        final TextView sliderValueTB = (TextView) findViewById(R.id.sliderValueText);
        sliderValueTB.setText("hello");
        final SeekBar sk = (SeekBar) findViewById(R.id.Slider);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                synValue = progress/2.0;
                sliderValueTB.setText(Double.toString(synValue));
                //sliderValueTB.setTextSize(progress);
                //Toast.makeText(getApplicationContext(), String.valueOf(progress),Toast.LENGTH_LONG).show();

            }
        });

    }
}
