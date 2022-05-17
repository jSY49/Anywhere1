package com.example.whereever

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.areatrip.*

class wheatherIsClean: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.whereisclean)

        btnback.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()

            }
        })

    }
}
