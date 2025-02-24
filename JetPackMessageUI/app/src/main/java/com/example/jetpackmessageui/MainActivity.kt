package com.example.jetpackmessageui

import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackmessageui.ui.components.WelcomeApp
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackMessageUITheme {
                Surface(modifier = Modifier.fillMaxSize()) {

//                    Conversation(messages = SampleData.conversationSample)
//                    Activities()
//                    QuestionPage()
                    WelcomeApp()
                }
            }
        }
    }
}

/*@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MessageCardPreview() {
    JetPackMessageUITheme {
        Surface {
            MessageCard(message = Message(author = "Alberta", body = "Take a look at Jetpack Compose, it's great!"))
        }
    }
}*/

var selectedRadio = false
val activityItems: List<String> = listOf(
    "Messages",
    "Questions"
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

data class Answer(
    val drawableId: Int,
    val text: String,
    val selected: Boolean
)

@Composable
fun QuestionPage() {
    var selectedAnswer by remember { mutableStateOf("") }

    Column(
        Modifier.windowInsetsPadding(androidx.compose.foundation.layout.WindowInsets.statusBars) // Adds top safe area
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

        SingleChoiceQuestion(answers = answers, onAnswerSelected = { selected -> selectedAnswer = selected })

        if (selectedAnswer.isNotEmpty()) {
            Text("You have selected answer: $selectedAnswer", modifier = Modifier
                .padding(horizontal = 12.dp),
                color = Color.Green
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 24.dp, horizontal = 6.dp)
                .background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .height(40.dp)
                        .weight(1f)
                ) {

                    Text(
                        text = "Previous",
                        color = MaterialTheme.colorScheme.primary)
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .height(40.dp)
                        .weight(1f)) {

                    Text(
                        text = "Next",
                        color = Color.White)
                }
            }
        }
    }
}

@Composable
fun SingleChoiceQuestion(answers: List<Answer>, onAnswerSelected: (String) -> Unit) {
    var selectedAnswer: Answer? by rememberSaveable { mutableStateOf(null) }
    LazyColumn {
        items(answers) {
            SurveyAnswer(
                answer = it,
                isSelected = (selectedAnswer == it),
                onAnswerSelected = { _ ->
                    selectedAnswer = it
                    onAnswerSelected(it.text)
                }
            )
        }
    }
}

@Composable
fun SurveyAnswer(answer: Answer, isSelected: Boolean, onAnswerSelected: (Answer) -> Unit) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .border(if (isSelected) 0.dp else 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp)),
        onClick = {
                onAnswerSelected(answer)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(answer.drawableId),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                answer.text,
                fontSize = 18.sp,
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.weight(1f)
            )

            RadioButton(
                selected = isSelected,
                onClick = { onAnswerSelected(answer) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Green, // Color when selected
                    unselectedColor = Color.Gray, // Color when not selected
                    disabledUnselectedColor = Color.LightGray // Color when disabled
                )
            )
        }
    }
}

@Composable
fun Activities() {

    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(activityItems) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text("Activity",
                    fontWeight = FontWeight(weight = 18),
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.fillMaxSize())

                RadioButton(selected = false, onClick = radioSelection)
            }
        }
    }
}

fun toggleRadioSelection() {
    selectedRadio = !selectedRadio
}

val radioSelection: (() -> Unit) = ::toggleRadioSelection

//@Preview(name = "Light Mode")
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun PreviewConversation() {
//    JetPackMessageUITheme {
//        Conversation(SampleData.conversationSample)
//    }
//}

//@Preview
//@Composable
//fun ActivitiesPreview() {
//    JetPackMessageUITheme {
//        Activities()
//    }
//}

@Preview(name = "Light Mode")
@Composable
fun ActivitiesPreview() {
    JetPackMessageUITheme {
        QuestionPage()
    }
}