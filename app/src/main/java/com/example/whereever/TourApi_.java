package com.example.whereever;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class TourApi_ {

    String basicUrl="http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
    String[][] arealist;
    int i;

    public TourApi_() {
        //String settingUrl="http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
    }
    public TourApi_(String wantService) {
        basicUrl += wantService + "?ServiceKey=" + BuildConfig.MY_API_KEY + "&numOfRows=1000&pageNo=1&MobileOS=ETC&MobileApp=AppTest";
    }



    String getUrl(){
        //settingUrl += wantService + "?ServiceKey=" + BuildConfig.MY_API_KEY + "&numOfRows=30&pageNo=1&MobileOS=ETC&MobileApp=AppTest";
        return basicUrl;
    }
    
    String set_tourdataList_Url(String sp1,String sp2,String srt){
        Log.d("pr_set__Url: ",basicUrl);
        if(sp2.equals("0")){
            basicUrl += "&areaCode="+sp1+"&contentTypeId=12"+"&arrange="+srt;
        }
        else{
            basicUrl += "&areaCode="+sp1+"&sigunguCode="+sp2+"&contentTypeId=12"+"&arrange="+srt;//contentTypeId 12는 관광지   arrange는 정렬
        }
        Log.d("set_tourdataList_Url: ",basicUrl);
        return basicUrl;
    }

    //+ areaCode=??&sigunguCode=??
    String[][] get_area(String newUrl){


        arealist= new String[4][1000];

        int i=0,j=0,k=0,c=0;
        //StringBuffer buffer=new StringBuffer();

        try {
            Log.d("totalCount_newUrl1: ",newUrl);
            URL url= new URL(newUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            //xml파싱
            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기
//            ListViewItem listViewItem=null;

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();
            //String evtType=String.valueOf(eventType);

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        //buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//태그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("firstimage")){
                            xpp.next();
                            arealist[0][i]=xpp.getText();
                            i++;
                        }
                        else if(tag.equals("title")){
                            xpp.next();
                            arealist[1][j]=xpp.getText();
                            j++;
                        }
                        else if(tag.equals("addr1")){
                            xpp.next();
                            arealist[2][k]=xpp.getText();
                            k++;
                        }
                        else if(tag.equals("contentid")){
                            xpp.next();
                            arealist[3][c]=xpp.getText();
                            c++;
                        }

                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //태그 이름 얻어오기

                        if(tag.equals("item")) //buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        break;

                }

                eventType= xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
            e.printStackTrace();
        }


        //return buffer.toString();//StringBuffer 문자열 객체 반환
        return arealist;
        
    }


    String set_cIddetail_Url(String cId){

        basicUrl +="&contentId="+cId+"&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";
        Log.d("cId_url",basicUrl);
        return basicUrl;
    }




}



