package com.srb.imagesanimation

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

   lateinit var img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.iv_translate)
        img.setOnClickListener{
            performRotation()
        }
    }

    private fun performRotation() {

        val animation = img.drawable as AnimatedVectorDrawable
        animation.start()

    }
}