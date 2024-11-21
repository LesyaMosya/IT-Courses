package com.example.itcourses.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Course(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("cover")
    val imageURL: String = "",
    @SerializedName("create_date")
    val createDate: String,
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("course_type")
    val courseType: String = "",
    @SerializedName("requirements")
    val requirements: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("is_favorite")
    val isFavorite: Boolean = false
)
