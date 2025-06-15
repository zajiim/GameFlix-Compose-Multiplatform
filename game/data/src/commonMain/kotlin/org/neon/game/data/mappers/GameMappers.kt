package org.neon.game.data.mappers

import org.neon.coreNetwork.dto.GameItemDto
import org.neon.game.domain.model.GameModel

fun List<GameItemDto>.toGameModelList(): List<GameModel> = map {
    GameModel(
        id = it.id,
        thumbnail = it.thumbnail,
        title = it.title
    )
}

fun GameItemDto.toGameModel(): GameModel = GameModel(
    id = id,
    thumbnail = thumbnail,
    title = title
)