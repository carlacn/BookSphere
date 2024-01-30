package com.carlacampo.booksphere.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.carlacampo.booksphere.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSphereTopBar(){
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imgapp),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)

                )
                Text(
                    "BookSphere",
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(17, 76, 95),
                    textAlign = TextAlign.Center
                )
            }
        },
        modifier = Modifier.height(40.dp)
    )
}