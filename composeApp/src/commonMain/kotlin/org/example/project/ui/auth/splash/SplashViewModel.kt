package org.example.project.ui.auth.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class SplashViewModel  : ViewModel() {
    private val _splashUiState = mutableStateOf<SplashUiState>(SplashUiState.SplashLoading);
    val splashState  = _splashUiState;
    init {
        viewModelScope.launch {
            delay(500);
            _splashUiState.value = SplashUiState.SplashLoaded;
        }
    }

}