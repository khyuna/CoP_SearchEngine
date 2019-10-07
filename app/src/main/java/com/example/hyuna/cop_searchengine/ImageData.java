package com.example.hyuna.cop_searchengine;

public class ImageData {
    private String URL;
    private String thumbnail;
    private int width ;
    private int height;

    public void setURL(String url){
        this.URL=url;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail=thumbnail;
    }

    public String getURL(){
        return this.URL;
    }

    public String getThumbnail(){
        return this.thumbnail;
    }

    public ImageData(String URL, String thumbnail, int width , int height){
        this.URL = URL;
        this.thumbnail = thumbnail;
        this.width = width;
        this.height = height;
    }
}
