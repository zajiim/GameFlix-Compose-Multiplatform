package org.neon.game.data.repository

import org.neon.coreNetwork.apiService.GameFlixApiService
import org.neon.game.data.mappers.toGameModel
import org.neon.game.data.mappers.toGameModelList
import org.neon.game.domain.model.GameModel
import org.neon.game.domain.repository.GameRepository

class GameRepoImpl(
    private val gameFlixApiService: GameFlixApiService
): GameRepository {

    override suspend fun getGames(): Result<List<GameModel>> {
        val result = gameFlixApiService.getGames()
        if (result.isSuccess) {
            val result = result.getOrThrow()
             return Result.success(result.toGameModelList())
        } else {
             return Result.failure(result.exceptionOrNull() ?: Exception("Unknown error"))
        }
    }
}