package org.neon.game.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.neon.game.domain.model.GameModel
import org.neon.game.domain.repository.GameRepository

class GetGamesUseCase(private val gameRepository: GameRepository) {

    operator fun invoke() = flow<Result<List<GameModel>>> {
        emit(gameRepository.getGames())
    }.catch { err ->
        emit(Result.failure(err))
    }.flowOn(Dispatchers.IO)
}