package com.example.hyuna.cop_searchengine;

public class SearchReponseItems {
    public String title;
    public String thumbnail;
    public String link ;
    public String sizeheight;
    public String sizewidth;

    public SearchReponseItems(String title, String thumbnail, String link, String sizeheight, String sizewidth){
        this.title=title;
        this.link=link;
        this.thumbnail = thumbnail;
        this.sizeheight= sizeheight;
        this.sizewidth=sizewidth;
    }
}
