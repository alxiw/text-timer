package io.github.alxiw.texttimer.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun TextTimerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}