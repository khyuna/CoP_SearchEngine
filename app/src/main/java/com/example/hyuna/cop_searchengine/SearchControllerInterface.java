package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public interface SearchControllerInterface {
    public void doSearch(String keyword);
    public ArrayList<ImageData> makeImageDataList(ArrayList<SearchReponseItems> items, String keyword);
}
