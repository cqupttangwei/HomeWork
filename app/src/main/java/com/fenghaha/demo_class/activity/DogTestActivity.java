package com.fenghaha.demo_class.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.fenghaha.demo_class.R;
import com.fenghaha.demo_class.adapter.DogAdapter;

import java.util.ArrayList;
import java.util.Random;

public class DogTestActivity extends AppCompatActivity {
    private ArrayList<Dog> dogList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_test);
        initDogs();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DogAdapter adapter=new DogAdapter(dogList);
        recyclerView.setAdapter(adapter);
    }
    private void initDogs(){
        for (int i = 0; i <10 ; i++) {
            Dog dog1=new Dog(getRandomLengthName("旺财"),R.drawable.dog1);
            dogList.add(dog1);
            Dog dog2=new Dog(getRandomLengthName("小强"),R.drawable.dog2);
            dogList.add(dog2);
            Dog dog3=new Dog(getRandomLengthName("馒头"),R.drawable.dog3);
            dogList.add(dog3);
        }
    }
    private String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i <length ; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}