package com.mwsniper.review_listview.datas

import java.io.Serializable

class Room(
    val deposit: Int,
    val monthlyRent: Int,
    val address: String,
    val floor: Int,
    val description: String
) : Serializable {

}