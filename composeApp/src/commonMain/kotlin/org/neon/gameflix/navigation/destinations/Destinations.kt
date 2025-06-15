package org.neon.gameflix.navigation.destinations

sealed class Destinations(val route: String) {

    data object Root : Destinations(route = "/gameflix_root")
    data object GameFlixHome : Destinations(route = "/gameflix_home")
}