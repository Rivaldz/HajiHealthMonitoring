package com.valdo.hajihealthmonitoring.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.valdo.hajihealthmonitoring.R;
import com.valdo.hajihealthmonitoring.model.ExpeandAbleListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuResep extends AppCompatActivity {

    ExpeandAbleListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String>chapterList;
    HashMap<String, List<String>>topicsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_resep);
        expandableListView = findViewById(R.id.listView);

        showlist();

        listViewAdapter = new ExpeandAbleListViewAdapter(this, chapterList, topicsList);
        expandableListView.setAdapter(listViewAdapter);
   }

    private void showlist() {
        chapterList = new ArrayList<String>();
        topicsList = new HashMap<String, List<String>>();

        chapterList.add("Chapter 1");
        chapterList.add("Chapter 2");
        chapterList.add("Chapter 3");


        List<String> topic1 = new ArrayList<>();
        topic1.add("ini topic 1");
        topic1.add("ini topic 2");
        topic1.add("ini topic 2");


        List<String> topic2 = new ArrayList<>();
        topic2.add("ini topic 1");
        topic2.add("ini topic 2");
        topic2.add("ini topic 2");

        List<String> topic3 = new ArrayList<>();
        topic3.add("ini topic 1");
        topic3.add("ini topic 2");
        topic3.add("ini topic 2");

        topicsList.put(chapterList.get(0),topic1);
        topicsList.put(chapterList.get(1),topic2);
        topicsList.put(chapterList.get(2),topic3);
    }
}
