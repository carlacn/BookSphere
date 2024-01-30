package com.carlacampo.booksphere.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.model.Routes


@Composable
fun ScreenDesired(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ){
        Text (text = stringResource(R.string.desired), modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(
            Routes.MainActivityContent.route)})
    }

}
