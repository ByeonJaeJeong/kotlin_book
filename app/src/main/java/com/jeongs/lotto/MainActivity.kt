
package com.jeongs.lotto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random_select:CardView =findViewById(R.id.random_select)
        random_select.setOnClickListener {
            //랜덤 찾기
            Toast.makeText(this,"랜덤찾기 실행",Toast.LENGTH_SHORT).show()

            val nextIntent : Intent =Intent(this,ResultActivity::class.java)

            nextIntent.putIntegerArrayListExtra("result",ArrayList(getRandomLottoNumbers()))
            startActivity(nextIntent)
        }
        val constellation_select:CardView= findViewById(R.id.constellation_select)
        constellation_select.setOnClickListener {
            //별자리로 찾기
            Toast.makeText(this,"별자리로 찾기 실행",Toast.LENGTH_SHORT).show()
            val nextIntent =Intent(this,ConstellationActivity::class.java)
            startActivity(nextIntent)
        }
        val user_select:CardView= findViewById(R.id.user_select)
        user_select.setOnClickListener {
            //이름으로 찾기
            Toast.makeText(this,"이름으로 찾기 실행",Toast.LENGTH_SHORT).show()
            val nextIntent =Intent(this,NameActivity::class.java)
            startActivity(nextIntent)
        }

    }


}
fun getRandomLottoNumber() : Int {

    return Random.nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for (i in 1..6){
        var number= 0
        //중복제거
        do {
            number= getRandomLottoNumber()
            //랜덤번호 추출
        }while (lottoNumbers.contains(number))
        //추출한 번호와 numbers 값이 없을때 까지 반복
        lottoNumbers.add(number)
    }

    return lottoNumbers
}
fun getShuffleLottoNumbers() :MutableList<Int>{
    val list= mutableListOf<Int>()

    for(number in 1..45){
        list.add(number)
    }

    list.shuffle()

    return list.subList(0,6)
}