package com.example.composedevfest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedevfest.ui.theme.ComposeDevfestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android", "Jetpack Compose")
        }
    }
}

@Composable
fun Greeting(text1: String, text2: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "Hello $text1!")
        Text(text = "Hello world!")
        Text(text = "Hello $text2!")
    }

    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(text = "Hello $text1!")
        Text(text = "Hello world!")
        Text(text = "Hello $text2!")
    }*/
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDevfestTheme {
        Greeting("Android", "Jetpack Compose")
    }
}
