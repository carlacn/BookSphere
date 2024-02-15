package com.carlacampo.booksphere.design

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.model.Routes

@Composable
fun MainActivityScreen(navController: NavHostController){
    MainActivityContent(navController = rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainActivityContent(navController: NavHostController) {
    //Estructura de la interfaz

    Scaffold(
        topBar = { BookSphereTopBar() },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(240, 240, 240))
                    .padding(top = 48.dp)
                    .padding(start = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        ButtonsFirstRow(navController, {navController.navigate(Routes.ScreenLibrary.route)}, {navController.navigate(Routes.ScreenCurrentRead.route)})
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) { ButtonsSecondRow(navController, {navController.navigate(Routes.ScreenDesired.route)}, {navController.navigate(Routes.ScreenStats.route)}) }
                }
                LazyColumnMain()
                FloatingActionButton(
                    onClick = { navController.navigate(Routes.ScreenAddBook.route) },
                    modifier = Modifier
                        .padding(bottom = 48.dp, end = 24.dp )
                        .size(56.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Book"
                    )
                }
            }
        },
        bottomBar = { BookSphereBottomBar() }
    )
}

