package com.example.itcourses.data.api

import com.example.itcourses.data.model.TokenStore
import com.example.itcourses.data.model.Auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Credentials
import javax.inject.Inject

class ApiHelper @Inject constructor(
    private val apiService: ApiService) {

/*    suspend fun login() {
        TokenStore.token.value = apiService.login("client_credentials", Auth.USERNAME, Auth.PASSWORD).accessToken
    }*/

    val auth = Credentials.basic(Auth.USERNAME, Auth.PASSWORD)
    fun login() = flow {
        emit(apiService.login("client_credentials", Auth.USERNAME, Auth.PASSWORD))
    }.flowOn(Dispatchers.IO)

    fun getCourses(order: String) = flow {
        emit(apiService.getCourses(order))
    }.flowOn(Dispatchers.IO)

    fun getCourseById(id: Int) = flow {
        emit(apiService.getCourseById(id))
    }.flowOn(Dispatchers.IO)
}