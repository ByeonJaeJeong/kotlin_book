package com.jeongs.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class ConstellationActivity : AppCompatActivity() {
    private final var FINISH_INTERVAL_TIME: Long = 2000
    private var backPressedTime: Long = 0

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) {
            var tempTime = System.currentTimeMillis();
            var intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                ActivityCompat.finishAffinity(this)
                System.exit(0)
            } else {
                backPressedTime = tempTime;
                Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
                return
            }
        }
        super.onBackPressed();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        val nextButton : Button = findViewById(R.id.goResultBtn)
        val nextIntent : Intent = Intent(this,ResultActivity::class.java)

        nextButton.setOnClickListener {
            nextIntent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
            startActivity(nextIntent)
        }
    }
    fun getShuffleLottoNumbers() :MutableList<Int>{
        val list= mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }

        list.shuffle()

        return list.subList(0,6)
    }
}