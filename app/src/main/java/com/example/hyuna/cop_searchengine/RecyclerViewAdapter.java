package com.example.hyuna.cop_searchengine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<ImageData> mItems;

    public RecyclerViewAdapter(ArrayList<ImageData> items) {
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return (null != mItems ? mItems.size() : 0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData item = mItems.get(position);
        holder.bind(item);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v=itemView;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public void bind(ImageData listItem) {
            ImageView thumbnail = v.findViewById(R.id.thumbnail);
            TextView domain = v.findViewById(R.id.domain);
            //thumbnail.setImageDrawable(listItem.getDate());
            domain.setText(listItem.getURL());

        }
    }

}
