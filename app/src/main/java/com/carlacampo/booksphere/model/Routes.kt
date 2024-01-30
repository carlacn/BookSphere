package com.carlacampo.booksphere.model

sealed class Routes(val route:String) {

    object MainActivityContent:Routes("MainActivityContent")
    object ScreenLibrary:Routes("ScreenLibrary")
    object ScreenCurrentRead:Routes("ScreenCurrentRead")
    object ScreenDesired:Routes("ScreenDesired")
    object ScreenStats:Routes("ScreenStats")
}