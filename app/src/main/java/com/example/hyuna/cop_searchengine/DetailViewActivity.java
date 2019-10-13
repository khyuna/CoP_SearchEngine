package com.example.hyuna.cop_searchengine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import androidx.appcompat.app.AppCompatActivity;

public class DetailViewActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        Bundle bundle = getIntent().getExtras();
        final String thumbnailUrl= bundle.getString("thumbnailUrl"); //키워드 가져오기
        String title = bundle.getString("title");
        String URL = bundle.getString("link");
        String keyword = bundle.getString("keyword");

        Button back_btn = (Button)findViewById(R.id.back_button);
        back_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //뒤로 가기
                onBackPressed();
            }
        });
        Thread thread = new Thread(){
            public void run() {
                try{
                    URL url = new URL(thumbnailUrl);
                    URLConnection conn = url.openConnection();
                    conn.connect();
                    BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                    Bitmap bm = BitmapFactory.decodeStream(bis);
                    bis.close();
                    ImageView thumbnail = findViewById(R.id.thumbnail);
                    thumbnail.setImageBitmap(bm);
                }catch (Exception e){

                }
            }
        };
        thread.start();
        try {
            TextView tv = (TextView)findViewById(R.id.title);
            tv.setText("keyword = "+keyword);
            TextView tvURL = (TextView)findViewById(R.id.URL);
            tvURL.setText(URL);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
