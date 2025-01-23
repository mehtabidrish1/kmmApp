
package org.example.project.ui.auth.splash

interface SplashUiState {
    data object SplashLoaded : SplashUiState
    object SplashLoading : SplashUiState
    object SplashError : SplashUiState
}