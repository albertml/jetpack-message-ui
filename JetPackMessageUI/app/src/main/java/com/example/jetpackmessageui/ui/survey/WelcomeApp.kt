package com.example.jetpackmessageui.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun WelcomeApp() {
    var isDoneOnboarding by rememberSaveable { mutableStateOf(false) }

    if (isDoneOnboarding) {
        QuestionPage(
            questions = answers,
            shouldAsPermissions = false,
            onDoNotAskForPermission = { askPermission() },
            onAction = ::surveyAction,
            onDonePressed = { donePress() },
            onBackPressed = { backPress() }
        )
    } else {
        OnboardingScreen(
            onOnboardingClicked = { isOnboarded -> isDoneOnboarding = isOnboarded }
        )
    }
}

fun askPermission(): Unit {

}

fun donePress(): Unit {
    println("Next Pressed")
}

fun backPress(): Unit {
    println("Back Pressed")
}

fun surveyAction(deny: Int, accept: Int): Unit {
    println(accept)
    println(deny)
}