package com.example.basic_jetpack_compose_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basic_jetpack_compose_app.ui.theme.BasicjetpackcomposeappTheme


@Composable
fun ClickCounter(modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "You have clicked $count times!",
            fontSize = 20.sp,
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
        )

        Button(
            onClick = {
                count++
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(1f)
        ) {
            Text(
                text = "Click me",
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClickCounterPreview() {
    BasicjetpackcomposeappTheme {
        ClickCounter()
    }
}
