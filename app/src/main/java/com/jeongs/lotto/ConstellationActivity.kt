package com.jeongs.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConstellationActivity : AppCompatActivity() {

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