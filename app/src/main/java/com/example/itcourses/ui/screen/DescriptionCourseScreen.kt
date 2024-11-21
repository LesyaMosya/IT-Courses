package com.example.itcourses.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.itcourses.R
import com.example.itcourses.data.ApiState
import com.example.itcourses.data.model.Course
import com.example.itcourses.ui.DescriptionCourseScreenNavArgs
import com.example.itcourses.ui.viewmodel.DescriptionCourseViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = DescriptionCourseScreenNavArgs::class)
@Composable
fun DescriptionCourseScreen(
    navigator: DestinationsNavigator,
    viewModel: DescriptionCourseViewModel = hiltViewModel()
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
            DescriptionCourse(navigator, viewModel)
        }
    }
}

@Composable
fun DescriptionCourse(
    navigator: DestinationsNavigator,
    viewModel: DescriptionCourseViewModel) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.back_btn),
                contentDescription = "Назад",
                modifier = Modifier
                    .size(50.dp)
                    .clickable{/*navigator.navigateUp()*/}
            )

            Surface (
                modifier = Modifier.size(50.dp),
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

        when (val result = viewModel.response.value) {
            is ApiState.SuccessLoadingCourse -> {
                BodyDescription(result.data)
            }

            is ApiState.Loading -> {
                //Loading()
            }

            is ApiState.Failure -> {
                Failure(result.message)
            }

            else -> {}
        }
    }
}

@Composable
fun BodyDescription(
    course: Course
) {
    Column(
        modifier = Modifier.fillMaxSize()
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
            style = MaterialTheme.typography.bodySmall
        )
    }
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
            color = Color.Transparent,
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
                style = MaterialTheme.typography.bodySmall
            )
            Text (
                text = "Автор",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}