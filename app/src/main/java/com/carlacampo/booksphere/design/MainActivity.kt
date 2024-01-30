package com.carlacampo.booksphere.design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlacampo.booksphere.model.Routes
import com.carlacampo.booksphere.ui.theme.BookSphereTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSphereTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = Routes.MainActivityContent.route){
                    composable(Routes.MainActivityContent.route){ MainActivityContent(navigationController) }
                    composable(Routes.ScreenLibrary.route){ ScreenLibrary(navigationController) }
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
