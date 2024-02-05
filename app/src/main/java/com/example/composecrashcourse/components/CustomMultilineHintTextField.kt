package com.example.composecrashcourse.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun MultilineHintTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String = "",
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    maxLines: Int = 4,
) {

    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        maxLines = maxLines,
        modifier = modifier,
        decorationBox = { innerTextField ->
            Box(modifier = modifier) {
                if (value.isEmpty()) {
                    Text(text = hint, color = LocalContentColor.current.copy(alpha = 0.5f))
                }
            }
            innerTextField()
        }
    )
}