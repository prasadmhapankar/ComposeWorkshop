package com.example.composedevfest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedevfest.ui.theme.ComposeDevfestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .border(5.dp, Color.Green)
            .padding(all = 10.dp) // all, horizontal, vertical, top, bottom etc.
            .border(5.dp, Color.Blue)
            .padding(all = 10.dp) // Easy as compared to xml
        //.width(600.dp)
        // .requiredWidth(300.dp)
    ) {
        Text(
            text = "Hello Android!",
            modifier = Modifier
                //.clickable {  }
                //.border(5.dp, Color.Blue)
                //.padding(all = 10.dp)
                //.offset(x = 0.dp, y = 20.dp)
                //.border(5.dp, Color.Blue)
                //.padding(all = 10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Jetpack Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDevfestTheme {
        Greeting()
    }
}
