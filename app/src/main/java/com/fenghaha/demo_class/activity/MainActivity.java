package com.fenghaha.demo_class.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fenghaha.demo_class.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView mBack;
    Button mButton1;
    Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
    }

    private void initView() {
        TextView title = findViewById(R.id.tv_title);
        title.setText("美女直播");
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mBack = findViewById(R.id.ic_back);
        mBack.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(MainActivity.this, DogTestActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, FragTestActivity.class));
                break;


        }
    }
}

