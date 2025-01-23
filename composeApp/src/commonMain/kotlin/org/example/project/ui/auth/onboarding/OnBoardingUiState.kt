package org.example.project.ui.auth.onboarding

import org.jetbrains.compose.resources.DrawableResource

data class OnBoardingData(
    val heading: List<String> = listOf(),
    val description: List<String> = listOf(),
    val assets: List<DrawableResource> = listOf(),
)

data class OnBoardingUiState(
    val data: OnBoardingData = OnBoardingData(),
    val currentIndex: Int = 0,
    val enableButton: Boolean = false,
)