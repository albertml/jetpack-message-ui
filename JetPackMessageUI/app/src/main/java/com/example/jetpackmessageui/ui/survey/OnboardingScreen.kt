package com.example.jetpackmessageui.ui.survey

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onOnboardingClicked: (Boolean) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to basic Codelab",
            modifier = modifier.padding(vertical = 12.dp))
        ElevatedButton(
            onClick = { onOnboardingClicked(true) },
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text("Continue")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Onboarding Dark"
)
@Composable
private fun OnboardingScreenPreview() {
    JetPackMessageUITheme(darkTheme = false) {
        OnboardingScreen()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
private fun OnboardingScreePreview() {
    JetPackMessageUITheme(darkTheme = true) {
        OnboardingScreen()
    }
}