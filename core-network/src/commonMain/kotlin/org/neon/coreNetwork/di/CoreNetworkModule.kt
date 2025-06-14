package org.neon.coreNetwork.di

import org.koin.dsl.module
import org.neon.coreNetwork.apiService.GameFlixApiService
import org.neon.coreNetwork.client.KtorClient

fun getCoreNetworkModule() = module {
    single { GameFlixApiService(httpClient = KtorClient.getInstance()) }
}