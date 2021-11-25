package com.example.kreswikinoliki

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Tictactoe : AppCompatActivity(), View.OnClickListener {
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button
    private lateinit var resetButton: Button
    private lateinit var gameText: TextView
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secPlayer = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)
        init()


    }

    private fun init() {
        Button1 = findViewById(R.id.Button1)
        Button2 = findViewById(R.id.Button2)
        Button3 = findViewById(R.id.Button3)
        Button4 = findViewById(R.id.Button4)
        Button5 = findViewById(R.id.Button5)
        Button6 = findViewById(R.id.Button6)
        Button7 = findViewById(R.id.Button7)
        Button8 = findViewById(R.id.Button8)
        Button9 = findViewById(R.id.Button9)
        resetButton = findViewById(R.id.resetButton)
        gameText = findViewById(R.id.gameText)
        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0

            when (clickedView.id) {
                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9


            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }


    }


    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            findViewById<TextView>(R.id.gameText).text = intent?.extras?.getString("player 2")
            clickedView.setBackgroundColor(Color.BLUE)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "O"
            findViewById<TextView>(R.id.gameText).text = intent?.extras?.getString("player 1")
            clickedView.setBackgroundColor(Color.RED)
            secPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()

    }

    private fun check() {
        var winners = 0
        var sc1 = 0
        var sc2 = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winners = 1
        }
        if (secPlayer.contains(1) && secPlayer.contains(2) && secPlayer.contains(3)) {
            winners = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winners = 1
        }
        if (secPlayer.contains(4) && secPlayer.contains(5) && secPlayer.contains(6)) {
            winners = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winners = 1
        }
        if (secPlayer.contains(7) && secPlayer.contains(8) && secPlayer.contains(9)) {
            winners = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winners = 1
        }
        if (secPlayer.contains(1) && secPlayer.contains(4) && secPlayer.contains(7)) {
            winners = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winners = 1
        }
        if (secPlayer.contains(2) && secPlayer.contains(5) && secPlayer.contains(8)) {
            winners = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winners = 1
        }
        if (secPlayer.contains(3) && secPlayer.contains(6) && secPlayer.contains(9)) {
            winners = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winners = 1
        }
        if (secPlayer.contains(1) && secPlayer.contains(5) && secPlayer.contains(9)) {
            winners = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winners = 1
        }
        if (secPlayer.contains(3) && secPlayer.contains(5) && secPlayer.contains(7)) {
            winners = 2
        }
        if ((firstPlayer.contains(1) or secPlayer.contains(1)) && (firstPlayer.contains(2) or secPlayer.contains(
                2
            )) && (firstPlayer.contains(3) or secPlayer.contains(3)) && (firstPlayer.contains(4) or secPlayer.contains(
                4
            )) && (firstPlayer.contains(5) or secPlayer.contains(5)) && (firstPlayer.contains(6) or secPlayer.contains(
                6
            )) && (firstPlayer.contains(7) or secPlayer.contains(7)) && (firstPlayer.contains(8) or secPlayer.contains(
                8
            )) && (firstPlayer.contains(9) or secPlayer.contains(9))
        ) {
            winners = 3
        }
        if (winners == 1) {
            val playernn1 = intent?.extras?.getString("winner 1")
            val pl1 = intent?.extras?.getString("player 1")
            val pl2 = intent?.extras?.getString("player 2")
            val intent1 = Intent(this, Winner::class.java)
            intent1.putExtra("winner1", playernn1)
            intent1.putExtra("player 1", pl1)
            intent1.putExtra("player 2", pl2)
            startActivity(intent1)

        } else if (winners == 2) {
            val playernn2 = intent?.extras?.getString("winner 2")
            val pl1 = intent?.extras?.getString("player 1")
            val pl2 = intent?.extras?.getString("player 2")
            val intent = Intent(this, Winner::class.java)
            intent.putExtra("winner2", playernn2)
            intent.putExtra("player 1", pl1)
            intent.putExtra("player 2", pl2)
            startActivity(intent)
        }
        else if (winners == 3){
            Toast.makeText(this, "It's tie", Toast.LENGTH_SHORT).show()
            clean()
        }
        resetButton.setOnClickListener{
            clean()
        }

    }

    private fun clean() {
        Button1.isEnabled = true
        Button1.text = ""
        Button1.setBackgroundColor(Color.GRAY)
        Button2.isEnabled = true
        Button2.text = ""
        Button2.setBackgroundColor(Color.GRAY)
        Button3.isEnabled = true
        Button3.text = ""
        Button3.setBackgroundColor(Color.GRAY)
        Button4.isEnabled = true
        Button4.text = ""
        Button4.setBackgroundColor(Color.GRAY)
        Button5.isEnabled = true
        Button5.text = ""
        Button5.setBackgroundColor(Color.GRAY)
        Button6.isEnabled = true
        Button6.text = ""
        Button6.setBackgroundColor(Color.GRAY)
        Button7.isEnabled = true
        Button7.text = ""
        Button7.setBackgroundColor(Color.GRAY)
        Button8.isEnabled = true
        Button8.text = ""
        Button8.setBackgroundColor(Color.GRAY)
        Button9.isEnabled = true
        Button9.text = ""
        Button9.setBackgroundColor(Color.GRAY)
        firstPlayer.clear()
        secPlayer.clear()

    }


}

