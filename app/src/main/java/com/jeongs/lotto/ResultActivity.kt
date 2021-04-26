package com.jeongs.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {
    val lottoImageStartId= R.drawable.ball_01
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultLabel = findViewById<TextView>(R.id.resultLabel)
        //전달받은 결과 배열을 가져옴
        val result = intent.getIntegerArrayListExtra("result")
        //전달받은 결과가 있을경우 가져옴
        result?.let {
            updateLottoBallImage(result.sortedBy { it })
        }
    }
    fun updateLottoBallImage(result:List<Int>){
        //결과 사이즈가 6개 미만인 경우 에러가 발생할수 있음
        if(result.size < 6) return
        //6개 미만일경우 리턴
        val imageView01 = findViewById<ImageView>(R.id.imageView01)
        val imageView02 = findViewById<ImageView>(R.id.imageView02)
        val imageView03 = findViewById<ImageView>(R.id.imageView03)
        val imageView04 = findViewById<ImageView>(R.id.imageView04)
        val imageView05 = findViewById<ImageView>(R.id.imageView05)
        val imageView06 = findViewById<ImageView>(R.id.imageView06)
        imageView01.setImageResource(lottoImageStartId+result[0]-1)
        imageView02.setImageResource(lottoImageStartId+result[1]-1)
        imageView03.setImageResource(lottoImageStartId+result[2]-1)
        imageView04.setImageResource(lottoImageStartId+result[3]-1)
        imageView05.setImageResource(lottoImageStartId+result[4]-1)
        imageView06.setImageResource(lottoImageStartId+result[5]-1)
    }
}
