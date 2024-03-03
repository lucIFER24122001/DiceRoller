package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.media.MediaPlayer
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn = findViewById<Button>(R.id.rollBtn)
        imageView = findViewById(R.id.iv)


        btn.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
        val randomNumber = (1..6).random()
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.shake_dice)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()

        var drawableImage =
            when(randomNumber)
        {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six


        }

        imageView.setImageResource(drawableImage)

    }


}