package com.srb.imagesanimation

import android.animation.TimeAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.itangqi.waveloadingview.WaveLoadingView


class MainActivity : AppCompatActivity(),TimeAnimator.TimeListener {

//   lateinit var img : ImageView
    private lateinit var mAnimator : TimeAnimator
    private lateinit var waveBtn : WaveLoadingView
    var mCurrentLevel = 0
    private lateinit var mClipDrawable :ClipDrawable
    private val LEVEL_INCREMENT = 50


//    private val maxWaveValue = 105
private val maxWaveValue = 55
    private val currentWaveValue = 10

    //min value is 0 and max is 10000 for clip drawable
    private val MAX_LEVEL = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        img = findViewById(R.id.iv_translate)
//        img.setOnClickListener{
//            performRotation()
//        }

        val btn = findViewById<Button>(R.id.clickBtn)
         waveBtn = findViewById<WaveLoadingView>(R.id.waveLoadingView)

//        val fabBtn = findViewById<FloatingActionButton>(R.id.fabBtn)

        val layerDrawable = btn.background as LayerDrawable
        mClipDrawable = layerDrawable.findDrawableByLayerId(R.id.clip_drawable) as ClipDrawable

        mAnimator = TimeAnimator()
        mAnimator.setTimeListener(this)

        btn.setOnClickListener {
            animateButton()
        }

        waveBtn.setOnClickListener {

//            waveBtn.setAnimDuration(1000)

            waveBtn.progressValue = currentWaveValue

            val thread: Thread = object : Thread() {
                override fun run() {
                    try {
                        while (!this.isInterrupted) {
                            sleep(1000)
                            runOnUiThread {
                                if(currentWaveValue < maxWaveValue) {
                                    waveBtn.progressValue += currentWaveValue
                                }else{
                                    return@runOnUiThread
                                }
                            }
                        }
                    } catch (e: InterruptedException) {
                    }
                }
            }

            thread.start()
//            thread.interrupt()


//            waveAnimationButton()
            Log.i("uni","fn called")
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

    private fun waveAnimationButton() {
        if (!mAnimator.isRunning) {
            mAnimator.duration = 5000
            Log.i("uni","fn called 1")
            mAnimator.start()
        }
    }

    override fun onTimeUpdate(animation: TimeAnimator?, totalTime: Long, deltaTime: Long) {
        Log.i("uni","fn called 2")
        waveBtn.progressValue =50




//        mClipDrawable.level = mCurrentLevel
//        if (mCurrentLevel >= MAX_LEVEL) {
//            mAnimator.cancel()
//        } else {
////            mCurrentLevel = MAX_LEVEL.coerceAtMost(mCurrentLevel + LEVEL_INCREMENT)
//            mCurrentLevel += 33
//
//        }

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