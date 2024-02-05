package com.example.composecrashcourse.components.swipetodelete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SwipeToDeleteExampleScreen() {

    val programmingLanguages = remember {
        mutableStateListOf(
            "Kotlin",
            "Java",
            "C++",
            "C#",
            "Java Script",
            "Python",
            "Type Script"
        )
    }

    LazyColumn(modifier = Modifier.fillMaxSize())
    {
        items(items = programmingLanguages, key = { it }) { language ->
            SwipeToDeleteContainer(item = language, onDelete = {
                programmingLanguages -= language
            }) { language ->
                Text(
                    text = language,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                )
            }
        }

    }

}