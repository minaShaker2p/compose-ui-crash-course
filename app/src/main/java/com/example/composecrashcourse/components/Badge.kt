package com.example.composecrashcourse.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecrashcourse.ui.theme.ComposeCrashCourseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBadge(number: Int = 0) {

    BadgedBox(badge = {
        Badge {

            Text(
                text = if (number < 100) "$number" else "99+"
            )
        }
    }) {
        Icon(
            imageVector = Icons.Default.Favorite, contentDescription = "Favorite",
            modifier = Modifier.size(40.dp)
        )

    }

}

@Preview
@Composable
fun CustomBadgePreview() {
    ComposeCrashCourseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CustomBadge(number = 100)
        }

    }

}