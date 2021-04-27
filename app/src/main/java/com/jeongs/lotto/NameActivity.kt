package com.jeongs.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

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

