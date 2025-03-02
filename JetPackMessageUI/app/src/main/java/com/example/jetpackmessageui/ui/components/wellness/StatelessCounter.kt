package com.example.jetpackmessageui.ui.components.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }

            if (showTask) {
                StatefulWellnessTaskItem(
                    task = WellnessTask(1, "Have you taken your 15 minute walk today?"),
                    onCheckedChange = {},
                    onClose = {}
                )
            }

            Text(
                text = "You've had $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Button(
                onClick = onIncrement,
                enabled = count < 10
            ) {
                Text(text = "Add One")
            }

            Button(
                onClick = onClear,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Clear water count")
            }
        }
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        onClear = { count = 0 },
        modifier = modifier
    )
}