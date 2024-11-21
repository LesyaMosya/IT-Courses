package com.example.itcourses.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itcourses.R
import com.example.itcourses.data.model.Course
import com.example.itcourses.ui.DescriptionCourseScreenNavArgs
import com.example.itcourses.ui.screen.destinations.DescriptionCourseScreenDestination
import com.example.itcourses.ui.screen.destinations.FavoritesScreenDestination
import com.example.itcourses.ui.screen.destinations.MainScreenDestination
import com.example.itcourses.ui.theme.ITCoursesTheme
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun CourseCard(
    navigator : DestinationsNavigator,
    course: Course
) {
    Box (
        modifier = Modifier
            .padding(20.dp, 10.dp)
            .fillMaxWidth()
            .height(120.dp)
            .background(MaterialTheme.colorScheme.tertiary, RoundedCornerShape(15.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
//            Spacer(modifier = Modifier.height(10.dp))
            Text (
                text = if (course.description.isNotEmpty()) course.description
                else "Описание курса отсутствует",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
//            Spacer(modifier = Modifier.height(10.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (course.price != 0 ) course.price.toString() + " ₽"
                    else "Бесплатный",
                    style = MaterialTheme.typography.bodyLarge
                )

                Box(
                    modifier = Modifier
                        .clickable { navigator.navigate(DescriptionCourseScreenDestination(course.id)) }
                        .background(Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Подробнее ",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Image(
                            painterResource(R.drawable.next_btn),
                            contentDescription = "далее",
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }
    }
}
val course = Course(10, "Курсы", "", "", 190, "", "", "Хороший курс всем очень советую бла бла бла мне очень нравится Хороший курс всем очень советую бла бла бла мне очень нравится Хороший курс всем очень советую бла бла бла мне очень нравится", false)

@Preview
@Composable
fun CourseCardPreview() {
    ITCoursesTheme {
//        CourseCard(course)
    }
}

@Composable
fun NavigationBar(navigator: DestinationsNavigator) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationButton(
            navigator.navigate(MainScreenDestination),
            R.drawable.home_btn,
            "Главная"
        )
        NavigationButton(
            navigator.navigate(FavoritesScreenDestination),
            R.drawable.favorite_btn,
            "Избранное"
        )
        NavigationButton(
            navigator.navigate(MainScreenDestination),
            R.drawable.profile_btn,
            "Аккаунт"
        )
    }
}

@Composable
fun NavigationButton(
    onClick: Unit,
    @DrawableRes image: Int,
    text: String
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp, 30.dp)
                .clickable { onClick }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}