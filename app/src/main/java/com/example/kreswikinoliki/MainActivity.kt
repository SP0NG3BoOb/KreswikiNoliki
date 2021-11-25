package com.example.kreswikinoliki

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var Player1 : EditText
    private lateinit var Player2 : EditText
    private lateinit var startButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Player1 = findViewById(R.id.Player1)
        Player2 = findViewById(R.id.Player2)
        startButton = findViewById(R.id.startButton)


        startButton.setOnClickListener() {
            val playern1: String = Player1.text.toString()
            val playern2: String = Player2.text.toString()

            if (playern1.isNotEmpty() && playern2.isNotEmpty()) {
                val intent = Intent(this, Tictactoe::class.java)
                intent.putExtra("player 1", "$playern1's turn")
                intent.putExtra("player 2", "$playern2's turn")
                intent.putExtra("winner 1", "$playern1 won")
                intent.putExtra("winner 2", "$playern2 won")
                startActivity(intent)

            } else {
                Toast.makeText(
                    applicationContext,
                    "Please at first input player names",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}