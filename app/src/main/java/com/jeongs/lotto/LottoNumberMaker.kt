package com.jeongs.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    /*
    * 랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
    * */
    fun getRandomLottoNumbers():MutableList<Int>{

        val lottoNumbers = mutableListOf<Int>()

        for(i in 1..6){
            var number =0
            do{
                number= getRandomLottoNumber()
            }while (lottoNumbers.contains(number))//비교해서 중복이면 다시 실행
            //맞으면 저장
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    /*
    * 랜덤으로 1 ~ 45 번호중 하나의 번호를 생성하는 함수
    * */
    private fun getRandomLottoNumber():Int{
        return Random().nextInt(45)+1
    }

    /*
    *  suffle 을 사용해서 로또 번호 생성
    * */
    fun getShuffleLottoNumbers(): MutableList<Int>{
        val list = mutableListOf<Int>()
        //1~45까지 들은 리스트 생성
        for(number in 1..45){
            list.add(number)
        }
        //섞기
        list.shuffle()
        //0~6까지 잘라서 반환
        return list.subList(0,6)
    }

    /*
    *  입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환
    * */
    fun getLottoNumbersFromHash(str:String):MutableList<Int>{
        val list= mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }
        //현재 날짜와 이름을 섞어서 해쉬코드로 반환해 섞기
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + str

      list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0,6)
    }


}