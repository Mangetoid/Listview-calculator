package com.example.calculatoralpha2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] title;
    private final String[] sub;

    public MyListAdapter(Activity context,String[] title,String[] sub){
        super(context,R.layout.custom_listview,title);
        this.context = context;
        this.title = title;
        this.sub = sub;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_listview,null,true);

        TextView title_text = (TextView)rowView.findViewById(R.id.text1);
        TextView subtext = (TextView)rowView.findViewById(R.id.text2);

        title_text.setText(title[position]);
        subtext.setText(sub[position]);
        return rowView;
    }
}
