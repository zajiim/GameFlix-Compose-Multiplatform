package org.neon.game.presentation

import org.neon.game.domain.model.GameModel

data class GameState(
    val isLoading: Boolean = false,
    val error: String = "",
    val games: List<GameModel> = emptyList()
)
