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

public class music extends AppCompatActivity {
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
        Intent i=new Intent(music.this,MainActivity.class);
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
    String answer[]={"Xylophone","Flute","Lata Mangeshkar","Canada","6","Mouth piece","Singer","Popular music","4","A tenor"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        LinearLayout li= findViewById(R.id.root);
        li.setBackgroundColor(getResources().getColor(R.color.musicbgcolor));
        Resources res = getResources();
        rg=findViewById(R.id.rg);
//      ans=findViewById(R.id.answer);
        img= findViewById(R.id.image1);
        op1 = findViewById(R.id.gkq1r1);
        op2 = findViewById(R.id.gkq1r2);
        op3 = findViewById(R.id.gkq1r3);
        op4 = findViewById(R.id.gkq1r4);
        t1 = findViewById(R.id.text1);
        arr.add(new SetQuestions(res.getString(R.string.musicq1),R.drawable.gk,"Xoane","Xylan","Xylophone","Xeric"));
        arr.add(new SetQuestions(res.getString(R.string.musicq2),R.drawable.gk,"Guitar","Piano","Flute","Trumpet"));
        arr.add(new SetQuestions(res.getString(R.string.musicq3),R.drawable.gk,"Ustad Ali Akbar Khan","Hank Marivin","Sheryl Lrow","Lata Mangeshkar"));
        arr.add(new SetQuestions(res.getString(R.string.musicq4),R.drawable.gk,"United States","Brazil","Canada","United Kingdom"));
        arr.add(new SetQuestions(res.getString(R.string.musicq5),R.drawable.gk,"6","8","7","9"));
        arr.add(new SetQuestions(res.getString(R.string.musicq6),R.drawable.gk,"Black key","Bow","Mouth piece","String"));
        arr.add(new SetQuestions(res.getString(R.string.musicq7),R.drawable.gk,"Violinist","Guitarist","Pianist","Singer"));
        arr.add(new SetQuestions(res.getString(R.string.musicq8),R.drawable.gk,"Poppy music","Popular music","Propellar music","Professional music"));
        arr.add(new SetQuestions(res.getString(R.string.musicq9),R.drawable.gk,"3","6","4","5"));
        arr.add(new SetQuestions(res.getString(R.string.musicq10),R.drawable.gk,"An Alto","A tenor","A Bass","A Pop"));

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
                Intent newActivity5 = new Intent(music.this, scorecard.class);
                newActivity5.putExtra("a",scr);
                startActivity(newActivity5);
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
