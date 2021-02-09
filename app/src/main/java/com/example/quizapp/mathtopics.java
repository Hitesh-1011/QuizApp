package com.example.quizapp;

public class mathtopics {

    private String mTopicTitle;
    private String mTopicDescription;
    private int mImageid;



    public mathtopics(int imageid,String TopicTitle, String TopicDescription) {
        mImageid =imageid;
        mTopicTitle = TopicTitle;
        mTopicDescription = TopicDescription;
    }
    public int getimageid() {return mImageid;}
    public String getTitle() { return mTopicTitle;}
    public String getDescription() { return mTopicDescription;}

}
