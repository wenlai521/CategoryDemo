package com.example.wenlaisu.csdndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by wenlaisu on 2018/4/17.
 */
public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableList;
    private ExpandCateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableList = (ExpandableListView) findViewById(R.id.expandablelistview);

        adapter = new ExpandCateAdapter(this);
        expandableList.setAdapter(adapter);

        //使所有条目默认展开
        for(int i = 0; i < adapter.getGroupCount(); i++){
            expandableList.expandGroup(i);
        }
        //禁止group的条目点击时 收起子条目
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
    }
}
