package org.neon.gameflix.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.neon.coreNetwork.di.getCoreNetworkModule
import org.neon.game.data.di.getGameDataModule
import org.neon.game.domain.di.getGameDomainModule
import org.neon.game.presentation.di.getGamePresentationModule

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        modules(
            getCoreNetworkModule(),
            getGameDataModule(),
            getGameDomainModule(),
            getGamePresentationModule()
        )
    }
}