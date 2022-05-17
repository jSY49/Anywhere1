package com.example.whereever.fragment

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.whereever.MainActivity
import com.example.whereever.R
import com.example.whereever.firebaseConnect
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_user.*


class userFragment : Fragment()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(com.example.whereever.R.layout.fragment_user, container, false)

        val fbsconnect = firebaseConnect()
        fbsconnect.firbaseInit()

        val user = fbsconnect.fb_user()


        //로그아웃
        logoutBtn?.setOnClickListener {
            Log.v("로그아웃","로그아웃상태")
            fbsconnect.firbaseInit().signOut()

            if(user!=null){
                Toast.makeText(context, "로그아웃 성공.",Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(context, "로그아웃 실패.",Toast.LENGTH_LONG).show()
            }
        }
        // Inflate the layout for this fragment
        return view

    }



}