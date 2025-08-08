package com.example.techmate.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.techmate.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //this will create the splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            val splashScreenIntent = Intent(this, LoginScreen::class.java)
            startActivity(splashScreenIntent)
        },2000)


    }
}