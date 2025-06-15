package org.neon.game.domain.repository

import org.neon.game.domain.model.GameModel

interface GameRepository {
    suspend fun getGames(): Result<List<GameModel>>
}
