package com.example.basic_jetpack_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.basic_jetpack_compose_app.ui.theme.BasicjetpackcomposeappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicjetpackcomposeappTheme {
                ClickCounter(
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}
