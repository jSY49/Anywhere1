package com.example.whereever

import android.app.PendingIntent.getActivity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.whereever.fragment.userFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.email_sign_in.*
import kotlinx.android.synthetic.main.email_sign_up.*


class emaillogin : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_sign_in)

        //이메일 로그인
        loginButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                var email = edtID.text.toString().trim()
                var password = edtPW.text.toString().trim()

                loginuser(email,password)

                //userFragment로 변경

            }
        })


        //이메일 가입하기
        emailmakebtn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val intent = Intent(applicationContext, emailsignupActivity::class.java)
                startActivity(intent)

            }
        })

    }


    private fun loginuser(email: String, password: String) {
        val fbsconnect = firebaseConnect()
        fbsconnect.firbaseInit()
        var task = fbsconnect.fb_email_login(email, password)


        task.addOnCompleteListener(this) {task->
                if (task.isSuccessful) {
                    Log.d(ContentValues.TAG, "LoginUserWithEmail:success")
                    //val user = auth.currentUser
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                    finish()




                } else {
                    Log.w(ContentValues.TAG, "LoginUserWithEmail:failure", task.exception)
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
                }
            }
            task.addOnFailureListener {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
            }
    }
}