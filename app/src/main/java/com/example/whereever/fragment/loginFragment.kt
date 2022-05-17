package com.example.whereever.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.whereever.arealist
import com.example.whereever.emaillogin
import com.example.whereever.wheatherIsClean
import com.google.firebase.auth.FirebaseAuth


class loginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(com.example.whereever.R.layout.fragment_login, container, false)
        val emailLoginBtn=view.findViewById<Button>(com.example.whereever.R.id.emailsignbtn)

        //이메일로 로그인하기 버튼 클릭
        emailLoginBtn?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {

                val intent = Intent(getActivity(), emaillogin::class.java)
                startActivity(intent)

            }
        })




        return view


    }
/*
    private fun loginUser(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        moveMainPage(auth?.currentUser)
                    } else {
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }
*/



}