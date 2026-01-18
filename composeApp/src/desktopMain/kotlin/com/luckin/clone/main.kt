```kotlin
package com.luckin.clone

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.unit.dp
import com.luckin.clone.data.repository.MockProductRepository

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Luckin Coffee Clone",
        state = rememberWindowState(width = 420.dp, height = 900.dp)
    ) {
        val repository = MockProductRepository()
        App(repository)
    }
}
```
