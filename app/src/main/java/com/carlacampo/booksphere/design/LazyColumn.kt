package com.carlacampo.booksphere.design

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlacampo.booksphere.R

@Composable
fun LazyColumnMain(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 224.dp)
            .padding(start = 48.dp)
    ) {
        item {
            OptionsList(name = stringResource(R.string.series), modifier = Modifier.fillMaxSize())
            AddOption()
        }
        item {
            OptionsList(name = stringResource(R.string.categories), modifier = Modifier.fillMaxSize())
            AddOption()
        }
        item {
            OptionsList(name = stringResource(R.string.authors), modifier = Modifier.fillMaxSize())
            AddOption()
        }
        item {
            OptionsList(name = stringResource(R.string.year), modifier = Modifier.fillMaxSize())
            AddOption()
        }
        item {
            OptionsList(name = stringResource(R.string.read), modifier = Modifier.fillMaxSize())
            AddOption()
        }
        item {
            OptionsList(name = stringResource(R.string.pending), modifier = Modifier.fillMaxSize())
            AddOption()
        }
    }
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
        text = stringResource(R.string.add),
        modifier = Modifier.fillMaxSize(),
        style = LocalTextStyle.current.copy(fontSize = 12.sp)
    )
}
