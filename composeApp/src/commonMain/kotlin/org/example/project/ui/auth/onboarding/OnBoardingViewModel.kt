package org.example.project.ui.auth.onboarding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmmapp.composeapp.generated.resources.Res
import kmmapp.composeapp.generated.resources.on_boarding_1
import kmmapp.composeapp.generated.resources.on_boarding_2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OnBoardingViewModel  : ViewModel() {
    private val onBoardingData = OnBoardingData(
        heading = listOf(
            "Lorem Ipsum lor sit amet",
            "Lorem Ipsum lor sit amet",
            "Lorem Ipsum lor sit amet"
        ),
        assets = listOf(
          Res.drawable.on_boarding_1,
          Res.drawable.on_boarding_2,
          Res.drawable.on_boarding_1,
        ),
        description = listOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
        ),
    )
    private val _onboardingUiState =
        mutableStateOf<OnBoardingUiState>(OnBoardingUiState(data = onBoardingData))
    val onboardingState = _onboardingUiState;

    init {
        viewModelScope.launch {
            for (n in 0..2) {

               _onboardingUiState.value =  _onboardingUiState.value.copy(
                    currentIndex = n,
                    enableButton = n == 2
                )
                delay(3000)
            }
        }
    }
}