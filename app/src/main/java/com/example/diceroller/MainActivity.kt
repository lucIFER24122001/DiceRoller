package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.media.MediaPlayer
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.rollBtn.setOnClickListener { rollDice() }

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

        binding.iv.setImageResource(drawableImage)

    }


}