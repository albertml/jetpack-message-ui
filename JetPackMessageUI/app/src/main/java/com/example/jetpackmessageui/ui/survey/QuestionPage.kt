package com.example.jetpackmessageui.ui.survey

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionPage(
    questions: List<Answer> = listOf(),
    shouldAsPermissions: Boolean,
    onDoNotAskForPermission: () -> Unit,
    onAction: (Int, Int) -> Unit,
    onDonePressed: () -> Unit,
    onBackPressed: () -> Unit
) {
    var selectedAnswer by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.windowInsetsPadding(androidx.compose.foundation.layout.WindowInsets.statusBars),
        topBar = { TopBarView() },
        bottomBar = { BottomBarView(
            onBackPressed = onBackPressed,
            onDonePressed = onDonePressed
        ) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Pick a Compose Comic Character",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp, horizontal = 12.dp)
                    )
                }

                Text(
                    text = "Select one",
                    fontWeight = FontWeight.Bold, fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                )

                SingleChoiceQuestion(answers = questions, onAnswerSelected = { selected -> selectedAnswer = selected })

                if (selectedAnswer.isNotEmpty()) {
                    Text("You have selected answer: $selectedAnswer", modifier = Modifier
                        .padding(horizontal = 12.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

        }
    )
}