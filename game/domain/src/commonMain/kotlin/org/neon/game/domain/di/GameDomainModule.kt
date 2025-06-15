package org.neon.game.domain.di

import org.koin.dsl.module
import org.neon.game.domain.usecases.GetGamesUseCase

fun getGameDomainModule() = module {
    factory { GetGamesUseCase(gameRepository = get()) }
}