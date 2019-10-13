package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public interface ResultViewInterface {
    //이미지 그리기
    public void drawImage(ArrayList<ImageData> resultList);
    //뷰 그리기
    public void drawView(int idx);

    //로딩화면
    public void showLoading();
    public void hideLoading();


    public String getKeywordText();
    public void showMessage(String message);

}
