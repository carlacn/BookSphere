package com.carlacampo.booksphere.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.model.Routes

@Composable
fun ScreenCurrentRead(navController: NavHostController,screenCurrentReadViewModel: ScreenCurrentReadViewModel = hiltViewModel()) {

    val currentReadBook by screenCurrentReadViewModel.currentReadBook.collectAsState()
    ScreenCurrentReadContent(navController = navController, book = currentReadBook)

}

@Composable
fun ScreenCurrentReadContent(navController: NavHostController, book: Book) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#F4F4F4")))
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
                .padding(top = 8.dp)
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
        )
        Text(
            text = stringResource(R.string.currentRead),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 32.dp, top = 32.dp)
                .align(Alignment.TopStart)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)
                .padding(start = 48.dp)
        ) {
            item {
                BookItem(book = book)
            }
        }
    }
}

@Composable
@Preview
fun ScreenCurrentReadPreview() {
    val navController = rememberNavController()
    val viewModel = ScreenCurrentReadViewModel()
    ScreenCurrentRead(navController = navController, screenCurrentReadViewModel = viewModel)
}
