package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public class SearchController implements SearchControllerInterface {

    private ResultViewInterface resultViewInterface;
    private ResultListInterface dataInterface;

    SearchController(ResultViewInterface uI , ResultListInterface dI) {
        resultViewInterface = uI;
        dataInterface= dI;
    }

    @Override
    public void doSearch(String keyword) {
        //search button눌렀을 경우의 로직
        //dataInterface.setData();
        try{
            if(keyword.equals("")){
                //keyword값이 null인경우
                //Toast.makeText("텍스트를 입력해주세요",Toast.LENGTH_SHORT);
            }else{
                ArrayList<SearchReponseItems> responseItems = new ArrayList<>();
                ArrayList<ImageData> imageData= new ArrayList<>();

                dataInterface = new ResultList(keyword);

                responseItems= dataInterface.getAllResultData();
                imageData= makeImageDataList(responseItems, keyword);


                resultViewInterface.drawImage(imageData);
                resultViewInterface.hideLoading();
            }

        }catch(Exception e){

        }

    }

    @Override
    public ArrayList<ImageData> makeImageDataList(ArrayList<SearchReponseItems> items, String keyword) {
        ArrayList<ImageData> imageData= new ArrayList<>();
        ImageData img ;
        if(items != null){
            for(int i=0;i<items.size();i++){
                if(items.size()==0){
                    break;
                }
                img = new ImageData(items.get(i).title,items.get(i).link, items.get(i).thumbnail, Integer.parseInt(items.get(i).sizeheight),Integer.parseInt(items.get(i).sizewidth),keyword);
                imageData.add(img);
            }
        }
        return imageData;
    }
}
