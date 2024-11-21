package com.example.itcourses.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itcourses.data.CourseRepository
import com.example.itcourses.data.model.TokenStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor (
    private val repository: CourseRepository
) : ViewModel() {

    val response = repository.responseList

    init {
        getCourses("create_date")
    }

    fun createEvent(e: Event) {
        onEvent(e)
    }

    private fun onEvent(e: Event) {
        when (e) {
            is Event.LoadListOfCourses -> {
                getCourses("create_date")
            }

/*            is Event.LoadCourseCard -> {
                repository.idCurrency.value = e.id
                getCryptocurrencyByName(repository.idCurrency.value)
            }*/
        }
    }
    private fun getCourses(order: String) =
        viewModelScope.launch {
            if (!repository.isLogin.value) {
                repository.login()
            }
            if (repository.token.value != "")
                repository.isLogin.value = true
                repository.getCourses(order)
        }
}

sealed class Event {
    data object LoadListOfCourses : Event()
//    data class LoadCourseById(val id: String) : Event()
}