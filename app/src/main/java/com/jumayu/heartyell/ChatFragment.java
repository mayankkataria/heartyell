 package com.jumayu.heartyell;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    List<Integer> randomNum;
    List<Integer> randomImg;
    RandomChatAdapter adapter;
    RecyclerView chatRv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View chatView = inflater.inflate(R.layout.fragment_chat, container, false);
        FloatingActionButton fabBtn = chatView.findViewById(R.id.fab_btn);
        fabBtn.setOnClickListener(fabListener);
        randomNum = new ArrayList<>();
        randomImg = new ArrayList<>();
        chatRv = chatView.findViewById(R.id.chat_rv);
        chatRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RandomChatAdapter(randomNum, randomImg);
        chatRv.setAdapter(adapter);
        return chatView;
    }

    private FloatingActionButton.OnClickListener fabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adapter.addItem(0);
            chatRv.scrollToPosition(0);
        }
    };
}
