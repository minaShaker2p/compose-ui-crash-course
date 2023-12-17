package com.example.composecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCrashCourseTheme {
                // A surface container using the 'background' color from the theme

                myApp(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {

                Text(text = if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Composable
private fun myApp(
    names: List<String> = listOf("World ", "Compose"),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (name in names) {
            Greeting(name = name, modifier = modifier)
        }
    }
}

@Composable
private fun onboardingScreen(modifier: Modifier) {


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCrashCourseTheme {
        myApp(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}