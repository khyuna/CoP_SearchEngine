package com.example.hyuna.cop_searchengine;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchViewActivity extends AppCompatActivity implements UIInterface {

    private DataControllerInterface dataControllerInterface;
    private String keyword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        dataControllerInterface = new DataSearchController(this, new ResultList(getKeyword()));

    }

    @Override
    public void drawImage() {

    }

    @Override
    public void drawView() {

    }

    @Override
    public void showLoading() {

    }

    public void onClick(View v){
        // onClick
        dataControllerInterface.onClickEvent("keyword");
    }

    @Override
    public String getKeywordText() {
        //키워드
        EditText keywordTv = (EditText) findViewById(R.id.keyword);
        keyword = keywordTv.getText().toString();
        return keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
