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

public class history extends AppCompatActivity {
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
        Intent i=new Intent(history.this,MainActivity.class);
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
    String answer[]={"Before Christ","55 BC","B/W 629-645 AD","Surat","28","Alexander","Dashpur Inscription","Sultan Mahmood I","15th August 1947","Avanti"};
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
        arr.add(new SetQuestions(res.getString(R.string.histq1),R.drawable.gk,"Birth of Christ","Baby Christ","Before Christ","Before Century"));
        arr.add(new SetQuestions(res.getString(R.string.histq2),R.drawable.gk,"47 BC","50 BC","55 BC","57 BC"));
        arr.add(new SetQuestions(res.getString(R.string.histq3),R.drawable.gk,"B/W 712-713 AD","B/W 629-645 AD","B/W 413-418 AD","B/W 380-413 AD"));
        arr.add(new SetQuestions(res.getString(R.string.histq4),R.drawable.gk,"Surat","Kerala","Ahmedabad","Malarka"));
        arr.add(new SetQuestions(res.getString(R.string.histq5),R.drawable.gk,"26","28","27","29"));
        arr.add(new SetQuestions(res.getString(R.string.histq6),R.drawable.gk,"Axendar","Arabs","Greek","Iranian"));
        arr.add(new SetQuestions(res.getString(R.string.histq7),R.drawable.gk,"Prayag Inscription","Dashpur Inscription","Iran Inscription","Hathigumpha Inscription"));
        arr.add(new SetQuestions(res.getString(R.string.histq8),R.drawable.gk,"Ahmad Shah I","Sultan Mahmood II","Sikander Shah","Sultan Mahmood I"));
        arr.add(new SetQuestions(res.getString(R.string.histq9),R.drawable.gk,"26th August 1947","26th January 1947","15th January 1947","15th August 1947"));
        arr.add(new SetQuestions(res.getString(R.string.histq10),R.drawable.gk,"kasi","Anga","Avanti","Vajji"));

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
                Intent newActivity3 = new Intent(history.this, scorecard.class);
                newActivity3.putExtra("a",scr);
                startActivity(newActivity3);
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
