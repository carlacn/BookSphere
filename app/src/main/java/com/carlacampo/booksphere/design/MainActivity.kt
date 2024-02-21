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


        /*
        SharedPreferences
        val sharedprefs = this.getSharedPreferences("Shared1", Context.MODE_PRIVATE)
        //sharedprefs.edit().putInt("key1", 1).apply()


        sharedprefs.edit().apply {
            putInt("key1", 1)
            apply()
        }
        val savedShare = sharedprefs.getInt("key1",9)
        Log.d("Lifecycle", "onCreate: $savedShare")
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
