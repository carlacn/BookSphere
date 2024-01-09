package com.carlacampo.booksphere

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlacampo.booksphere.ui.theme.BookSphereTheme
import androidx.compose.material3.Scaffold as Scaffold


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSphereTheme {
                MainActivityContent(backgroundImage = painterResource(id = R.drawable.background))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainActivityContent(backgroundImage: Painter) {
    //Estructura de la interfaz
    Scaffold(
        topBar = {
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
                                .padding(start = 1.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color(17, 76, 95),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                modifier = Modifier.height(30.dp)
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(240, 240, 240))
                    .padding(top = 50.dp)
                    .padding(start = 10.dp)
            ) {
                Image(
                    painter = backgroundImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Box 1
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(75.dp)
                                .background(Color(123,76,72), shape = MaterialTheme.shapes.small)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Biblioteca",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp)
                                    .size(24.dp),
                                textAlign = TextAlign.Center
                            )
                        }

                        // Box 2
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(75.dp)
                                .background(Color(35,156,166), shape = MaterialTheme.shapes.small)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Lectura\nActual",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.dp)
                                    .size(24.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        // Box 3
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(75.dp)
                                .background(Color(232,71,27), shape = MaterialTheme.shapes.small)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Deseados",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp)
                                    .size(24.dp),
                                textAlign = TextAlign.Center
                            )
                        }

                        // Box 4
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(75.dp)
                                .background(Color(234,159,40), shape = MaterialTheme.shapes.small)
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Estadísticas",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp)
                                    .size(24.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 220.dp)
                        .padding(start = 45.dp)
                ) {
                    item {
                        OptionsList(name = "Series", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                    item {
                        OptionsList(name = "Categorías", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                    item {
                        OptionsList(name = "Autores", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                    item {
                        OptionsList(name = "Año", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                    item {
                        OptionsList(name = "Leídos", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                    item {
                        OptionsList(name = "Pendientes", modifier = Modifier.fillMaxSize())
                        AddOption()
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { /* Handle icon click */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(
                        onClick = { /* Handle icon click */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(
                        onClick = { /* Handle icon click */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    )
}


@Composable
fun OptionsList(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name, modifier = Modifier, color = Color(17, 76, 95),
        style = LocalTextStyle.current.copy(fontSize = 20.sp)
    )
}

@Composable
fun AddOption() {
    Text(
        text = "+ Agregar",
        modifier = Modifier.fillMaxSize(),
        style = LocalTextStyle.current.copy(fontSize = 12.sp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    BookSphereTheme {
        MainActivityContent(backgroundImage = painterResource(id = R.drawable.background))
    }
}