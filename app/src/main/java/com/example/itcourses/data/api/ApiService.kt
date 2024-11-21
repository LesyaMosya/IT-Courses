package com.example.itcourses.data.api

import com.example.itcourses.data.model.Auth
import com.example.itcourses.data.model.Course
import com.example.itcourses.data.model.LoginResponse
import com.example.itcourses.data.model.Page
import com.example.itcourses.data.model.TokenStore
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("oauth2/token/")
    suspend fun login(
        @Field("grant_type", encoded = true) grantType: String,
        @Field("client_id", encoded = true) username : String,
        @Field("client_secret", encoded = true) password : String
    ) : LoginResponse

    @GET("api/courses")
    suspend fun getCourses(
        @Query("order") order: String,
    ): Page

    @GET("api/courses/{id}")
    suspend fun getCourseById(
        @Path("id") id: Int
    ): Page
}