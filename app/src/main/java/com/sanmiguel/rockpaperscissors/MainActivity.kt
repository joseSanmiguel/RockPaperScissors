package com.sanmiguel.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        //In this part of the code I setup Papel as default value for computer (ImageView).
        val computer = findViewById<ImageView>(R.id.imaComputer)
        computer.setImageResource(R.drawable.papel)

        //In this part of the code I setup Piedra as default value for photoUser (ImageView).
        val photoUser = findViewById<ImageView>(R.id.imaUser)
        photoUser.setImageResource(R.drawable.piedra)

        //code for Buttons
        val tvWin = findViewById<TextView>(R.id.tvWinner)
        val cValScore = findViewById<TextView>(R.id.cValScore)
        val uValScore = findViewById<TextView>(R.id.uValScore)
        var user = 0
        var compu = 0
        val stone = findViewById<ImageButton>(R.id.imaPiedra)
        stone.setOnClickListener {
            photoUser.setImageResource(R.drawable.piedra)
            when((listOf("Stone", "Paper", "Scissor").random())){
                "Stone" -> {computer.setImageResource(R.drawable.piedra)
                    tvWin.text = "LIKE STONE"}
                "Paper" -> {computer.setImageResource(R.drawable.papel)
                    tvWin.text = "GOOD LUCK NEXT TIME"
                    compu ++
                    cValScore.text = compu.toString()
                }
                else -> {computer.setImageResource(R.drawable.tijeras)
                    tvWin.text = "HEY YOU WON!!"
                    user ++
                    uValScore.text = user.toString()
                }
            }
        }
        val paper = findViewById<ImageButton>(R.id.imaPaper)
        paper.setOnClickListener {
            photoUser.setImageResource(R.drawable.papel)
            when((listOf("Stone", "Paper", "Scissor").random())){
                "Stone" -> {computer.setImageResource(R.drawable.piedra)
                    tvWin.text = "HEY YOU WON!!"
                    user ++
                    uValScore.text = user.toString()
                }
                "Paper" -> {computer.setImageResource(R.drawable.papel)
                    tvWin.text = "GIVE ME FIVE. WELL FOUR"}
                else -> {computer.setImageResource(R.drawable.tijeras)
                    tvWin.text = "GOOD LUCK NEXT TIME"
                    compu ++
                    cValScore.text = compu.toString()
                }
            }
        }
        val scissor = findViewById<ImageButton>(R.id.imaScissors)
        scissor.setOnClickListener {
            photoUser.setImageResource(R.drawable.tijeras)
            when((listOf("Stone", "Paper", "Scissor").random())){
                "Stone" -> {computer.setImageResource(R.drawable.piedra)
                    tvWin.text = "GOOD LUCK NEXT TIME"
                    compu ++
                    cValScore.text = compu.toString()
                }
                "Paper" -> {computer.setImageResource(R.drawable.papel)
                    tvWin.text = "HEY YOU WON!!"
                    user ++
                    uValScore.text = user.toString()
                }
                else -> {computer.setImageResource(R.drawable.tijeras)
                    tvWin.text = "CROSS YOUR FINGERS"}
            }
        }
        tvWin.setOnClickListener{
            uValScore.text = "0"
            cValScore.text = "0"
            tvWin.text = "Touch me to Reset Scores"
        }
    }
}