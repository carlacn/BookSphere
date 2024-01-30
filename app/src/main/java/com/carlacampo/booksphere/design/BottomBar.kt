package com.carlacampo.booksphere.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSphereBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(modifier = Modifier.padding(0.dp), text = "8")
                    },
                    contentColor = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            },
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.Blue
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(modifier = Modifier.padding(0.dp), text = "8")
                    },
                    contentColor = Color.White,
                    modifier = Modifier.padding(0.dp)
                )
            },
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.Blue
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(modifier = Modifier.padding(0.dp), text = "8")
                    },
                    contentColor = Color.White,
                    modifier = Modifier.padding(0.dp)
                )
            },
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.Blue
            )
        }
    }

}