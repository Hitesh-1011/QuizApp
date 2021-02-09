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

public class art extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent i=new Intent(art.this,MainActivity.class);
        startActivity(i);
        finish();
    }
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
    String answer[]={"Blue","14","Auguste Rodin","Leonardo da Vinci","Pablo Picasso","Sirius Black","Pig","Detective","Hermione","Her Mother"};
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
        arr.add(new SetQuestions("‘Celeste’ is a shade of which primary colour?",R.drawable.gk,"Black","Blue","Purple","Green"));
        arr.add(new SetQuestions("How many lines are there in a sonnet?",R.drawable.gk,"16","13","15","14"));
        arr.add(new SetQuestions("Who created the famous sculpture 'The Thinker'?",R.drawable.gk,"Auguste Rodin","Auguste Martin","Mark Rodin","Mark Robert"));
        arr.add(new SetQuestions("Who painted the Mona Lisa?",R.drawable.gk,"Pablo Picasso","Leonardo da Vinci","Claude Monet","Jackson Pollock"));
        arr.add(new SetQuestions("Which artist said ‘Everything you can imagine is real’?",R.drawable.gk,"Pablo Picasso","Leonardo da Vinci","Claude Monet","Jackson Pollock"));
        arr.add(new SetQuestions("Who is Harry Potter's godfather?",R.drawable.gk,"Lee Jordan","Sirius Black","Roger Davies","Grindelwald"));
        arr.add(new SetQuestions("What kind of animal is Wilbur in the book Charlotte's?",R.drawable.gk,"Tiger","Rat","Pig","None of these"));
        arr.add(new SetQuestions("What does Nancy Drew play in the book Nancy Drew?",R.drawable.gk,"SuperHero","Detective","Teacher","Doctor"));
        arr.add(new SetQuestions("Harry Potter's best female friend is?",R.drawable.gk,"Jimmy","Lou","Frodo","Hermione"));
        arr.add(new SetQuestions("In the book Freaky Friday, who does Annabel change bodies with?",R.drawable.gk,"Her Aunt","Her Dad","Her Teacher","Her Mother"));

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
                Intent intent = new Intent(art.this, scorecard.class);
                intent.putExtra("a",scr);
                startActivity(intent);
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

