package com.example.jetpackmessageui.models

import com.example.jetpackmessageui.R

data class Answer(
    val drawableId: Int,
    val text: String,
    val selected: Boolean
)

val answers = listOf(
    Answer(
        drawableId = R.drawable.profile_picture,
        text = "Answer A",
        selected = false
    ),
    Answer(
        drawableId = R.drawable.profile_picture,
        text = "Answer B",
        selected = false
    ),
    Answer(
        drawableId = R.drawable.profile_picture,
        text = "Answer C",
        selected = false
    ),
    Answer(
        drawableId = R.drawable.profile_picture,
        text = "Answer D",
        selected = false
    ),
)