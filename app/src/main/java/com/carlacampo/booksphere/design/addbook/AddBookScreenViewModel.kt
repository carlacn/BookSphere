package com.carlacampo.booksphere.design.addbook

import android.content.ContentValues
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlacampo.booksphere.bbdd.BookDBScheme
import com.carlacampo.booksphere.bbdd.BooksDBHelper
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.data.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddBookScreenViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {
    private val _state: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val state: StateFlow<List<Book>> = _state

    init {
        viewModelScope.launch {
            _state.value = repository.downloadBook()
        }
    }

    fun saveBook(book: Book) {
        viewModelScope.launch {
            repository.saveBook(book)
            _state.value = repository.downloadBook()
        }
    }
}