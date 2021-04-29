package com.jeongs.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

    private final var FINISH_INTERVAL_TIME: Long = 2000
    private var backPressedTime: Long = 0

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) {
            var tempTime = System.currentTimeMillis();
            var intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
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
        setContentView(R.layout.activity_name)


        val nextButton:Button = findViewById(R.id.goButton)
        val nameText: EditText= findViewById(R.id.editText)
        nextButton.setOnClickListener{
            val nextIntent : Intent = Intent(this,ResultActivity::class.java)
            nextIntent.putExtra("name",nameText.toString())
            nextIntent.putIntegerArrayListExtra("result",ArrayList(getShuffleLottoNumbers()))
            startActivity(nextIntent)
        }
        val backButton:Button =findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val backIntent:Intent = Intent(this,MainActivity::class.java)
            startActivity(backIntent)
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

