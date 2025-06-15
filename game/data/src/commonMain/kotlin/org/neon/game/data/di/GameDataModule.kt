package org.neon.game.data.di

import org.koin.dsl.module
import org.neon.game.data.repository.GameRepoImpl
import org.neon.game.domain.repository.GameRepository

fun getGameDataModule() = module {
    factory<GameRepository> { GameRepoImpl(gameFlixApiService = get()) }
}