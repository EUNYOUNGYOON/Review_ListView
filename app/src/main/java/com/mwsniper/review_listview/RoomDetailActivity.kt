package com.mwsniper.review_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mwsniper.review_listview.datas.Room
import kotlinx.android.synthetic.main.activity_room_detail.*

class RoomDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)

        setValues()
        setupEvents()

    }

    override fun setupEvents() {
    }

    override fun setValues() {

        // roomInfo를 serializable로 받는다
        // 그냥 받은 채로 변수에 넣으면 오류가 나는데 이 때 Casting을 해줘야 한다
        val room = intent.getSerializableExtra("roomInfo") as Room

        // activity_room_detail.xml에 설정했던 view에 따라 매핑
        priceTxt.text = "${room.deposit} / ${room.monthlyRent}"
        addressTxt.text = room.address
        descTxt.text = room.description
        floorTxt.text = room.floor.toString()

    }
}