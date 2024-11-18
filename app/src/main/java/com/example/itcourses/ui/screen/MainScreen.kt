package com.example.itcourses.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun MainScreen() {
    Scaffold (
        bottomBar = {
            BottomAppBar(

            ) {
                Row {
                    // 3 кнопки
                }
            }
        }
    ) { innerPadding ->
        Surface (
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }
}

