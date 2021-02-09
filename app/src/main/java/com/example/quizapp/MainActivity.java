package com.example.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        ArrayList<mathtopics> topics = new ArrayList<>();
        topics.add(new mathtopics(R.drawable.gk1,res.getString(R.string.Gk),"Baics questions in GK"));
        topics.add(new mathtopics(R.drawable.music1,res.getString(R.string.music),"Finding the instruments"));
        topics.add(new mathtopics(R.drawable.history,res.getString(R.string.History),"Exploring the ancient days"));
        topics.add(new mathtopics(R.drawable.sport,res.getString(R.string.sport),"Answering the names of popular players"));
        topics.add(new mathtopics(R.drawable.geography,res.getString(R.string.Geography),"Questions based on Geography"));
        topics.add(new mathtopics(R.drawable.art2,res.getString(R.string.art),"Questions based on Art and Literacy"));
        topics.add(new mathtopics(R.drawable.mathematics,"Mathematics","Basics questions on mathematical concepts"));
        mathadapter adapter = new mathadapter(this,topics);
        ListView listView = (ListView) findViewById(R.id.list_main);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent newActivity0 = new Intent(MainActivity.this, gk.class);
                        startActivity(newActivity0);
                        finish();
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(MainActivity.this, music.class);
                        startActivity(newActivity1);
                        finish();
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(MainActivity.this, history.class);
                        startActivity(newActivity2);
                        finish();
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(MainActivity.this, sport.class);
                        startActivity(newActivity3);
                        finish();
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(MainActivity.this, geography.class);
                        startActivity(newActivity4);
                        finish();
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(MainActivity.this, art.class);
                        startActivity(newActivity5);
                        finish();
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(MainActivity.this, mathematics.class);
                        startActivity(newActivity6);
                        finish();
                        break;
                }
                }
        });
    }
}