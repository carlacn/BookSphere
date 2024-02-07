package com.carlacampo.booksphere.design

import android.content.ContentValues
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.bbdd.BookDBScheme
import com.carlacampo.booksphere.bbdd.BooksDBHelper
import com.carlacampo.booksphere.model.Routes
import com.carlacampo.booksphere.ui.theme.BookSphereTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val screenLibraryViewModel: ScreenLibraryViewModel by viewModels()
        //una variable por cada view model que tenga y se llaman todos en este main

        val dbHelper = BooksDBHelper (this)
        val writableDB = dbHelper.readableDatabase
        /* writableDB.execSQL(
            """
                INSERT INTO ${BookDBScheme.TABLE_NAME}(
                    ${BookDBScheme.COLUMN_NAME},
                    ${BookDBScheme.COLUMN_AUTHOR},
                    ${BookDBScheme.COLUMN_PUBLICATION_YEAR},
                    ${BookDBScheme.COLUMN_EDITORIAL},
                    ${BookDBScheme.COLUMN_PAGES}
                )
                VALUES("El Silmarillion", "J. R. R. Tolkien", 1901, "Booket", 448)
            """.trimIndent()
        )
        */

        val values = ContentValues().apply {
            put(BookDBScheme.COLUMN_NAME, "El Hobbit")
            put(BookDBScheme.COLUMN_AUTHOR, "J. R. R. Tolkien")
            put(BookDBScheme.COLUMN_PUBLICATION_YEAR, 2022)
            put(BookDBScheme.COLUMN_EDITORIAL, "Booket")
            put(BookDBScheme.COLUMN_PAGES, 288)
        }
        writableDB.insert(BookDBScheme.TABLE_NAME, null, values)

        super.onCreate(savedInstanceState)
        setContent {
            BookSphereTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = Routes.MainActivityContent.route){
                    composable(Routes.MainActivityContent.route){ MainActivityContent(navigationController) }
                    composable(Routes.ScreenLibrary.route){ ScreenLibrary(navigationController, screenLibraryViewModel = screenLibraryViewModel) }
                    composable(Routes.ScreenCurrentRead.route){ ScreenCurrentRead(navigationController) }
                    composable(Routes.ScreenDesired.route){ ScreenDesired(navigationController) }
                    composable(Routes.ScreenStats.route){ ScreenStats(navigationController) }
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
