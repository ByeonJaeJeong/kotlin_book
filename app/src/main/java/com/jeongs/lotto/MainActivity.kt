
package com.jeongs.lotto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_main)

        val random_select:CardView =findViewById(R.id.random_select)
        random_select.setOnClickListener {
            //랜덤 찾기
            Toast.makeText(this,"랜덤찾기 실행",Toast.LENGTH_SHORT).show()

            val nextIntent : Intent =Intent(this,ResultActivity::class.java)

            nextIntent.putIntegerArrayListExtra("result",ArrayList(LottoNumberMaker.getRandomLottoNumbers()))
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
