package com.example.kreswikinoliki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Winner : AppCompatActivity() {
    private lateinit var playAgain : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        playAgain = findViewById(R.id.playAgain)


        findViewById<TextView>(R.id.textView2).text = intent?.extras?.getString("winner1", )
        findViewById<TextView>(R.id.textView4).text = intent?.extras?.getString("winner2", )


        playAgain.setOnClickListener {
            val pla1 = intent?.extras?.getString("pl1")
            val pla2 = intent?.extras?.getString("pl2")
            val w1 = intent?.extras?.getString("winner1")
            val w2 = intent?.extras?.getString("winner2")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}