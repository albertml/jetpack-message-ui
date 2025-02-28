package com.example.jetpackmessageui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.ui.Modifier
import com.example.jetpackmessageui.ui.survey.WelcomeApp
import com.example.jetpackmessageui.ui.theme.JetPackMessageUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackMessageUITheme {
               Surface(modifier = Modifier.fillMaxSize()) {
                  WelcomeApp()
               }
            }

//            val windoSizeClass = calculateWindowSizeClass(this)
//            MySootheApp(windoSizeClass)
        }
    }
}


