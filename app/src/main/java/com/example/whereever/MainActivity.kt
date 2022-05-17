package com.example.whereever

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.whereever.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_user.*

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fram1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fbsconnect = firebaseConnect()
        fbsconnect.firbaseInit()

        val btmNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        btmNav.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.nav1 -> {
                        MainFragment()
                    }
                    R.id.nav2 -> {
                        BookFragment()
                    }
                    R.id.nav3 -> {
                        mapFragment()
                    }
                    R.id.nav4 -> {
                        searchFragment()
                    }
                    else -> {
                        //userFragment()
                        if(fbsconnect.fb_user()!=null){
                            userFragment()
                            //profileNm.setText(fbsconnect.fb_userEmail())
                        } else {
                            loginFragment()
                        }


                    }
                }
            )
            true
        }
        //앱 첫 실행시 열리는 메뉴
        btmNav.selectedItemId = R.id.nav1




    }

    //액티비티에 fragment띄우기
     fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fram1, fragment)
            .commit()
    }


}


/*
  createUserWithEmailAndPassword  회원가입
   signlnWithEmailAndPassword  로그인
  sendEmailVerification  회원 가입한 이메일 유효 확인
   updateEmail 회원 가입한 아이디 이메일 변경
  updatePassword  회원 가입한 아이디 패스워드 변경
  sendPasswordResetEmail  회원 가입한 비밀번호 재설정
  delete  회원 가입한 아이디 삭제
  reauthenticate  아이디 재 인증
 */