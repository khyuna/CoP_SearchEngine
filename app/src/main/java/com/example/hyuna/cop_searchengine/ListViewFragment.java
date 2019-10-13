package com.example.hyuna.cop_searchengine;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewFragment extends Fragment {
    public static RecyclerView rv = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View listViewFragment = inflater.inflate(R.layout.fragment_list_view, container, false);
        rv = listViewFragment.findViewById(R.id.list_view);

       // RecyclerViewAdapter recycleViewAdapter = new RecyclerViewAdapter(list);

        //rv.setAdapter(recycleViewAdapter);

        //선 넣기
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);

        return listViewFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if((getActivity() !=null) &&(getActivity() instanceof ResultViewActivity) ){

        }

    }
}
