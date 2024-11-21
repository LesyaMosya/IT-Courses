package com.example.itcourses.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.itcourses.data.api.ApiHelper
import com.example.itcourses.data.model.Course
import com.example.itcourses.data.model.TokenStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourseRepository @Inject constructor(private val apiHelper: ApiHelper) {

    val responseList: MutableState<ApiState> = mutableStateOf(ApiState.Empty)
    val responseCourse: MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    val token = mutableStateOf(TokenStore.token)
    val isLogin = mutableStateOf(false)

    suspend fun login() {
        apiHelper.login()
            .flowOn(Dispatchers.IO)
            .catch {
                responseCourse.value = ApiState.Failure(it.toString())
            }
            .collect{
                TokenStore.token = it.accessToken
                token.value = it.accessToken
            }

    }

    suspend fun getCourses(order: String) {
        apiHelper.getCourses(order)
            .flowOn(Dispatchers.IO)
            .catch {
                responseList.value = ApiState.Failure(it.toString())
            }
            .collect{
                responseList.value = ApiState.SuccessLoadingList(it.courses)
            }
    }

    suspend fun getCourseById(id: Int) {
        apiHelper.getCourseById(id)
            .flowOn(Dispatchers.IO)
            .catch {
                responseCourse.value = ApiState.Failure(it.toString())
            }
            .collect{
                responseCourse.value = ApiState.SuccessLoadingCourse(it.courses.component1())
            }
    }
}

sealed class ApiState {
    class SuccessLoadingList(val data: List<Course>) : ApiState()
    class SuccessLoadingCourse(val data : Course) : ApiState()
    class Failure(val message : String) : ApiState()

    data object Loading : ApiState()
    data object Empty : ApiState()
}
