package com.example.phaseone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button buttonA;
    private Button buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_layout);
        toolbar = findViewById(R.id.toolbar);
        buttonA = findViewById(R.id.button1);
        buttonB = findViewById(R.id.button2);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ALC 4 Phase 1");

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityB.class);
                startActivity(intent);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityC.class);
                startActivity(intent);
            }
        });
    }
}
