package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public class ResultList implements ResultListInterface {

    private ArrayList<ImageData> resultItems = new ArrayList<ImageData>();
    private ArrayList<SearchReponseItems> responseItems=new ArrayList<>();
    private String keyword ;
    private ResultViewInterface resultViewInterface;
    public ResultList (String keyword){
        //ResultList의 생성자
        this.keyword = keyword;
    }

    @Override
    public ImageData getResultData(int idx) {
        return resultItems.get(idx);
    }

    @Override
    public ArrayList<SearchReponseItems> getAllResultData() {
        String response ;
        //샘플이미지
        Thread thread= new Thread(){
            public void run(){
                network network = new network();
                try{
                    responseItems = network.connectNetwork(keyword);
                    //setData(jsonObject);
                }catch (Exception e){

                }

            }
        };

        thread.start();

        try{
            thread.join();
        }catch (Exception e){

        }

        return responseItems;
    }

    @Override
    public ArrayList<ImageData> getResultList() {
        return this.resultItems;
    }

    @Override
    public void setData() {
        //값을 멤버에 저장하는 함수
        //ImageData img1= new ImageData("ffff","dddddd", "fff",2, 3);
        //resultItems.add(0,img1 );
    }

}
