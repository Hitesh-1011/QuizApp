package com.example.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class geography extends AppCompatActivity {
    int itr=0;
    TextView t1,ans;
    RadioGroup rg;
    RadioButton op1;
    RadioButton op2;
    RadioButton op3;
    RadioButton op4;
    ImageView img;
    Button prev;
    Button next;
    Button submit;
    ArrayList<SetQuestions> arr = new ArrayList<>();
    String  yourOption[]=new String[10];
    @Override
    public void onBackPressed() {
        Intent i=new Intent(geography.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void visibility()
    {
        if(itr==arr.size()-1)
            submit.setVisibility(View.VISIBLE);
    }
    public void adddata(){
        t1.setText(arr.get(itr).getQues());
        //img.setImageResource(arr.get(itr).getimg());
        op1.setText(arr.get(itr).getOp1());
        op2.setText(arr.get(itr).getOp2());
        op3.setText(arr.get(itr).getOp3());
        op4.setText(arr.get(itr).getOp4());
        //ans.setText("");
    }
    String answer[]={"Russia","China","Pacific Ocean","Africa","Southern Hemisphere","Antartica","Sri Lanka","Egypt","Sahara Desert","3180 km"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        LinearLayout li= findViewById(R.id.root);
        li.setBackgroundColor(getResources().getColor(R.color.sportbgcolor));
        Resources res = getResources();
        rg=findViewById(R.id.rg);
//      ans=findViewById(R.id.answer);
        img= findViewById(R.id.image1);
        op1 = findViewById(R.id.gkq1r1);
        op2 = findViewById(R.id.gkq1r2);
        op3 = findViewById(R.id.gkq1r3);
        op4 = findViewById(R.id.gkq1r4);
        t1 = findViewById(R.id.text1);
        arr.add(new SetQuestions("Which is the largest country in the world?",R.drawable.gk,"Russia","India","China","Africa"));
        arr.add(new SetQuestions("Which country has the largest population in the world?",R.drawable.gk,"India","China","USA","Italy"));
        arr.add(new SetQuestions("What is the name of the biggest ocean on earth?",R.drawable.gk,"Indian Ocean","Pacific Ocean","Antartic Ocean","Artic Ocean"));
        arr.add(new SetQuestions("Which is the hottest continent on earth?",R.drawable.gk,"Africa","Antartica","Australia","Asia"));
        arr.add(new SetQuestions("Which hemisphere does Australia lie on",R.drawable.gk,"Southern Hemisphere","Northern hemisphere","Eastern hemisphere","Western hemisphere"));
        arr.add(new SetQuestions("Which is the coldest place place on earth",R.drawable.gk,"Antartica","Australia","Africa","Asia"));
        arr.add(new SetQuestions("Caylon is the former name of which country",R.drawable.gk,"India","Sri Lanka","China","None of these"));
        arr.add(new SetQuestions("Cairo is the capital of which country?",R.drawable.gk,"Iraq","Saudi Arabia","Egypt","Turkey"));
        arr.add(new SetQuestions("What is the biggest desert in the world?",R.drawable.gk,"Sahara Desert","Thar Desert","Mojave Desert","Gobi Desert"));
        arr.add(new SetQuestions("What is the length of the indus river?",R.drawable.gk,"3200 km","3180 km","3220 km","3160 km"));

        t1.setText(arr.get(0).getQues());
        img.setImageResource(arr.get(0).getimg());
        op1.setText(arr.get(0).getOp1());
        op2.setText(arr.get(0).getOp2());
        op3.setText(arr.get(0).getOp3());
        op4.setText(arr.get(0).getOp4());
        int a=getTaskId(R.id.gkq1r1);
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        submit=findViewById(R.id.submit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //prev.setVisibility(View.VISIBLE);
                rg.clearCheck();
                if(itr==arr.size()-2){
                    next.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    itr++;
                    adddata();
                }
                else {
                    //prev.setVisibility(View.VISIBLE);
                    itr++;
                    adddata();
                    visibility();
                }
            }

        });
//        prev.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(itr==1){
//                        //prev.setVisibility(View.INVISIBLE);
//                        t1.setText(arr.get(--itr).getQues());
//                        //img.setImageResource(arr.get(itr).getimg());
//                        op1.setText(arr.get(itr).getOp1());
//                        op2.setText(arr.get(itr).getOp2());
//                        op3.setText(arr.get(itr).getOp3());
//                        op4.setText(arr.get(itr).getOp4());
//                        ans.setText("");
//                    }
//                    else {
//                        next.setVisibility(View.VISIBLE);
//                        itr--;
//                        t1.setText(arr.get(itr).getQues());
//                        //img.setImageResource(arr.get(itr).getimg());
//                        op1.setText(arr.get(itr).getOp1());
//                        op2.setText(arr.get(itr).getOp2());
//                        op3.setText(arr.get(itr).getOp3());
//                        op4.setText(arr.get(itr).getOp4());
//                        ans.setText("");
//                    }
//                }
//
//            });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score=0;

                for(int i=0;i<answer.length;i++){
                    if(answer[i].equals(yourOption[i])){
                        score+=1; //score=score+1
                    }
                }
                String scr=String.valueOf(score);
                Intent newActivity1 = new Intent(geography.this, scorecard.class);
                newActivity1.putExtra("a",scr);
                startActivity(newActivity1);
                finish();
            }
        });
    }

    private int getTaskId(int gkq1r1) {
        int one=gkq1r1;
        return one;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.gkq1r1:
                if (checked)
                    yourOption[itr]=op1.getText().toString();
                break;

            case R.id.gkq1r2:
                if (checked)
                    yourOption[itr]=op2.getText().toString();
                break;

            case R.id.gkq1r3:
                if (checked)
                    yourOption[itr]=op3.getText().toString();
                break;

            case R.id.gkq1r4:
                if (checked)
                    yourOption[itr]=op4.getText().toString();
                break;
        }
    }
}
