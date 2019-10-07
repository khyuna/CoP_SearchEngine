package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public interface DataInterface {
    //데이터 단순 get / set하는 인터페이스
    
    //데이터 가져오기 - 단건
    public ImageData getResultData(int idx);

    //데이터 가져오기 - 전체
    public ArrayList<ImageData> getAllResultData();

    //데이터 셋팅하기
    public void setData();

}
