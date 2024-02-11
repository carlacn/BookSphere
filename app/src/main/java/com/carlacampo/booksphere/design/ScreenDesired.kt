package com.carlacampo.booksphere.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.flow.StateFlow

//Separate Screen from content
@Composable
fun ScreenDesired(navController: NavHostController, screenDesiredViewModel: ScreenDesiredViewModel = hiltViewModel()) {
    val booksState: StateFlow<List<Book>> = screenDesiredViewModel.books
    val books by booksState.collectAsState()

    ScreenDesiredContent(navController, books)
}
//Content composable. Called in ScreenDesired.
@Composable
fun ScreenDesiredContent(navController: NavHostController, books: List<Book>) {

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
            text = stringResource(R.string.desired),
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
                BookDesiredItem(book = book)
            }
        }
    }
}



//Show books.
@Composable
fun BookDesiredItem(book: Book) {
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
                .padding(top = 48.dp)
                .padding(start = 128.dp)
                .align(Alignment.TopStart)
        )
    }
}


@Composable
@Preview
fun ScreenDesiredPreview() {
    val navController = rememberNavController()
    val viewModel = ScreenDesiredViewModel()
    ScreenDesired(navController = navController, screenDesiredViewModel = viewModel)
}
