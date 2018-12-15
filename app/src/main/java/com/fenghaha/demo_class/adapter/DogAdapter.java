package com.fenghaha.demo_class.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fenghaha.demo_class.R;
import com.fenghaha.demo_class.activity.Dog;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {
    private List<Dog> mDogList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.dogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Dog dog = mDogList.get(position);
                Toast.makeText(v.getContext(), "吃屎了你", Toast.LENGTH_SHORT).show();

            }
        });
        holder.dogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Dog dog = mDogList.get(position);
                Toast.makeText(v.getContext(), "你购买了" + dog.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Dog dog=mDogList.get(position);
        holder.dogImage.setImageResource(dog.getImageId());
        holder.dogName.setText(dog.getName());

    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View dogView;
        ImageView dogImage;
        TextView dogName;
        public ViewHolder(View view){
            super(view);
            dogView=view;
            dogImage=(ImageView)view.findViewById(R.id.dog_image);
            dogName=(TextView)view.findViewById(R.id.dog_name);
        }
    }
    public DogAdapter(List<Dog> dogList){
        mDogList=dogList;
    }

}

