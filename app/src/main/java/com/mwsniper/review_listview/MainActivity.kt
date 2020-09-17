package com.mwsniper.review_listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mwsniper.review_listview.adapters.RoomAdapter
import com.mwsniper.review_listview.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val mRoomList = ArrayList<Room>()
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        //메인화면의 이벤트관련 코드를 모아두는 장소
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄이 눌리는 시점의 이벤트
        roomListView.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedRoom = mRoomList[i]

            // 선택된 목록정보를 가져왔으면 이제 화면 이동
            val myIntent = Intent(mContext, RoomDetailActivity::class.java)
            // 정보를 담아주기
            // 2번에서는 해당 부분 오류남. 3번하고 난 다음 여기로 다시 와야함
            myIntent.putExtra("roomInfo", clickedRoom)
            // 화면 전환
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        mRoomList.add(Room(8000, 30, "서울시 마포구", 1, "마포구 1층 방입니다."))
        mRoomList.add(Room(10000, 50, "서울시 은평구", 10, "은평구 10층 방입니다."))
        mRoomList.add(Room(3000, 80, "서울시 영등포구", 5, "영등포구 5층 방입니다."))
        mRoomList.add(Room(5000, 15, "서울시 종로구", 4, "종로구 4층 방입니다."))
        mRoomList.add(Room(9000, 20, "서울시 강서구", 8, "강서구 8층 방입니다."))
        mRoomList.add(Room(12000, 40, "서울시 강북구", 17, "강북구 17층 방입니다."))
        mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter

    }
}