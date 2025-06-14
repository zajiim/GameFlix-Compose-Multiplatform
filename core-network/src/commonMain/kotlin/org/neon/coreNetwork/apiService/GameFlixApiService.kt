package org.neon.coreNetwork.apiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.neon.coreNetwork.model.GameItem

class GameFlixApiService(
    val httpClient: HttpClient
) {
    suspend fun getGames(): Result<List<GameItem>> {
        return try {
            val response = httpClient.get("api/games").body<List<GameItem>>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}