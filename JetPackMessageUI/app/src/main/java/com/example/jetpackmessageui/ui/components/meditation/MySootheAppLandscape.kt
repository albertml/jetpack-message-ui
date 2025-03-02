package com.example.jetpackmessageui.ui.components.meditation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

@Composable
fun MySootheAppLandscape() {
    JetPackMessageUITheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun MySootheAppPortraitPreview() {
    JetPackMessageUITheme {
        MySootheAppLandscape()
    }
}