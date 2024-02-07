package com.example.composecrashcourse.uxmaterial3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecrashcourse.ui.theme.ComposeCrashCourseTheme


@Composable
fun Buttons() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Filled Button
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Confirm")
        }

        Spacer(modifier = Modifier.height(10.dp))

        //Elevated Button , this button has a shadow
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add to card",
                modifier = Modifier.size(18.dp) // recommended size
            )
            Spacer(modifier = Modifier.height(8.dp)) // recommended space
            Text(text = "Add to cart")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Filled Tonal Button

        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Open in browser")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Outlined button
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Back")
        }

        // Text Button

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn more")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ComposeCrashCourseTheme {
        Buttons()
    }

}