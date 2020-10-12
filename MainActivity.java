package com.example.calculatoralpha2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.calculatoralpha2.R;

public class MainActivity extends AppCompatActivity {
    String[] Header = {"Calculator", "How to use", "Profile"};
    String [] trailer = {"Calculator program version 1.0", "Detail of Calculator program", "Developrt information"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.simpleListView);

        MyListAdapter adapter = new MyListAdapter(this,Header,trailer);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), My_calculator.class);
                    startActivity(intent);
                }

                if (i == 1) {
                    Intent intent = new Intent(view.getContext(), How_to_use.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), My_profile.class);
                    startActivity(intent);
                }
            } });

    }}
