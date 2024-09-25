package com.example.a1206469.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a1206469.R;

public class MainActivity extends AppCompatActivity {
    Button btnmsk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmsk = findViewById(R.id.btnmsk);
        btnmsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListBrg.class);
                startActivity(intent);
            }
        });

    }
}