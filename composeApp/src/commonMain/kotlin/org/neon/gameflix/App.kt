package org.neon.gameflix

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.neon.gameflix.navigation.GameFlixNavGraph
import org.neon.gameflix.navigation.destinations.Destinations

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Destinations.Root.route
        ) {
            listOf(GameFlixNavGraph).forEach {
                it.build(
                    modifier = Modifier.fillMaxSize(),
                    navHostController = navController,
                    navGraphBuilder = this
                )
            }
        }
    }
}