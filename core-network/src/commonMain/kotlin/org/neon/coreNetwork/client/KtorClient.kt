package org.neon.coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    fun getInstance(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
                explicitNulls = false
                isLenient = true
            })
        }
//        "https://www.freetogame.com/api/games"
        install(DefaultRequest) {
            url {
                host = "www.freetogame.com"
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 3000L
            connectTimeoutMillis = 3000L
            requestTimeoutMillis = 3000L
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("Ktor Log: $message")
                }
            }
            level = LogLevel.ALL
        }
    }
}