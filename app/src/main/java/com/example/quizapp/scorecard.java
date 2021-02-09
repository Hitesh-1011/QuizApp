package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scorecard extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    public void onBackPressed() {
        Intent i=new Intent(scorecard.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorepage);

        imageView=findViewById(R.id.scoreimg);
        textView=findViewById(R.id.score);
        Button button=findViewById(R.id.home);
        Intent intent=getIntent();
        String score=intent.getStringExtra("a");
        int scr=Integer.parseInt(score);
        textView.setText("Your score is "+score);

        if(scr==0){
            imageView.setImageResource(R.drawable.zero);
        }
        else if(scr>0 && scr<4){
            imageView.setImageResource(R.drawable.onetothree);
        }
        else if(scr>3 && scr<7){
            imageView.setImageResource(R.drawable.fourtosix);
        }
        else if(scr>6 && scr<10){
            imageView.setImageResource(R.drawable.sevtonine);
        }
        else{
            imageView.setImageResource(R.drawable.ten);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(scorecard.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}
