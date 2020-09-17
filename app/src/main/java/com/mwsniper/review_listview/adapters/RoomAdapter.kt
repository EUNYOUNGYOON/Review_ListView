package com.mwsniper.review_listview.adapters

import android.content.Context
import android.content.LocusId
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mwsniper.review_listview.R
import com.mwsniper.review_listview.datas.Room

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Room>
) : ArrayAdapter<Room>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }
        val row = tempRow!!

        // 실제 데이터가 있는 목록이 반영되도록 Adapter 클래스의 getView 함수를 수정
        // 뿌려줄 row 안에 있는 텍스트 뷰 변수로 담기
        val data = mList[position]
        val price = row.findViewById<TextView>(R.id.priceTxt)
        val address = row.findViewById<TextView>(R.id.addressTxt)
        val desc = row.findViewById<TextView>(R.id.descTxt)

        price.text = "${data.deposit} / ${data.monthlyRent}"
        address.text = "${data.address},  ${data.floor}"
        desc.text = data.description

        return row
    }

}