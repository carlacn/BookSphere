package com.carlacampo.booksphere.design

import androidx.lifecycle.ViewModel
import com.carlacampo.booksphere.R
import com.carlacampo.booksphere.data.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ScreenCurrentReadViewModel @Inject constructor(): ViewModel(){

    private val _currentRead = MutableStateFlow(Book( "La Sabiduría de las Multitudes","Joe Abercrombie", 2022, "Alianza Editorial", 744, R.drawable.la_sabiduria_de_las_multitudes))
    val currentReadBook: StateFlow<Book>
        get() = _currentRead
}

