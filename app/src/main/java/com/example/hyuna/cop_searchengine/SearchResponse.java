package com.example.hyuna.cop_searchengine;

import java.util.ArrayList;

public class SearchResponse {
    String clientId = "qN7B9DaacZ5g1C9PQd63";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "WkRkM1kz5V";//애플리케이션 클라이언트 시크릿값";
    String lastBuildDate ;
    int total ;
    int display ;
    ArrayList<SearchReponseItems> searchResponseItems;

    public SearchResponse(ArrayList<SearchReponseItems> items, int total){
        this.total=total;
        searchResponseItems = items;
    }

}
