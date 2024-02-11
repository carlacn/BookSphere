package com.carlacampo.booksphere.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.model.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

//Separate Screen from content
@Composable
fun ScreenLibrary(navController: NavHostController, screenLibraryViewModel: ScreenLibraryViewModel = hiltViewModel()) {

    val booksState: StateFlow<List<Book>> = screenLibraryViewModel.books
    val books by booksState.collectAsState()

    ScreenLibraryContent(navController, books)
}

//Content composable. Called in ScreenLibrary.
@Composable
fun ScreenLibraryContent(navController: NavHostController, books: List<Book>) {

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
        text = stringResource(R.string.library),
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
            items(books) { book ->
                BookItem(book = book)
            }
        }
    }
}

//Show books.
@Composable
fun BookItem(book: Book) {
    Box(
        modifier = Modifier
            .padding(bottom = 8.dp)

    ) {
        Image(
            painter = painterResource(id = book.image),
            contentDescription = null,
            modifier = Modifier
                .size(136.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterStart)
        )
        Text(
            text = book.title,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(start = 128.dp)
                .align(Alignment.TopStart)
        )
        Text(
            text = book.author,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(start = 128.dp)
                .align(Alignment.TopStart)
        )
    }
}


//Preview composable.
@Composable
@Preview
fun ScreenLibraryPreview() {
    val navController = rememberNavController()
    val viewModel = ScreenLibraryViewModel()
    ScreenLibrary(navController = navController, screenLibraryViewModel = viewModel)
}



