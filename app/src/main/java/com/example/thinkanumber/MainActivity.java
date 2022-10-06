package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnPlusz;
    private Button btnMinusz;
    private Button btnTipp;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private TextView tippErtek;
    private ImageView[] eletek;
    private int tipp;
    private Random rnd;
    private int gondolt;
    private int elet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }
    private void addListeners(){
        btnPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipp < 10){
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this,"A gondolt szám nem lehet nagyobb, mint 10",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipp > 1){
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this,"A gondolt szám nem lehet kisebb, mint 1",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < gondolt){
                    eletCsokkent();
                    Toast.makeText(MainActivity.this,"A gondolt szám nagyobb",Toast.LENGTH_SHORT).show();
                } else if (tipp > gondolt){
                    eletCsokkent();
                    Toast.makeText(MainActivity.this,"A gondolt szám kisebb",Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: győzelem
                }
            }
        });
    }
    private void eletCsokkent(){
        if (elet > 0) {
            elet--;
        }
        eletek[elet].setImageResource(R.drawable.heart1);
        if (elet == 0){
            //TODO: Vereség
        }
    }
    private void init(){
        btnPlusz = findViewById(R.id.btnPlusz);
        btnMinusz = findViewById(R.id.btnMinusz);
        btnTipp = findViewById(R.id.btnTipp);
        hp1 = findViewById(R.id.hp_1);
        hp2 = findViewById(R.id.hp_2);
        hp3 = findViewById(R.id.hp_3);
        hp4 = findViewById(R.id.hp_4);
        eletek = new ImageView[] {hp1,hp2,hp3,hp4};
        tippErtek = findViewById(R.id.tippErtek);
        tipp = 1;
        elet = 4;
        rnd = new Random();
        gondolt = rnd.nextInt(10)+1;
        Log.d("gondolt",String.valueOf(gondolt));
    }
}