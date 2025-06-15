package org.neon.coreNetwork.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameItemDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("title")
    val title: String?
)