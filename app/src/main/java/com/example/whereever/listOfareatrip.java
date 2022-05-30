package com.example.whereever;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listOfareatrip extends Activity {

    Button bckbtn,searchbtn;
    String sp1="1",sp2="1",srt="A";
    ArrayAdapter<CharSequence> adspin1, adspin2,adsortspin;
    String[][] arealist;

    Spinner spin1;
    Spinner spin2;
    Spinner sortspin;

    //리스트 뷰
    ListView listview ;
    ListViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.areatrip);

        bckbtn=findViewById(R.id.btnback);
        searchbtn=findViewById(R.id.Areasearch_btn);
        //text=findViewById(R.id.testTv);
        spin1 = (Spinner)findViewById(R.id.spinner1);
        spin2 = (Spinner)findViewById(R.id.spinner2);
        sortspin = (Spinner)findViewById(R.id.sortspinenr);
        arealist= new String[3][30];



        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        

        adspin1 = ArrayAdapter.createFromResource(this, R.array.firstSelect, android.R.layout.simple_spinner_dropdown_item);//R.layout.simple_~~~는 안드로이드에서 기본제공하는 spinner 모양
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);

        adsortspin = ArrayAdapter.createFromResource(this, R.array.sort_list, android.R.layout.simple_spinner_dropdown_item);
        adsortspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortspin.setAdapter(adsortspin);


       // runthread();

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//int i는 spinner에서 몇번째걸 선택했는지

                scndSpinner(i);
                //sp1= (String) adspin1.getItem(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sp2= String.valueOf(i+1);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        sortspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adsortspin.getItem(i).equals("제목순")){
                    srt="A";
                }
                else if(adsortspin.getItem(i).equals("조회순")){
                    srt="B";
                }
                else if(adsortspin.getItem(i).equals("수정일순")){
                    srt="C";
                }
                else if(adsortspin.getItem(i).equals("생성일순")){
                    srt="D";
                }
                runthread();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;

        //검색 버튼
        searchbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                runthread();

            }
        });


        //뒤로가기 버튼
        bckbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();

            }
        });

        //리스트뷰 클릭 했을 때
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // TODO : use item data.
            }
        }) ;

    }
    public void runthread(){

        TourApi_ tourapi=new TourApi_("areaBasedList");
        tourapi.set_tourdataList_Url(sp1,sp2,srt);
        String get_Url=tourapi.getUrl();



        Log.d("set_tourdataList_getURL",get_Url);
        adapter.clearAll(); //리스트 뷰를 모두 지우는 함수 호출


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                arealist= tourapi.get_area(get_Url,sp1,sp2);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        //아이템 추가.

                        for(int i=0;i<30;i++){
                            adapter.addItem(new ListViewItem(arealist[0][i],arealist[1][i],arealist[2][i])) ;
                        }
                        listview.setAdapter(adapter);


                        //페이지 이동 버튼


                    }
                });

            }
        }).start();
    }


    public void scndSpinner(int i){

        int whichone=R.array.second_seoul;  //기본
        
        switch(i){
            case 0:
                whichone=R.array.second_seoul;
                sp1="1";
                break;
            case 1:
                whichone=R.array.second_incheon;
                sp1="2";
                break;
            case 2:
                whichone=R.array.second_daejeon;
                sp1="3";
                break;
            case 3:
                whichone=R.array.second_daegu;
                sp1="4";
                break;
            case 4:
                whichone=R.array.second_guangju;
                sp1="5";
                break;
            case 5:
                whichone=R.array.second_busan;
                sp1="6";
                break;
            case 6:
                whichone=R.array.second_ulsan;
                sp1="7";
                break;
            case 7:
                whichone=R.array.second_sejong;
                sp1="8";
                break;
            case 8:
                whichone=R.array.second_geonggi;
                sp1="31";
                break;
            case 9:
                whichone=R.array.second_gangwon;
                sp1="32";
                break;
            case 10:
                whichone=R.array.second_chungbuk;
                sp1="33";
                break;
            case 11:
                whichone=R.array.second_chungnam;
                sp1="34";
                break;
            case 12:
                whichone=R.array.second_gyeongbuk;
                sp1="35";
                break;
            case 13:
                whichone=R.array.second_gyeongnam;
                sp1="36";
                break;
            case 14:
                whichone=R.array.second_jeonbuk;
                sp1="37";
                break;
            case 15:
                whichone=R.array.second_jeonnam;
                sp1="38";
                break;
            case 16:
                whichone=R.array.second_jeju;
                sp1="39";
                break;
        }

        adspin2 = ArrayAdapter.createFromResource(listOfareatrip.this,whichone, android.R.layout.simple_spinner_dropdown_item);
        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adspin2);


    }



}

/*
JDK에서 지원하는 java.lang.Thread 제공


<Thread 생성자>
 Thread()
 Thread(String s) 스레드 이름
 Thread(Runnable r) 인터페이스 객체        //메소드 run만 정의되어 있음
 Thread(Runnable r, String s) 인터페이스 객체와 스레드 이름

<Thread 메소드>
 static void sleep(long msec) throws Interrupted Exception  msec에 지정된 밀리초 동안 대기
 String getName() 스레드의 이름을 s로 설정
 void setName(String s) 스레드의 이름을 s로 설정
 void start() 스레드를 시작 run() 메소드 호출
 int getPriority()  스레드의 우선 순위를 반환
 void setpriority(int p) 스레드의 우선순위를 p값으로
 boolean isAlive() 스레드가 시작되었고 아직 끝나지 않았으면 true 끝났으면 false 반환
 void join() throws InterruptedException 스레드가 끝날 때 까지 대기
 void run() 스레드가 실행할 부분 기술 (오버라이딩 사용)
 void suspend() 스레드가 일시정지 resume()에 의해 다시시작 할 수 있다.
 void resume() 일시 정지된 스레드를 다시 시작.
 void yield() 다른 스레드에게 실행 상태를 양보하고 자신은 준비 상태로
 */