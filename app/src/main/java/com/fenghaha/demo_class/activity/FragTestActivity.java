package com.fenghaha.demo_class.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fenghaha.demo_class.R;
import com.fenghaha.demo_class.fragment.SimpleFragment;


public class FragTestActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    SimpleFragment[] mSimpleFragments;
    int[] imageIds = {R.drawable.zs, R.drawable.ls, R.drawable.qx, R.drawable.hsj};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_test);

        initViews();
        initFragments();
    }


    private void initViews() {
        setTitle();
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void initFragments() {
        mSimpleFragments = new SimpleFragment[4];
        for (int i = 0; i < 4; i++) {
            SimpleFragment fragment = new SimpleFragment();
            fragment.setData(imageIds[i], "我是第" + (i+1) + "个Fragment！");
            mSimpleFragments[i] = fragment;
        }
    }


    private void chooseFragment(int newIndex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lay_fragment_container, mSimpleFragments[newIndex]);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                chooseFragment(0);
                break;
            case R.id.btn_2:
                chooseFragment(1);
                break;
            case R.id.btn_3:
                chooseFragment(2);
                break;
            case R.id.btn_4:
                chooseFragment(3);
                break;
        }
    }
    private void setTitle() {
        TextView title = findViewById(R.id.tv_title);
        title.setText("Fragment Test");
        ImageView mBack = findViewById(R.id.ic_back);
        mBack.setOnClickListener(v -> finish());
    }
}
