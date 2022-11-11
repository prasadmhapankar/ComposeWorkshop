package com.example.composedevfest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedevfest.ui.theme.ComposeDevfestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val verticalScrollState = rememberScrollState()
            LazyColumn(
                modifier = Modifier.background(Color.LightGray)
            ) {
                /*item {
                    Text(
                        text = "This is an Item",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(24.dp)
                    )
                }
                itemsIndexed(
                    mutableListOf(
                        "I",
                        "like",
                        "compose",
                        "I",
                        "like",
                        "compose",
                        "I",
                        "like",
                        "compose",
                        "I",
                        "like",
                        "compose"
                    )
                ) { index, value ->
                    Text(
                        text = value,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }*/
                items(
                    count = 1000,
                ) {
                    ListItem(
                        painter = painterResource(id = R.drawable.cheese_burger),
                        contentDescription = stringResource(id = R.string.content_description),
                        title = "Cheese burger #$it",
                        description = "Main ingredients: Patty, Cheese, Bun",
                        //modifier = Modifier.padding(5.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun ListItem(
    painter: Painter,
    contentDescription: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    var count by remember {
        mutableStateOf(0)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(size = 15.dp),
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .height(150.dp)
                .background(Color.White)
                .padding(all = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ItemContent(title, description)
                ItemCount(count) {
                    count = it
                }
            }
        }
    }
}

@Composable
fun ItemCount(
    count: Int,
    updateCount: (Int) -> Unit,
) {
    Row {
        CounterButton(
            text = "-",
            count = count,
            updateCount = {
                if (count > 0) updateCount(it - 1)
            },
        )
        Text(
            text = count.toString(),
            modifier = Modifier
                .padding(12.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
        CounterButton(
            text = "+",
            count = count,
            updateCount = {
                updateCount(it + 1)
            },
        )
    }
}

@Composable
fun CounterButton(
    text: String,
    count: Int,
    updateCount: (Int) -> Unit,
) {
    OutlinedButton(
        onClick = {
            updateCount(count)
        }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(3.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Composable
fun ItemContent(title: String, description: String) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
        )
        Text(
            text = description,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 14.sp
            ),
        )
    }
}

@Preview(fontScale = 1.5f)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDevfestTheme {
        ListItem(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.content_description),
            title = "Alfred",
            description = "Android Developer",
        )
    }
}