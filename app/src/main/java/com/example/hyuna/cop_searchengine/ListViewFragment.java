package com.example.hyuna.cop_searchengine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListViewFragment extends Fragment implements UIInterface{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View listViewFragment = inflater.inflate(R.layout.fragment_list_view, container, false);

        return listViewFragment;
    }


    @Override
    public void drawImage(){
        //RecyclerViewAdapter recycleViewAdapter = new RecyclerViewAdapter(list);
        //RecyclerView rv = listViewFragment.findViewById(R.id.list_view);
       // rv.setAdapter(recycleViewAdapter);
    }

    @Override
    public void drawView() {
        //뷰 그리기
    }

    @Override
    public void showLoading() {

    }
}
