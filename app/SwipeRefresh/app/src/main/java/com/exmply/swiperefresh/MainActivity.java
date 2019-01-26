package com.exmply.swiperefresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swiperereshlayout;
    private ListView listview;
    private ArrayAdapter<String> adapter;
    private List<String> data;

//尝试给listview每个列表添加图片
//    private List<ImageListArray> wiefList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG) .setAction("Action", null).show();
            }
        });
        initView();//初始化列表界面以及列表数据
    }


    private void initView (){

        swiperereshlayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        listview = (ListView) findViewById(R.id.listview);
        data = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            data.add("当前的item为 " + i);
        }
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);


        swiperereshlayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        //给swipeRefreshLayout绑定刷新监听
        swiperereshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //设置2秒的时间来执行以下事件
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        //头插法
                        data.add(0, "我是刷新后新增的item");
                        adapter.notifyDataSetChanged();
                        swiperereshlayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

}