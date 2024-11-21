package com.example.itcourses.ui.screen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itcourses.data.ApiState
import com.example.itcourses.ui.viewmodel.MainPageViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    viewModel: MainPageViewModel = hiltViewModel()
) {
    Scaffold (
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {
                NavigationBar(navigator)
            }
        }
    ) { innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ListOfCourses(viewModel, navigator)
        }
    }
}

@Composable
fun ListOfCourses(
    viewModel: MainPageViewModel,
    navigator: DestinationsNavigator
){
    when (val result = viewModel.response.value) {
        is ApiState.SuccessLoadingList -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(result.data) { course ->
                    CourseCard(navigator, course)
                }
            }
        }

        is ApiState.Loading -> {
            Loading()
        }

        is ApiState.Empty -> {
            Loading()
        }

        is ApiState.Failure -> {
            Failure(result.message)
        }

        else -> {}
    }
}

@Composable
fun Loading() {
    Text("Загрузка", Modifier.fillMaxSize())
}

@Composable
fun Failure(message: String) {
    Text(message)
}