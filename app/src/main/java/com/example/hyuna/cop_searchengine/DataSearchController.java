package com.example.hyuna.cop_searchengine;

public class DataSearchController implements DataControllerInterface {

    private UIInterface uiInterface;
    private DataInterface dataInterface;

    DataSearchController(UIInterface uI , DataInterface dI) {
        uiInterface = uI;
        dataInterface= dI;
    }

    @Override
    public void onClickEvent(String keyword) {
        //search button눌렀을 경우의 로직
        dataInterface.setData();

        dataInterface.getAllResultData();
        uiInterface.drawImage();
    }
}
