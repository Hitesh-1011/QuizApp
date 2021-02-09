package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Instruction extends AppCompatActivity {
    Intent newActivity1 = new Intent(Instruction.this, gk.class);
    Intent intent=getIntent();
    int position=Integer.parseInt(intent.getStringExtra("p"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructionpage);
        Button button=findViewById(R.id.instrb1);

    }
}