package com.carlacampo.booksphere.design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.bbdd.BooksDBHelper
import com.carlacampo.booksphere.design.addbook.AddBookScreen
import com.carlacampo.booksphere.design.addbook.AddBookScreenViewModel
import com.carlacampo.booksphere.model.Routes
import com.carlacampo.booksphere.ui.theme.BookSphereTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val screenLibraryViewModel: ScreenLibraryViewModel by viewModels()
        val screenCurrentReadViewModel: ScreenCurrentReadViewModel by viewModels()
        val screenDesiredViewModel: ScreenDesiredViewModel by viewModels()
        val addBookScreenViewModel: AddBookScreenViewModel by viewModels()

        //A variable for each view model you have and they are all called in this main.

        /*val dbHelper = BooksDBHelper(this)
        val writableDB = dbHelper.readableDatabase
         writableDB.execSQL(
            """
                INSERT INTO ${BookDBScheme.TABLE_NAME}(d
                    ${BookDBScheme.COLUMN_NAME},
                    ${BookDBScheme.COLUMN_AUTHOR},
                    ${BookDBScheme.COLUMN_PUBLICATION_YEAR},
                    ${BookDBScheme.COLUMN_EDITORIAL},
                    ${BookDBScheme.COLUMN_PAGES}
                )
                VALUES("El Silmarillion", "J. R. R. Tolkien", 1901, "Booket", 448)
            """.trimIndent()
        )


        val values = ContentValues().apply {
            put(BookDBScheme.COLUMN_NAME, "El Hobbit")
            put(BookDBScheme.COLUMN_AUTHOR, "J. R. R. Tolkien")
            put(BookDBScheme.COLUMN_PUBLICATION_YEAR, 2022)
            put(BookDBScheme.COLUMN_EDITORIAL, "Booket")
            put(BookDBScheme.COLUMN_PAGES, 288)
        }
        writableDB.insert(BookDBScheme.TABLE_NAME, null, values)
   */
        super.onCreate(savedInstanceState)
        setContent {
            BookSphereTheme {
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.MainActivityContent.route
                ) {
                    composable(Routes.MainActivityContent.route) {
                        MainActivityContent(
                            navigationController
                        )
                    }
                    composable(Routes.ScreenLibrary.route) {
                        ScreenLibrary(
                            navigationController,
                            screenLibraryViewModel = screenLibraryViewModel
                        )
                    }
                    composable(Routes.ScreenCurrentRead.route) {
                        ScreenCurrentRead(
                            navigationController,
                            screenCurrentReadViewModel = screenCurrentReadViewModel
                        )
                    }
                    composable(Routes.ScreenDesired.route) {
                        ScreenDesired(
                            navigationController,
                            screenDesiredViewModel = screenDesiredViewModel
                        )
                    }
                    composable(Routes.ScreenStats.route) { ScreenStats(navigationController) }
                    composable(Routes.ScreenAddBook.route) {
                        AddBookScreen(
                            navigationController
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainActivityContent(navController = rememberNavController())
}
