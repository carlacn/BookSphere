package com.carlacampo.booksphere.design

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenLibraryViewModel @Inject constructor(): ViewModel(){

    //Set, which is mutable and can be modified.
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    //Get, take the list of books.
    val books: StateFlow<List<Book>> = _books

    //Initialize collection of book values.
    init {
        viewModelScope.launch {
            _books.value = getBooksInfo()
        }
    }

    //List to define the books.
    private fun getBooksInfo(): List<Book> {
        return listOf(
            Book("La Comunidad del Anillo", "J. R. R. Tolkien", 2022, "Minotauro", 488, R.drawable.la_comunidad_del_anillo),
            Book("Las Dos Torres", "J. R. R. Tolkien", 2022, "Minotauro", 408, R.drawable.las_dos_torres),
            Book("El Retorno del Rey", "J. R. R. Tolkien", 2022, "Minotauro", 520, R.drawable.el_retorno_del_rey)
        )
    }

}

