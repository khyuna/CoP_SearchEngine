package com.example.hyuna.cop_searchengine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ResultViewActivity extends AppCompatActivity implements  UIInterface, View.OnClickListener{
    ViewPager viewPager = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);
        viewPager= (ViewPager)findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
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

    @Override
    public String getKeywordText() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_listview :
                viewPager.setCurrentItem(0);
                break;

            case R.id.btn_tableview:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
