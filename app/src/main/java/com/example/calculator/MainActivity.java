package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private double sum(double a, double b){
        return a + b;
    }

    private double min(double a, double b){
        return a - b;
    }

    private double div(double a, double b){
        return a/b;
    }

    private  double mult(double a, double b){
        return a*b;
    }

}