package com.carlacampo.booksphere.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.model.Routes


@Composable
fun ButtonsFirstRow(navController: NavHostController, navigateToScreenLibrary:()->Unit, navigateToScreenCurrentRead:()->Unit){
    // Box 1

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(75.dp)
            .background(Color(123, 76, 72), shape = MaterialTheme.shapes.small)
            .padding(8.dp)
            .clickable {navController.navigate(Routes.ScreenLibrary.route)}
    ) {
        Text(
            text = stringResource(R.string.library),
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .size(24.dp),
            textAlign = TextAlign.Center
        )
    }

    // Box 2
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(75.dp)
            .background(Color(35, 156, 166), shape = MaterialTheme.shapes.small)
            .padding(8.dp)
            .clickable {navController.navigate(Routes.ScreenCurrentRead.route)}
        ) {
        Text(
            text = stringResource(R.string.currentRead),
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .size(24.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonsSecondRow(navController: NavHostController, navigateToScreenDesired:()->Unit, navigateToScreenStats:()->Unit){
    // Box 3
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(75.dp)
            .background(Color(232, 71, 27), shape = MaterialTheme.shapes.small)
            .padding(8.dp)
            .clickable {navController.navigate(Routes.ScreenDesired.route)}
    ) {
        Text(
            text = stringResource(R.string.desired),
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .size(24.dp),
            textAlign = TextAlign.Center
        )
    }

    // Box 4
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(75.dp)
            .background(Color(234, 159, 40), shape = MaterialTheme.shapes.small)
            .padding(8.dp)
            .clickable {navController.navigate(Routes.ScreenStats.route)}
    ) {
        Text(
            text = stringResource(R.string.stats),
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .size(24.dp),
            textAlign = TextAlign.Center
        )
    }
}