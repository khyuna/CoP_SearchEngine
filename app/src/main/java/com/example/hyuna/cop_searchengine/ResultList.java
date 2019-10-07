package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public class ResultList implements DataInterface{

    private String keyword;
    private ArrayList<ImageData> resultItems = new ArrayList<ImageData>();

    @Override
    public ImageData getResultData(int idx) {
        return resultItems.get(idx);
    }

    @Override
    public ArrayList<ImageData> getAllResultData() {
        return resultItems;
    }

    @Override
    public void setData() {
        //값을 멤버에 저장하는 함수
    }
}
