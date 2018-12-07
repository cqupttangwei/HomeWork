package com.fenghaha.demo_class.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fenghaha.demo_class.DataBean.Status;
import com.fenghaha.demo_class.R;
import com.fenghaha.demo_class.adapter.RecTestAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecTestActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecTestAdapter mAdapter;
    ImageView mBack;
    TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_test);
        initViews();
        setRec();
    }

    private void initViews() {
        mTitle = findViewById(R.id.tv_title);
        mTitle.setText("RecyclerView  TEST");
        mRecyclerView = findViewById(R.id.rec_status_list);
        mBack = findViewById(R.id.ic_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setRec() {
        mAdapter = new RecTestAdapter();
        mAdapter.setData(generateData(100));//给adapter设置数据
        mRecyclerView.setAdapter(mAdapter);//给mRecyclerView设置adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//给mRecyclerView设置LayoutManager
    }


    //xjb随机生成一个数据列表
    private List<Status> generateData(int size){
        List<Status> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Status status = new Status();
            if (i%2==0){
                status.setAuthorAvatarResId(R.drawable.nav_icon);
                status.setAuthorName("冯哈哈");
                status.setContent(getString(R.string.content1));
                status.setTitle("我是标题一");
            }

            else {
                status.setAuthorAvatarResId(R.drawable.ic_avatar);
                status.setAuthorName("fhh");
                status.setContent(getString(R.string.content2));
                status.setTitle("我是标题二");
            }
            status.setUpdateTime("更新于"+new Date().toString().substring(0,19));
            data.add(status);
        }
        return data;
    }


}
