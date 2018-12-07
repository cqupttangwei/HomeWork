package com.fenghaha.demo_class.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fenghaha.demo_class.DataBean.Status;
import com.fenghaha.demo_class.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FengHaHa on2018/12/7 0007 21:02
 */
public class RecTestAdapter extends RecyclerView.Adapter<RecTestAdapter.MyViewHolder> {

    private List<Status> mDataList = new ArrayList<>();

//    //构造函数直接传入数据  不推荐
//    public RecTestAdapter(List<String> data) {
//        this.mDataList = data;
//    }

    //添加新的数据
    public void addNewData(List<Status> dataList) {
        mDataList.addAll(dataList);//把新数据加入原列表
        notifyDataSetChanged();//告诉RecyclerView： 我数据更新了 赶快重新绘制！
    }

    //直接设置数据
    public void setData(List<Status> dataList) {
        mDataList.clear();//清空原来的数据
        mDataList.addAll(dataList);//把新数据加入原列表
        notifyDataSetChanged();//告诉RecyclerView： 数据更新了
    }

    @NonNull
    @Override
    //为每个 单位布局 创建ViewHolder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_status_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        Status status = mDataList.get(i);
        viewHolder.authorAvatar.setImageResource(status.getAuthorAvatarResId());
        viewHolder.authorName.setText(status.getAuthorName());
        viewHolder.title.setText(status.getTitle());
        viewHolder.content.setText(status.getContent());
        viewHolder.updateTime.setText(status.getUpdateTime());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View itemRootView;
        ImageView authorAvatar;
        TextView authorName;
        TextView title;
        TextView content;
        TextView updateTime;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRootView = itemView;
            authorAvatar = itemView.findViewById(R.id.iv_avatar);
            authorName = itemView.findViewById(R.id.tv_status_author_name);
            title = itemView.findViewById(R.id.tv_status_title);
            content = itemView.findViewById(R.id.tv_status_content);
            updateTime = itemView.findViewById(R.id.tv_question_update_time);
        }
    }
}
