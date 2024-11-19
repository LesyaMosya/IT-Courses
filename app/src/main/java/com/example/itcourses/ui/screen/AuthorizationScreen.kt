package com.example.itcourses.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.itcourses.ui.screen.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun AuthorizationScreen(navigator: DestinationsNavigator) {
 Button(
     onClick = { navigator.navigate(MainScreenDestination) }
 ) {
     Text(
         text = "ВХОД"
     )
 }
}