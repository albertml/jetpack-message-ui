package com.example.jetpackmessageui.ui.survey

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackmessageui.R

@Composable
fun SurveyAnswer(
    answer: Answer,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onSelected: (Boolean) -> Unit
) {
    Surface(
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outline
        ),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 12.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White,
        onClick = { onSelected(!answer.selected) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(answer.drawableId),
                contentDescription = null, 
                modifier = Modifier
                    .size(50.dp)
            )

            Text(
                answer.text,
                modifier = Modifier.weight(1f)
                    .padding(horizontal = 8.dp)
            )

            RadioButton(
                selected = answer.selected,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Green,
                    unselectedColor = Color.Gray,
                    disabledUnselectedColor = Color.LightGray
                ),
                onClick = { onSelected(!answer.selected) }
            )
        }
    }
}

@Preview
@Composable
fun SurveyAnswerPreview() {
    SurveyAnswer(answer = Answer(
        drawableId = R.drawable.profile_picture,
        text = "Spark",
        selected = false),
        isSelected = false,
        onSelected = {}
    )
}