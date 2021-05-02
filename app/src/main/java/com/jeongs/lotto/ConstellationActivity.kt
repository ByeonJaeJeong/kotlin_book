package com.jeongs.lotto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.get

class ConstellationActivity : AppCompatActivity() {
    private final var FINISH_INTERVAL_TIME: Long = 2000
    private var backPressedTime: Long = 0
    private var dateNumber: Int =0
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

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        val nextButton : Button = findViewById(R.id.goResultBtn)
        val nextIntent : Intent = Intent(this,ResultActivity::class.java)

        val datePicker:DatePicker = findViewById(R.id.datePicker)
        datePicker.setOnDateChangedListener(DatePicker.OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            val textView :TextView = findViewById(R.id.textView)
            textView.text=makeConstellationString(monthOfYear,dayOfMonth)
        })

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
    fun makeConstellationString(month: Int, day: Int):String{
        var target= "${month+1}+${String.format("%02d",day)}".toInt()
        when(dateNumber){
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }
}