package com.example.itcourses.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MainScreen(navigator: DestinationsNavigator) {
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
            ListOfCourses()
        }
    }
}

@Composable
fun ListOfCourses(){
    LazyColumn {
/*        items() { course ->
            CardCourse(course)*/
    }
}