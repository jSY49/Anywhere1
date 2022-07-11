package com.example.whereever

import android.app.Instrumentation
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.android.gms.auth.api.credentials.IdToken
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.android.synthetic.main.loginmenu.*
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider


class loginMenuActivity : AppCompatActivity() {

    val fbsconnect = firebaseConnect()
    private val mGoogleSignInClient: GoogleSignInClient? = null
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginmenu)

        fbsconnect.firbaseInit()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        var googleSignInClient =GoogleSignIn.getClient(this,gso)


        //이메일로 로그인하기 버튼 클릭
        emailsignbtn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                finish()
                val intent = Intent(baseContext, emaillogin::class.java)
                startActivity(intent)


            }
        })

//        //구글로 로그인 하기
//        btn_googleSignIn?.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                val signInIntent = googleSignInClient.signInIntent
//                startForResult.launch(signInIntent)
//
//
//            }
//
//        })
    }

//    private val startForResult = registerForActivityResult(ActivityResultContract.StartActivityForResult()){
//        result: ActivityResult ->
//        if(result.resultCode== RESULT_OK){
//            val intent:Intent =result.data!!
//            val task: Task<GoogleSignInAccount>=GoogleSignIn.getSignedInAccountFromIntent(intent)
//        }
//    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{//로그인 성공 시
                val account =task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            }catch (e:ApiException){

            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String){
        val credential = GoogleAuthProvider.getCredential(idToken,null)
        fbsconnect.firbaseInit().signInWithCredential(credential)
            .addOnCompleteListener(this){task->//파이어베이스 등록
                if(task.isSuccessful){
                    val user = fbsconnect.firbaseInit().currentUser
                    Log.d("xxxx",user.toString())
                }else{
                    Log.d("xxxx","sighInWithCredential:Failure",task.exception)
                }
            }
    }
}