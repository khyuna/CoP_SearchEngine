package com.example.hyuna.cop_searchengine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class network {
    String clientId = "qN7B9DaacZ5g1C9PQd63";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "WkRkM1kz5V";//애플리케이션 클라이언트 시크릿값";
    public ArrayList<SearchReponseItems> connectNetwork(String keyword){
        try{
            StringBuffer sb = new StringBuffer();

            ArrayList<SearchReponseItems> searchResponseItems= new ArrayList<>();

            String text ="";
            if(keyword.equals("")){
                return null;
            }else{
                text = URLEncoder.encode(keyword, "UTF-8");
            }
            String apiURL = "https://openapi.naver.com/v1/search/image?query="+text+"&display=20&start=1";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine+"\n");
            }
            br.close();
            System.out.println(response.toString());

            String data = response.toString();
            String[] array;
            array = data.split("\"");
            String title ="";
            String thumbnail = "";
            String link ="";
            String width = "";
            String height = "";
            int k = 0;
            for (int i = 0; i < array.length; i++) {

                if (array[i].equals("title"))
                    title = array[i + 2];
                if (array[i].equals("link"))
                    link = array[i + 2];
                if (array[i].equals("thumbnail"))
                    thumbnail = array[i + 2];
                if (array[i].equals("sizeheight"))
                    height = array[i + 2];
                if (array[i].equals("sizewidth")) {
                    width = array[i + 2];
                    //값 넣기
                    SearchReponseItems responseData = new SearchReponseItems(title, link, thumbnail, width,height) ;
                    searchResponseItems.add(responseData);
                    k++;
                }
            }

            return searchResponseItems;


        }catch(Exception e){
            return null;
        }
    }

}
