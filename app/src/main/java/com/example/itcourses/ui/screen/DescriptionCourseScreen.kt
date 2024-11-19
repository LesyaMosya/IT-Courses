package com.example.itcourses.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.itcourses.R
import com.example.itcourses.data.Course
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DescriptionCourseScreen(navigator: DestinationsNavigator) {
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

        }
    }
}

@Composable
fun DescriptionCourse() {
    Column {
        Row (horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(R.drawable.back_btn),
                contentDescription = "Назад",
                modifier = Modifier.size(30.dp)
            )

            Surface (
                modifier = Modifier.size(30.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.onPrimary,
                shadowElevation = 3.dp
            ) {
                Image(
                    painter = painterResource(R.drawable.big_bookmark_png),
                    contentDescription = "Закладка"
                )
            }
        }

        //BodyDescription()
    }
}

@Composable
fun BodyDescription(
    course: Course
) {
    Text(
        text = course.title,
        style = MaterialTheme.typography.labelLarge
    )

    AuthorCard(course)

    Button(
        onClick = {},
        modifier = Modifier
            .size(220.dp, 30.dp)
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(15.dp))
    ) {
        Text(
            text = "Начать курс"
        )
    }

    Button(
        onClick = {},
        modifier = Modifier
            .size(220.dp, 30.dp)
            .background(MaterialTheme.colorScheme.tertiary, RoundedCornerShape(15.dp))
    ) {
        Text(
            text = "Перейти на платформу"
        )
    }

    Text(
        text = "О курсе",
        style = MaterialTheme.typography.labelLarge
    )

    Text(
        text = course.description,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun AuthorCard(
    course: Course
) {
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface (
            shape = CircleShape,
            modifier = Modifier.size(27.dp)
        ) {
            AsyncImage(
                model = course.imageURL,
                contentDescription = course.title,
            )
        }

        Column {
            Text (
                text = "Автор",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}