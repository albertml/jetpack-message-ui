package com.example.jetpackmessageui.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun WelcomeApp() {
    var isDoneOnboarding by rememberSaveable { mutableStateOf(false) }

    if (isDoneOnboarding) {
        WelcomeList(welcomeItems = welcomeItems)
    } else {
        OnboardingScreen(
            onOnboardingClicked = { isOnboarded -> isDoneOnboarding = isOnboarded }
        )
    }
}