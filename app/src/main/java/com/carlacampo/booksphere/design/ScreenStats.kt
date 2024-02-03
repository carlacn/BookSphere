package com.carlacampo.booksphere.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.model.Routes

@Composable
fun ScreenStats(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ){
        Icon(
            modifier = Modifier
                .size(32.dp)
                .padding (start = 8.dp)
                .padding (top = 8.dp)
                .clickable {
                    navController.navigate(
                        Routes.MainActivityContent.route
                    )
                },
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = "Back",
            tint = Color.Black
        )
        Text(
            text = "BookSphere",
            fontSize = 16.sp,
            modifier = Modifier
                .size(160.dp)
                .padding(top = 8.dp)
                .padding(start = 32.dp)
                .align(Alignment.TopStart)
                .clickable {
                    navController.navigate(
                        Routes.MainActivityContent.route
                    )
                }
        )    }

}

@Composable
@Preview
fun ScreenStatsPreview() {
    val navController = rememberNavController()
    ScreenStats(navController = navController)
}