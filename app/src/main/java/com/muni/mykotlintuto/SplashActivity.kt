package com.muni.mykotlintuto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splish)
        Handler().postDelayed({
            val intent = Intent(this, FingerPrintActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
    }



