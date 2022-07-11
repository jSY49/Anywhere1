package com.example.whereever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class areatripDetail extends Activity {

    TextView positionTv;
    int newText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_for_areatrip);

        positionTv=findViewById(R.id.id_tv);
        Intent secondIntent = getIntent();
//        secondIntent.getStringExtra("contentId","0");
        newText=secondIntent.getIntExtra("contentId",0);
        positionTv.setText(String.valueOf(newText));
//        secondIntent.getIntExtra("contentId",0);

        Log.d("postion",String.valueOf(newText));

    }

}
