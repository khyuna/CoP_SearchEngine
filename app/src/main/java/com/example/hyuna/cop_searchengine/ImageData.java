package com.example.hyuna.cop_searchengine;

public class ImageData {
    private String title;
    private String link ;
    private String thumbnail;
    private int width ;
    private int height;
    private String keyword;

    public void setTitle(String title){
        this.title=title;
    }
    public void setLink(String link){this.link = link;}

    public void setThumbnail(String thumbnail){
        this.thumbnail=thumbnail;
    }

    public String getTitle(){
        return this.title;
    }
    public String getLink(){return this.link;}
    public String getKeyword(){return this.keyword;}

    public String getThumbnail(){
        return this.thumbnail;
    }

    public ImageData(String title, String link, String thumbnail, int width , int height, String keyword){
        this.title = title;
        this.link = link;
        this.thumbnail = thumbnail;
        this.width = width;
        this.height = height;
        this.keyword=keyword;
    }
}
