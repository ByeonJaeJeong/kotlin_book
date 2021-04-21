
package com.jeongs.lotto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random_select:CardView =findViewById(R.id.random_select)
        random_select.setOnClickListener {
            //랜덤 찾기
            Toast.makeText(this,"랜덤찾기 실행",Toast.LENGTH_SHORT).show()
            val intent =Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
        val constellation_select:CardView= findViewById(R.id.constellation_select)
        constellation_select.setOnClickListener {
            //별자리로 찾기
            Toast.makeText(this,"별자리로 찾기 실행",Toast.LENGTH_SHORT).show()
            val intent =Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
        val user_select:CardView= findViewById(R.id.user_select)
        user_select.setOnClickListener {
            //이름으로 찾기
            Toast.makeText(this,"이름으로 찾기 실행",Toast.LENGTH_SHORT).show()
            val intent =Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }

    }


}