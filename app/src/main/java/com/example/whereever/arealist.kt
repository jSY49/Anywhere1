package com.example.whereever

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.areatrip.*

class arealist : AppCompatActivity() {

    private val listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.areatrip)

        val spinner1 = findViewById<Spinner>(R.id.dospinner)
        val spinner2 = findViewById<Spinner>(R.id.sigunguspinner)

        //어댑터 설정_resource-array.xml에 있는 아이템 목록 추가
        spinner1.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.itemList1,
            android.R.layout.simple_spinner_item
        )

        btnback.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()

            }
        })

    }

    var url ="https://api.odcloud.kr/api/15003416/v1/uddi:a635e6c7-82cf-4714-b002-c7cf4cb20121_201609071527?serviceKey=GkxH72IrlxUiXOuSOz8x6jiRGHtpJVy7WJulZjSPj4r/8oHi2DeuiILUn6de5ODPCKkVIOnCzwoFLzz72AuXdQ==\n" +
                "&page=1&perPage=10&returnType=XML"



}