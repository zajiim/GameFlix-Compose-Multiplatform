package org.neon.coreNetwork.apiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import org.neon.coreNetwork.dto.GameItemDto

class GameFlixApiService(
    val httpClient: HttpClient
) {
    suspend fun getGames(): Result<List<GameItemDto>> {
        return try {

//            val rawJson = httpClient.get("api/games").body<String>()
//            println("RAW JSON RESPONSE:\n$rawJson")
//            val games = Json.decodeFromString<List<GameItemDto>>(rawJson)

            val response = httpClient.get("api/games"){contentType(ContentType.Application.Json)}.body<List<GameItemDto>>()
            Result.success(response)
//            Result.success(games)
        } catch (e: Exception) {
            println("Error:\n${e.message}")
            Result.failure(e)
        }
    }
}