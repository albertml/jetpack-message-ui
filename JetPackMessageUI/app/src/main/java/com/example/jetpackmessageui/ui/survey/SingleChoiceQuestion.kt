package com.example.jetpackmessageui.ui.survey

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun SingleChoiceQuestion(answers: List<Answer>, onAnswerSelected: (String) -> Unit) {
    var selectedAnswer: Answer? by rememberSaveable { mutableStateOf(null) }
    LazyColumn() {
        items(answers) {
            SurveyAnswer(
                answer = it,
                isSelected = it.text == selectedAnswer?.text,
                onSelected = { _ ->
                    selectedAnswer = it
                    onAnswerSelected(it.text)
                }
            )
        }
    }
}