package com.carlacampo.booksphere.design

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.R

class ScreenLibraryViewModel: ViewModel(){

    //set, que es mutable y se puede modificar
    private val _Book = MutableLiveData<List<Book>>()
    //get, se coge la lista de los libros
    val book: LiveData<List<Book>> = _Book

    //inicializar la recogida de los valores de los libros
    init {
        _Book.value = getBooksInfo()
    }

    //Lista para definir los libros
    private fun getBooksInfo(): List<Book> {
        return listOf(
            Book("La Comunidad del Anillo", "J. R. R. Tolkien", 2022, "Minotauro", 488, R.drawable.la_comunidad_del_anillo),
            Book("Las Dos Torres", "J. R. R. Tolkien", 2022, "Minotauro", 408, R.drawable.las_dos_torres),
            Book("El Retorno del Rey", "J. R. R. Tolkien", 2022, "Minotauro", 520, R.drawable.el_retorno_del_rey)
        )
    }

}

