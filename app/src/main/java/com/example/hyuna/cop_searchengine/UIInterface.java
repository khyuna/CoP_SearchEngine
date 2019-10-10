package com.example.hyuna.cop_searchengine;

public interface UIInterface {
    //이미지 그리기
    public void drawImage();
    //뷰 그리기
    public void drawView(int idx);

    //로딩화면
    public void showLoading();
    public void hideLoading();

    public String getKeywordText();


}
