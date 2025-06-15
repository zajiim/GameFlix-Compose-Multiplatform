package org.neon.gameflix.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.neon.game.presentation.GameScreen
import org.neon.gameflix.navigation.destinations.Destinations

object GameFlixNavGraph: BaseNavGraph {
    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = Destinations.Root.route,
            startDestination = Destinations.GameFlixHome.route) {
            composable(route = Destinations.GameFlixHome.route) {

                GameScreen(modifier = modifier.fillMaxSize(),
                    onFavClick = {

                    })
            }
        }
    }
}