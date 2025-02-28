package com.example.jetpackmessageui.ui.survey.sample

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackmessageui.R
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

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

@Preview
@Composable
fun ActivitiesPreview() {
    JetPackMessageUITheme {
        Activities()
    }
}