package org.neon.game.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.neon.game.presentation.GameViewModel

fun getGamePresentationModule() = module {
    viewModel { GameViewModel(getGamesUseCase = get()) }
}