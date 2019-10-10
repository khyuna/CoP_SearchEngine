package com.example.hyuna.cop_searchengine;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ResultViewActivity extends AppCompatActivity implements  UIInterface, View.OnClickListener{

    ProgressDialog progressDialog;
    Fragment listFragment;
    Fragment tableFragment ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);
        listFragment = (ListViewFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentView);
        tableFragment = new TableViewFragment();
    }

    @Override
    public void drawImage() {

    }

    @Override
    public void drawView(int idx) {
        //fragement 변환
        //0 -> listview
        //1 -> gridview
        if(idx == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.parentView,listFragment).commit();
        } else if(idx == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.parentView,tableFragment).commit();
        }
    }

    @Override
    public void showLoading() {
            //로딩
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        progressDialog = new ProgressDialog(ResultViewActivity.this);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("로딩 중 ...");
                        progressDialog.show();
                }
        }, 0);

    }

    @Override
    public void hideLoading(){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss(); }
                        }, 0);

    }

    @Override
    public String getKeywordText() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_listview :
                //리스트뷰
                drawView(0);
                break;

            case R.id.btn_tableview:
                //그리드뷰
                drawView(1);
                break;
        }
    }
}
