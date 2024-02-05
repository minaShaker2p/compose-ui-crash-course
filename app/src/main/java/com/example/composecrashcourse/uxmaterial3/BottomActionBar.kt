package com.example.composecrashcourse.uxmaterial3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecrashcourse.ui.theme.ComposeCrashCourseTheme

@Composable
fun BottomActionBar() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share contact"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Mark as favorite"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email contact"
                    )
                }
            }, floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "Call contact")
                }
            })

        }) { paddingValues ->

    }
}

@Preview
@Composable
fun BottomActionBarPreview() {
    ComposeCrashCourseTheme {
        BottomActionBar()
    }

}