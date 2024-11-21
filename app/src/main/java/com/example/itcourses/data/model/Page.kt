package com.example.itcourses.data.model

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("courses")
    val courses: List<Course>
)
