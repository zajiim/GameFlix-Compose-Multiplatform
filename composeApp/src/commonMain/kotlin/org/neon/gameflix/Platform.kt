package org.neon.gameflix

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform