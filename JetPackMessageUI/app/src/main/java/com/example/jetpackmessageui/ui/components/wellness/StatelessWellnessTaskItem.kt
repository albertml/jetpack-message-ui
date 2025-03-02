package com.example.jetpackmessageui.ui.components.wellness

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

@Composable
fun StatelessWellnessTaskItem(
    task: WellnessTask,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = task.label
        )

        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}

@Composable
fun StatefulWellnessTaskItem(
    task: WellnessTask,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    StatelessWellnessTaskItem(
        task = task,
        checked = task.checked,
        onCheckedChange = onCheckedChange,
        onClose = onClose,
        modifier = modifier
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun MySootheAppPortraitPreview() {
    JetPackMessageUITheme {
        StatelessWellnessTaskItem(
            task = WellnessTask(1, "Have you take your 15 minute walk today?"),
            checked = false,
            onCheckedChange = {},
            onClose = {}
        )
    }
}