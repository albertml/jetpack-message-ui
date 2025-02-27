package com.example.jetpackmessageui.ui.components.meditation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

@Composable
fun MySootheAppPortrait() {
    JetPackMessageUITheme {
        Scaffold(
            bottomBar = {
                SootheBottomNavigation()
            }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun MySootheAppPortraitPreview() {
    JetPackMessageUITheme {
        MySootheAppPortrait()
    }
}