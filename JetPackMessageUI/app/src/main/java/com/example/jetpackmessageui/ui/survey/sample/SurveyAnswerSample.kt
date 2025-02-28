package com.example.jetpackmessageui.ui.survey.sample

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackmessageui.R
import com.example.jetpackmessageui.ui.survey.Answer
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

var selectedRadio = false
val activityItems: List<String> = listOf(
    "Messages",
    "Questions"
)

@Composable
fun SurveyAnswerSample(answer: Answer, isSelected: Boolean, onAnswerSelected: (Answer) -> Unit) {
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

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MessageCardPreview() {
    JetPackMessageUITheme {
        Surface {
            SurveyAnswerSample(answer = Answer(
                drawableId = R.drawable.profile_picture,
                text = "Spark",
                selected = false),
                isSelected = false,
                onAnswerSelected = {}
            )
        }
    }
}