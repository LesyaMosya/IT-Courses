package com.example.itcourses.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itcourses.R
import com.example.itcourses.data.Course
import com.example.itcourses.ui.screen.destinations.DescriptionCourseScreenDestination
import com.example.itcourses.ui.screen.destinations.FavoritesScreenDestination
import com.example.itcourses.ui.screen.destinations.MainScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun CardCourse(
    navigator : DestinationsNavigator,
    course: Course
) {
    Surface (
        modifier = Modifier
            .size(220.dp,160.dp),
        color = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(15.dp)

    ) {
        Column() {
            Surface(
                modifier = Modifier
                    .height(76.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),

                ) {
                Column {
                    Row {
                        // Лого
                        //Избранное
                    }

                }
            }
            Surface {
                Text(
                    text = course.title,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text (
                    text = course.requirements,
                    style = MaterialTheme.typography.bodySmall
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = course.price.toString() + " ₽",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Button(
                        onClick = {navigator.navigate(DescriptionCourseScreenDestination)}
                    ) {
                        Text(
                            text = "Подробнее ",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Image(
                            painterResource(R.drawable.next_btn),
                            contentDescription = "далее"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationBar(navigator: DestinationsNavigator) {
    Row (
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationButton(navigator.navigate(MainScreenDestination), R.drawable.home_btn, "Главная")
        NavigationButton(navigator.navigate(FavoritesScreenDestination), R.drawable.favorite_btn, "Избранное")
        NavigationButton(navigator.navigate(MainScreenDestination), R.drawable.profile_btn, "Аккаунт")
    }
}

@Composable
fun NavigationButton(
    onClick: Unit,
    @DrawableRes image: Int,
    text: String
) {
    Column {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier
                .size(43.dp, 21.dp)
                .clickable{onClick}
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}