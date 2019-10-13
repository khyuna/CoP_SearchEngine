package com.example.hyuna.cop_searchengine;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 첫 화면
 * 검색어 입력 -> Search 버튼
 */
public class SearchViewActivity extends AppCompatActivity {

    private String keyword ;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        initView();//검색어 초기화
    }

    //search 버튼 눌렀을 경우
    public void onClick(View v){
        // onClick
        startResultViewActivity(); //결과 화면 그리기
    }

    /**
     * 검색 결과 나오는 화면
     */
    public void startResultViewActivity(){
        Intent intent = new Intent(this, ResultViewActivity.class);
        intent.putExtra("keyword", getKeyword());
        showLoading();
        this.startActivity(intent);
        finish();
    }

    public String getKeyword() {
        EditText kw= (EditText)findViewById(R.id.keyword);
        String kww=kw.getText().toString();
        keyword = kww;
        return keyword;
    }

    public void initView(){
        EditText kw= (EditText)findViewById(R.id.keyword);
        kw.setText("");
    }
    public void showLoading() {
        //로딩
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        progressDialog = new ProgressDialog(SearchViewActivity.this);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("로딩 중 ...");
                        progressDialog.show();
                    }
                }, 0);

    }

}
