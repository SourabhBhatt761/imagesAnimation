package com.srb.imagesanimation

import android.animation.TimeAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(),TimeAnimator.TimeListener {

//   lateinit var img : ImageView
    private lateinit var mAnimator : TimeAnimator
    var mCurrentLevel = 0
    private lateinit var mClipDrawable :ClipDrawable
    private val LEVEL_INCREMENT = 50
    private val MAX_LEVEL = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        img = findViewById(R.id.iv_translate)
//        img.setOnClickListener{
//            performRotation()
//        }

        val btn = findViewById<Button>(R.id.clickBtn)
//        val fabBtn = findViewById<FloatingActionButton>(R.id.fabBtn)

        val layerDrawable = btn.background as LayerDrawable
        mClipDrawable = layerDrawable.findDrawableByLayerId(R.id.clip_drawable) as ClipDrawable

        mAnimator = TimeAnimator()
        mAnimator.setTimeListener(this)

        btn.setOnClickListener {
            animateButton()
        }

//        animateFloatingButton(fabBtn)


//            val btn = findViewById<Button>(R.id.clickBtn)
//        val mWaveView = findViewById<WaveView>(R.id.waveView)

//        val waveShiftAnim = ObjectAnimator.ofFloat(
//            mWaveView, "waveShiftRatio", 0f, 1f
//        )
//        waveShiftAnim.repeatCount = ValueAnimator.INFINITE
//        waveShiftAnim.duration = 1000
//        waveShiftAnim.interpolator = LinearInterpolator()


//        btn.setOnClickListener {
            Log.i("uni", "code executes")
//            val transition = btn.background as TransitionDrawable
//            transition.startTransition(2000)


//            val btnAnimator = ObjectAnimator.ofObject(
//                btn, "backgroundColor", ArgbEvaluator(), 0xFFFFFFFF,
//                0xff78c5f9
//            )
//
//            btnAnimator.duration = 500
//            btnAnimator.start()
//        }


    }

    override fun onTimeUpdate(animation: TimeAnimator?, totalTime: Long, deltaTime: Long) {
        mClipDrawable.level = mCurrentLevel
        if (mCurrentLevel >= MAX_LEVEL) {
            mAnimator.cancel()
        } else {
            mCurrentLevel = MAX_LEVEL.coerceAtMost(mCurrentLevel + LEVEL_INCREMENT)
        }
    }


    private fun animateButton() {
        if (!mAnimator.isRunning) {
            mCurrentLevel = 0
            mAnimator.start()
        }
    }

//    private fun animateFloatingButton(view: FloatingActionButton) {
//        if (!mAnimator.isRunning) {
//            mCurrentLevel = 0
//            mAnimator.start()
//        }
//    }


//    private fun performRotation() {
//
//        val animation = img.drawable as AnimatedVectorDrawable
//        animation.start()
//
//    }
}