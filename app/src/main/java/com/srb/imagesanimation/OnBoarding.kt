package com.srb.imagesanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.skydoves.progressview.ProgressView
import com.skydoves.progressview.progressView

class OnBoarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)


        val btn = findViewById<MaterialButton>(R.id.onBoarding_4_nextBtn)
       val progressView= findViewById<ProgressView>(R.id.progress_bar)

        progressView.apply {
            progress = 70f
            min = 0f
            max = 100f
            radius = 30f
            duration = 5000L
        }

        btn.setOnClickListener {
            progressView.progress = 80f
        }


    }
}