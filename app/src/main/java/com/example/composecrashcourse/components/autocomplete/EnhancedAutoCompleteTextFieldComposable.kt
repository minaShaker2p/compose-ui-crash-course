package com.example.composecrashcourse.components.autocomplete

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EnhancedAutoCompleteTextField() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val suggestions = listOf(
        "Apple", "Banana", "Cherry", "Date", "Grape", "Pineapple",
        "Orange", "Blueberry", "Strawberry", "Mango", "Kiwi", "Peach",
        "Plum", "Raspberry", "Watermelon", "Cantaloupe", "Papaya", "Lemon",
        "Lime", "Apricot", "Blackberry", "Cranberry", "Grapefruit", "Guava",
        "Lychee", "Nectarine", "Pomegranate", "Tangerine", "Coconut",
        "Dragonfruit", "Passionfruit", "Mulberry", "Jackfruit", "Durian", "Persimmon",
        "Fig", "Soursop", "Quince", "Starfruit", "Avocado", "Melon",
        "Cucumber", "Clementine", "Honeydew", "Jujube", "Kumquat"
    )
    var filteredSuggestions by remember { mutableStateOf(suggestions) }
    var showSuggestions by remember { mutableStateOf(false) }
    // FocusRequester to control focus programmatically
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TextField for user input
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    if (newValue.text != textFieldValue.text) {
                        textFieldValue = newValue
                        // Show suggestions only when typing and input is not empty
                        showSuggestions = newValue.text.isNotEmpty()
                        // Update filtered suggestions based on current input
                        filteredSuggestions = if (newValue.text.isEmpty()) {
                            suggestions
                        } else {
                            suggestions.filter { it.contains(newValue.text, ignoreCase = true) }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .focusRequester(focusRequester),
                textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                cursorBrush = SolidColor(Color.Blue),
                decorationBox = { innerTextField ->
                    if (textFieldValue.text.isEmpty()) {
                        Text(
                            text = "Enter Fruit...",
                            style = TextStyle(color = Color.Gray, fontSize = 18.sp)
                        )
                    }
                    innerTextField()
                }
            )
        }
        // Automatically request focus when the UI is composed
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp))
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .animateContentSize()
        ) {
            if (showSuggestions && filteredSuggestions.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    items(filteredSuggestions) { suggestion ->
                        Box(modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    // Update text with selected suggestion and move cursor to the end
                                    textFieldValue = TextFieldValue(
                                        text = suggestion,
                                        selection = TextRange(suggestion.length)
                                    )
                                    // Hide suggestions after selection
                                    showSuggestions = false
                                }
                                .padding(12.dp)
                        ) {
                            Text(
                                text = suggestion,
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            } else if (showSuggestions && filteredSuggestions.isEmpty()) {
                Text(
                    text = "No suggestions available",
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}