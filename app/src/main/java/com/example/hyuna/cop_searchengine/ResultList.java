package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public class ResultList implements DataInterface {

    private String keyword;
    private ArrayList<ImageData> resultItems = new ArrayList<ImageData>();

    public ResultList (String keyword){
        //ResultList의 생성자
        this.keyword = keyword;
    }

    @Override
    public ImageData getResultData(int idx) {
        return resultItems.get(idx);
    }

    @Override
    public ArrayList<ImageData> getAllResultData() {
        //샘플이미지

        return resultItems;
    }

    @Override
    public void setData() {
        //값을 멤버에 저장하는 함수
        ImageData img1= new ImageData("ffff","dddddd", 2, 3);
        resultItems.add(0,img1 );
    }

}
