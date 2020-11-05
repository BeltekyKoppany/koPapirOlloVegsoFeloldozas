package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_ko, b_papir, b_ollo;
    ImageView iv_cpu, iv_me;

    String cpuChoice, myChoice, result;

    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_ko = (Button) findViewById(R.id.b_ko);
        b_papir = (Button) findViewById(R.id.b_papir);
        b_ollo = (Button) findViewById(R.id.b_ollo);

        rnd = new Random();

        b_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Kő";
                iv_me.setImageResource(R.drawable.rock);
                szamolo();
            }
        });
        b_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Papír";
                iv_me.setImageResource(R.drawable.paper);
                szamolo();
            }
        });
        b_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Olló";
                iv_me.setImageResource(R.drawable.scissors);
                szamolo();
            }
        });
    }

    public void szamolo() {
        int cpu = rnd.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "Kő";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 1) {
            cpuChoice = "Papír";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 2) {
            cpuChoice = "Olló";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if (myChoice.equals("Kő") && cpuChoice.equals("Papír")) {
            result = "Vesztettél!";
        } else if (myChoice.equals("Kő") && cpuChoice.equals("Olló")) {
            result = "Nyertél!";
        } else if (myChoice.equals("Papír") && cpuChoice.equals("Olló")) {
            result = "Vesztettél!";
        } else if (myChoice.equals("Papír") && cpuChoice.equals("Kő")) {
            result = "Nyertél!";
        } else if (myChoice.equals("Olló") && cpuChoice.equals("Kő")) {
            result = "Vesztettél!";
        } else if (myChoice.equals("Olló") && cpuChoice.equals("Papír")) {
            result = "Nyertél!";
        } else if (myChoice.equals("Olló") && cpuChoice.equals("Olló")) {
            result = "Döntetlen";
        } else if (myChoice.equals("Kő") && cpuChoice.equals("Kő")) {
            result = "Döntetlen!";
        } else if (myChoice.equals("Papír") && cpuChoice.equals("Papír")) {
            result = "Döntetlen!";
        }
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}