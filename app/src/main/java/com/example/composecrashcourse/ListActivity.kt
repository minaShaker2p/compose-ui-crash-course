package com.example.composecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

                MyApp(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, name: String) {
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
private fun MyApp(
    modifier: Modifier = Modifier
) {
    var shouldShowOnboarding by remember {
        mutableStateOf(true)
    }
    Surface(modifier) {
        if (shouldShowOnboarding)
            OnboardingScreen {
                shouldShowOnboarding = false
            }
        else
            Greetings()
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World ", "Compose"),

    ) {
    Column(modifier = modifier) {
        for (name in names) {
            Greeting(name = name, modifier = modifier)
        }
    }
}

@Composable
private fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {


    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to  the Basics Codelab")
        Button(modifier = Modifier.padding(vertical = 24.dp), onClick = {
            onContinueClicked.invoke()
        }) {
            Text(text = "Continue")
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeCrashCourseTheme {
        OnboardingScreen(onContinueClicked = { })// Do Nothing on click
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposeCrashCourseTheme {
        Greetings()
    }
}