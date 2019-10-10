package com.example.hyuna.cop_searchengine;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SearchViewActivity extends AppCompatActivity {

    private String keyword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        //dataControllerInterface = new DataSearchController(this, new ResultList(getKeyword()));

    }

    public void onClick(View v){
        // onClick
        Intent intent = new Intent(SearchViewActivity.this, ResultViewActivity.class);
        intent.putExtra("keyword", getKeyword());
        startActivity(intent);
    }

    public String getKeyword() {
        String kw= findViewById(R.id.keyword).toString();
        keyword = kw;
        return keyword;
    }
}
