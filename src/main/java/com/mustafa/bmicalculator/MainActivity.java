package com.mustafa.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.google.android.material.snackbar.Snackbar;
import com.mustafa.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    float weight=0,height=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.weightText.setText(progress+"/250 kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.heightText.setText(progress+"/220 cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calculateBMI(){
        float result;
        float fltHeight = height/100;
        result = weight / (fltHeight*fltHeight);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result",result);
        startActivity(intent);
    }

    public void calculateBtn(View view){
        weight = binding.seekBar.getProgress();
        height = binding.seekBar2.getProgress();

        if(weight != 0 && height != 0){
            calculateBMI();
        }else{
            Snackbar.make(view,"Choose weight and height!",Snackbar.LENGTH_LONG).show();
        }
    }


}