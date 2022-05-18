package com.example.whereever

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.loginmenu.*


class loginMenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginmenu)


        //이메일로 로그인하기 버튼 클릭
        emailsignbtn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                finish()
                val intent = Intent(baseContext, emaillogin::class.java)
                startActivity(intent)


            }
        })
    }
}