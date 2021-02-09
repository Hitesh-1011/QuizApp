package com.example.quizapp;

public class SetQuestions
{
    private String question;
    private int image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    public SetQuestions(String ques,int imgid, String op1, String op2, String op3, String op4)
    {
        question=ques;
        image=imgid;
        option1=op1;
        option2=op2;
        option3=op3;
        option4=op4;
    }
    public String getQues() {return question;}
    public int getimg() {return image;}
    public String getOp1() { return option1;}
    public String getOp2() { return option2;}
    public String getOp3() { return option3;}
    public String getOp4() { return option4;}
}
