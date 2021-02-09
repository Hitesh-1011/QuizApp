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

public class mathematics extends AppCompatActivity {
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
        Intent i=new Intent(mathematics.this,MainActivity.class);
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
    String answer[]={"1","8","-6","29","25","4","1","Cube unit","Multiplication","Isosceles triangle"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        LinearLayout li=(LinearLayout)findViewById(R.id.root);
        li.setBackgroundColor(getResources().getColor(R.color.mathematicsbgcolor));
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
        arr.add(new SetQuestions(res.getString(R.string.mq1),R.drawable.gk,"2","0","1","3"));
        arr.add(new SetQuestions(res.getString(R.string.mq4),R.drawable.gk,"2","8","4","10"));
        arr.add(new SetQuestions(res.getString(R.string.mq5),R.drawable.gk,"8","-2","6","-6"));
        arr.add(new SetQuestions(res.getString(R.string.mq6),R.drawable.gk,"27","25","29","31"));
        arr.add(new SetQuestions(res.getString(R.string.mq7),R.drawable.gk,"23","30","27","25"));
        arr.add(new SetQuestions(res.getString(R.string.mq9),R.drawable.gk,"2","5","3","4"));
        arr.add(new SetQuestions(res.getString(R.string.mq10),R.drawable.gk,"0","-1","1","none of these"));
        arr.add(new SetQuestions(res.getString(R.string.mq3),R.drawable.gk,"Square unit","Cube unit","both (a) & (b)","None of these"));
        arr.add(new SetQuestions(res.getString(R.string.mq8),R.drawable.gk,"Division","Addition","Multiplication","Subtraction"));
        arr.add(new SetQuestions(res.getString(R.string.mq2),R.drawable.gk,"Right angle triangle","Scalene triangle","Isosceles triangle","None of these"));


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
                Intent newActivity4 = new Intent(mathematics.this, scorecard.class);
                newActivity4.putExtra("a",scr);
                startActivity(newActivity4);
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

