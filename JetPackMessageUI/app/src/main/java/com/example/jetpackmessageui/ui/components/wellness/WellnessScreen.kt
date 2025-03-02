package com.example.jetpackmessageui.ui.components.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StatefulCounter(modifier = modifier)

        val list = wellnessViewModel.tasks
        WellnessTasksList(
            list = list,
            onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun MySootheAppPortraitPreview() {
    JetPackMessageUITheme {
        WellnessScreen()
    }
}