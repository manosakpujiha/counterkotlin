package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Yellow)) {
        val counter = remember { mutableIntStateOf(0) }
        Row (modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(
                text = "$name!",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Red)

            )
        }
        Row {
            Text(
                text = "Counter: ${counter.intValue} ",
                color = Color.Green,
                modifier = modifier
            )
        }
        Row {
            Button(onClick = { counter.intValue++ }) {

                Text(
                    text = "+",
                    modifier = modifier

                )
            }
            Button(onClick = { counter.intValue-- }) {
                Text(
                    text = "-",
                    modifier = modifier
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        Greeting("Desktop Preview")
    }
}