package com.khushi.win10.cottageclaiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PropertyNewsActivity extends AppCompatActivity {
ListView listViewnews;

    String title[];
    String content[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_news);


//        getActionBar().setDisplayHomeAsUpEnabled(true);
     // getSupportActionBar().setDisplayShowCustomEnabled(true);


        title=getResources().getStringArray(R.array.name);
        content=getResources().getStringArray(R.array.location);

        listViewnews=(ListView)findViewById(R.id.list_news);

        ObjectHolder.newsModel=new ArrayList<>();

        NewsModel model2=new NewsModel();
        model2.setTitle("Property News");
        model2.setContent("This is a Property news Activity");

        ObjectHolder.newsModel.add(model2);

        CustomNewsAdapter newsAdapter = new CustomNewsAdapter(this,ObjectHolder.newsModel);
        listViewnews.setAdapter(newsAdapter);
    }
}
