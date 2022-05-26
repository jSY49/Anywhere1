package com.example.whereever

import android.view.View
import android.widget.TextView
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStreamReader
import java.net.URL
import kotlinx.android.synthetic.main.areatrip.*
import org.json.JSONObject
import java.io.BufferedReader

class TourApi {

//
//
//    fun ApiUrl(wantService: String):String {
//
//        val url =
//            "http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + wantService + "?ServiceKey=" + BuildConfig.MY_API_KEY + "&numOfRows=17&pageNo=1&MobileOS=ETC&MobileApp=AppTest"
//
//        return url
//    }
//
//
//
//
//    //테스트용
//    fun TestgetXmlData(): String? {
//        var buffer = StringBuffer()
//
//        try {
//            val url = URL(ApiUrl("areaCode")) //문자열로 된 요청 url을 URL 객체로 생성.
//            //val input_str = url.openStream() //url위치로 입력스트림 연결
//
//            //테스트용 추가
//            val conn = url.openConnection()
//            val input = conn.getInputStream()
//            val isr = InputStreamReader(input)
//            // br: 라인 단위로 데이터를 읽어오기 위해서 만듦
//            val br = BufferedReader(isr)
//
//
//            // Json 문서는 일단 문자열로 데이터를 모두 읽어온 후, Json에 관련된 객체를 만들어서 데이터를 가져옴
//            var str: String? = null
//            val buf = StringBuffer()
//
//            do{
//                str = br.readLine()
//
//                if(str!=null){
//                    buf.append(str)
//                }
//            }while (str!=null)
//
//
//            // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
//            val root = JSONObject(buf.toString())
//            val response = root.getJSONObject("response").getJSONObject("body").getJSONObject("items")
//            val item = response.getJSONArray("name") // 객체 안에 있는 item이라는 이름의 리스트를 가져옴
//
//
////            lateinit var tag :String
////
////            //xml파싱
////            var factory = XmlPullParserFactory.newInstance()
////            var xpp = factory.newPullParser()
////            xpp.setInput(InputStreamReader(input_str, "UTF-8")) //inputstream 으로부터 xml 입력받기
////
////            xpp.next()
////            var eventType = xpp.eventType
////            while (eventType != XmlPullParser.END_DOCUMENT) {
////                when (eventType) {
////                    XmlPullParser.START_DOCUMENT -> buffer.append("파싱 시작...\n\n")
////                    XmlPullParser.START_TAG -> {
////                        tag = xpp.name //태그 이름 얻어오기
////                        if (tag == "item") ;
////                        else if (tag == "name") {
////                            buffer.append("name : ")
////                            xpp.next()
////                            buffer.append(xpp.text) //addr 요소의 TEXT 읽어와서 문자열버퍼에 추가
////                            buffer.append("\n") //줄바꿈 문자 추가
////                        }
////                    }
////                    XmlPullParser.TEXT -> {
////                    }
////                    XmlPullParser.END_TAG -> {
////                        tag = xpp.name //태그 이름 얻어오기
////                        if (tag == "item") buffer.append("\n") // 첫번째 검색결과종료..줄바꿈
////                    }
////                }
////                eventType = xpp.next()
////            }
//
//        }catch (e:Exception) {
//            // TODO Auto-generated catch blocke.printStackTrace();
//        }
//
//
//        return buffer.toString() //StringBuffer 문자열 객체 반환
//
//    }

}