package com.jumayu.heartyell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RandomChatAdapter extends RecyclerView.Adapter <RandomChatAdapter.RandomChatViewHolder> {
    List<Integer> randomNum, randomImg;
    public RandomChatAdapter(List<Integer> randomNum, List<Integer> randomImg) {
        this.randomNum = randomNum;
        this.randomImg = randomImg;
    }

    public static class RandomChatViewHolder extends RecyclerView.ViewHolder {
        public ImageView randomImgView;
        public TextView randomNumView;
        public RandomChatViewHolder(@NonNull View itemView) {
            super(itemView);
            randomImgView = itemView.findViewById(R.id.random_dp);
            randomNumView = itemView.findViewById(R.id.random_num);
        }
    }

    @NonNull
    @Override
    public RandomChatAdapter.RandomChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.chat_list_item, parent, false);
        RandomChatViewHolder viewHolder = new RandomChatViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomChatViewHolder holder, int position) {
        holder.randomNumView.setText((randomNum.get(position))+"");
        holder.randomImgView.setImageResource(randomImg.get(position));
    }

    @Override
    public int getItemCount() {
        return randomNum.size();
    }

    public void addItem(int position) {
        randomImg.add(0, R.drawable.ic_tag_faces_black_24dp);
        randomNum.add(0, randomNum.size()+1);
        notifyItemInserted(0);

    }


}
