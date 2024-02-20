package com.carlacampo.booksphere.design.addbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlacampo.booksphere.data.Book
import com.carlacampo.booksphere.data.BookRepository
import com.carlacampo.booksphere.data.BookRoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddBookScreenViewModel @Inject constructor(
    private val repository: BookRepository,
    private val roomRepository: BookRoomRepository
) : ViewModel() {
    private val _state: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    private val _roomState: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())

    //val state: StateFlow<List<Book>> = _state
    val combinedState: StateFlow<Pair<List<Book>, List<Book>>> = _state.combine(_roomState) { books, roomBooks ->
        Pair(books, roomBooks)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), Pair(emptyList(), emptyList()))


    /*init {
        viewModelScope.launch(context = Dispatchers.IO) {
            _state.value = repository.downloadBook()
        }
    }*/

    //API
    init {
        viewModelScope.launch{
            roomRepository.getCatsFact()
        }
    }


    fun saveBook(book: Book) {
        viewModelScope.launch(context = Dispatchers.IO)  {
            repository.saveBook(book)
            _state.value = repository.downloadBook()
        }
    }

    fun saveRoomBook(book: Book){
        viewModelScope.launch(context = Dispatchers.IO)  {
            roomRepository.saveBook(book)
            _roomState.value = roomRepository.getBooks()
        }
    }

    suspend fun getRoomBooks(): List<Book> {
        return withContext(Dispatchers.IO) {
            roomRepository.getBooks()
        }
    }
}