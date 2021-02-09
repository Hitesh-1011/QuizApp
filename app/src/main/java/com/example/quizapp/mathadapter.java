package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mathadapter extends  ArrayAdapter<mathtopics>{

    public mathadapter(Context context, ArrayList<mathtopics> topics) {
        super (context, 0, topics);
    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView ==null) {
            listitemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        mathtopics currentInformation = getItem(position);

        TextView titleTextView = (TextView) listitemView.findViewById(R.id.topic);
        titleTextView.setText(currentInformation.getTitle());

        TextView subTitleTextView = (TextView) listitemView.findViewById(R.id.description);
        subTitleTextView.setText(currentInformation.getDescription());


        ImageView initialimage = (ImageView) listitemView.findViewById(R.id.image);
        initialimage.setImageResource(currentInformation.getimageid());

        return listitemView;

    }
}
