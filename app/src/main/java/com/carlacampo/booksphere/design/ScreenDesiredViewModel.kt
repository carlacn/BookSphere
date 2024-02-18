package com.carlacampo.booksphere.design

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.data.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenDesiredViewModel @Inject constructor(): ViewModel(){
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    init {
        viewModelScope.launch {
            _books.value = getDesiredBooksInfo()
        }
    }
}
private fun getDesiredBooksInfo(): List<Book> {
    return listOf(
        Book("Harry Potter y la Piedra Filosofal", "J. k. Rowling", 2020, "Minalima", 368),
        Book("Harry Potter y la Cámara Secreta", "J. k. Rowling", 2021, "Minalima", 400),
        Book("Harry Potter y el Prisionero de Azkaban", "J. k. Rowling", 2023, "Minalima", 480)
    )
}
