package com.carlacampo.booksphere.design.addbook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.data.BookRepository
import com.carlacampo.booksphere.model.Routes

@Composable
fun AddBookScreen(
    navController: NavHostController,
    addBookScreenViewModel: AddBookScreenViewModel = hiltViewModel()
) {
    val combinedState = addBookScreenViewModel.combinedState.collectAsState().value
    val state = combinedState.first
    val roomState = combinedState.second

    AddBookContent(
        state = combinedState.first,
        roomState = combinedState.second,
        addBook = { book ->
            addBookScreenViewModel.saveBook(book)
        },
        navController = navController,
        addbookRoom =  { book ->
            addBookScreenViewModel.saveRoomBook(book)
        }
    )

}

@Composable
fun AddBookContent(
    state: List<Book> = emptyList(),
    roomState: List<Book> = emptyList(),
    addBook: (Book) -> Unit = {},
    navController: NavHostController,
    addbookRoom: (Book) -> Unit = {}
) {

    val book = Book(
        "Loba Negra 2", "Juan Gómez-Jurado", 2020, "PRH Grupo Editorial", 522
    )
    val book2 = Book(
        "Reina Roja", "Juan Gómez-Jurado", 2018, "PRH Grupo Editorial", 568
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#F4F4F4")))
    )
    {
        // Icono de retroceso
        Icon(
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp, top = 8.dp)
                .clickable {
                    navController.navigate(
                        Routes.MainActivityContent.route
                    )
                },
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = "Back",
            tint = Color.Black
        )
        // Título
        Text(
            text = "BookSphere",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 8.dp, start = 32.dp)
                .align(Alignment.TopStart)
                .clickable {
                    navController.navigate(
                        Routes.MainActivityContent.route
                    )
                }
        )
        // Texto
        Text(
            text = stringResource(R.string.addBook),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp)
                .align(Alignment.TopStart)
        )
        // Botón para agregar un libro
        Button(
            onClick = { addBook(book) },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp)
        ) {
            Text(text = stringResource(R.string.addBook))
        }
        LazyColumn(
            modifier = Modifier
                .padding(
                    top = 128.dp,
                    start = 8.dp
                )
        ) {
            items(state) { book ->
                BookItem(book)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Add Book Room",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )
            Button(
                onClick = { addbookRoom(book2) },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 64.dp)
            ) {
                Text(text = stringResource(R.string.addBook))
            }
            LazyColumn(
                modifier = Modifier
                    .padding(top = 128.dp, start = 8.dp)
            ) {
                items(roomState) { roomBook ->
                    BookItemRoom(roomBook)
                }
            }
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Row {
        Text(text = "Title: ${book.title}, Author: ${book.author}")
    }
}

@Composable
fun BookItemRoom(book: Book) {
    Row {
        Text(text = "Title: ${book.title}, Author: ${book.author}")
    }
}


