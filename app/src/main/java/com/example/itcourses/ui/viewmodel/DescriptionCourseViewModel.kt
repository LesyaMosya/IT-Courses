package com.example.itcourses.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itcourses.data.CourseRepository
import com.example.itcourses.ui.screen.destinations.DescriptionCourseScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DescriptionCourseViewModel @Inject constructor (
    private val repository: CourseRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val response = repository.responseCourse

    init {
        val navArgs = DescriptionCourseScreenDestination.argsFrom(savedStateHandle)
        getCourseById(navArgs.id)
    }

    private fun getCourseById(id: Int) =
        viewModelScope.launch {
            repository.getCourseById(id)
        }
}
