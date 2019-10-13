package com.example.hyuna.cop_searchengine;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/***
 * 리스트 형 - 테이블 형으로 보여주기 위한 recyclerViewAdapter
 *
 */
public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<ImageData> mItems;
    private int mviewType;
    private int VIEW_TYPE_LIST = 0; //리스트형
    private int VIEW_TYPE_TABLE = 1;//테이블형(그리드형)

    public RecyclerViewAdapter(ArrayList<ImageData> items, int viewType) {
        mItems = items;
        this.mviewType = viewType;
    }

    @Override
    public int getItemCount() {
        return (null != mItems ? mItems.size() : 0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View v ;
        if(mviewType == VIEW_TYPE_LIST){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }else {
           v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteem_grid, parent, false);
        }
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData item = mItems.get(position);

        holder.bind(item);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private View v;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            v=itemView;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public void bind(final ImageData listItem) {
            View view ;

            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailViewActivity.class);
                    intent.putExtra("thumbnailUrl", listItem.getThumbnail());
                    intent.putExtra("link", listItem.getLink());
                    intent.putExtra("title", listItem.getTitle());
                    intent.putExtra("keyword",listItem.getKeyword());
                    v.getContext().startActivity(intent);
                }
            });

            final ImageData imageData= listItem;
            if(mviewType==VIEW_TYPE_LIST){
                TextView domain = v.findViewById(R.id.domain);
                //thumbnail.setImageDrawable(listItem.getDate());

                domain.setText(listItem.getLink());
            }
            ImageView thumbnail = v.findViewById(R.id.thumbnail);
            Glide.with(v).load(listItem.getThumbnail()).into(thumbnail);
//
//
//
//                Thread thread = new Thread(){
//                    public void run() {
//                        try{
//                            URL url = new URL(imageData.getThumbnail());
//                            URLConnection conn = url.openConnection();
//                            conn.connect();
//                            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
//                            Bitmap bm = BitmapFactory.decodeStream(bis);
//                            bis.close();
//                            ImageView thumbnail = v.findViewById(R.id.thumbnail);
//                            thumbnail.setImageBitmap(bm);
//                        }catch (Exception e){
//
//                        }
//                    }
//                };
//                thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }
    }

}
