package com.example.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
*/


@Entity
data class User(@ColumnInfo(name = "first_name") var firstName: String,
                @ColumnInfo(name = "last_name") var lastName: String) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
}