package org.neon.gameflix

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.neon.gameflix.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GameFlix",
    ) {
        initKoin()
        App()
    }
}