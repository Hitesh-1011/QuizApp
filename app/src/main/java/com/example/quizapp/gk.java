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
import androidx.appcompat.app.AppCompatDelegate;

public class gk extends AppCompatActivity{
    int itr=0;
    TextView t1,ans;
    RadioGroup rg;
    RadioButton op1,op2,op3,op4;
    ImageView img;
    Button prev,next,submit;
    ArrayList<SetQuestions> arr = new ArrayList<>();
    String  yourOption[]=new String[10];
    @Override
    public void onBackPressed() {
        Intent i=new Intent(gk.this,MainActivity.class);
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
//      ans.setText("");
    }
    String answer[]={"366","7","21","5","India","Indus","Moscow","Tadpole","sty","Blue Wale"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        LinearLayout li=(LinearLayout)findViewById(R.id.root);
        li.setBackgroundColor(getResources().getColor(R.color.gkbgcolor));
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Resources res = getResources();
        rg=findViewById(R.id.rg);
//      ans=findViewById(R.id.answer);
        img= findViewById(R.id.image1);
        op1 = findViewById(R.id.gkq1r1);
        op2 = findViewById(R.id.gkq1r2);
        op3 = findViewById(R.id.gkq1r3);
        op4 = findViewById(R.id.gkq1r4);
        t1 = findViewById(R.id.text1);
        //Questions
        arr.add(new SetQuestions(res.getString(R.string.gkq10),R.drawable.gk,"314","365","366","356"));
        arr.add(new SetQuestions(res.getString(R.string.gkq4),R.drawable.gk,"9","8","7","6"));
        arr.add(new SetQuestions(res.getString(R.string.gkq5),R.drawable.gk,"20","21","22","23"));
        arr.add(new SetQuestions(res.getString(R.string.gkq6),R.drawable.gk,"3","5","7","9"));
        arr.add(new SetQuestions(res.getString(R.string.gkq1),R.drawable.gk,"India","China","USA","Russia"));
        arr.add(new SetQuestions(res.getString(R.string.gkq2),R.drawable.gk,"Ganga","Godavari","Indus","kaveri"));
        arr.add(new SetQuestions(res.getString(R.string.gkq3),R.drawable.gk,"wellington","Moscow","Canberra","Seoul"));
        arr.add(new SetQuestions(res.getString(R.string.gkq7),R.drawable.gk,"joey","kid","Tadpole","calf"));
        arr.add(new SetQuestions(res.getString(R.string.gkq8),R.drawable.gk,"water","mud","sty","garbage"));
        arr.add(new SetQuestions(res.getString(R.string.gkq9),R.drawable.gk,"Dinosorus","Elephant","Giraffe","Blue Wale"));

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
//                        adddata();
//                    }
//                    else {
//                        next.setVisibility(View.VISIBLE);
//                        itr--;
//                        adddata();
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
                    Intent newActivity2 = new Intent(gk.this, scorecard.class);
                    newActivity2.putExtra("a",scr);
                    startActivity(newActivity2);
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
//                    if(yourOption[itr].equals(answer[itr])){
//                        ans.setText("Correct Answer, Well done");
//                    }
//                    else{
//                        ans.setText("Wrong Answer, Correct answer is "+answer[itr]);
//                    }
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