package org.neon.game.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.neon.game.domain.usecases.GetGamesUseCase

class GameViewModel(
    private val getGamesUseCase: GetGamesUseCase
): ViewModel() {

//    var uiState by mutableStateOf<GameState>(GameState())
//        private set

    private val _uiState = MutableStateFlow(GameState())
    val uiState = _uiState.asStateFlow()


    init {
        getGames()
    }

    fun getGames() = getGamesUseCase.invoke()
        .onStart {
//        uiState = uiState.copy(isLoading = true)
        _uiState.update { GameState(isLoading = true) }
    }.onEach { result ->
        result.onSuccess { data ->
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    games = data
                )
            }

//            _uiState.update {
//                GameState(
//                    isLoading = false,
//                    games = data
//                )
//            }
//            )
        }.onFailure { err ->
//            uiState = uiState.copy(
//                isLoading = false,
//                error = err.message ?: "Unknown error"
//            )

            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    error = err.message ?: "Unknown error"
                )
            }
        }
    }.launchIn(viewModelScope)

    /*fun getGames() = viewModelScope.launch {
        getGamesUseCase().collect { result ->
            result.onSuccess { data ->
                uiState = uiState.copy(
                    isLoading = false,
                    games = data
                )
            }.onFailure { err ->
                uiState = uiState.copy(
                    isLoading = false,
                    error = err.message ?: "Unknown error"
                )
            }
        }
    }*/


}