package com.example.muisicapp.View.seekbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.ui.theme.Green1
import com.example.muisicapp.ui.theme.MuisicAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.min

@Composable
fun CircleSeekBar(
    duration: Float
) {
    var angle by remember { mutableStateOf(0f) }
    var isPlaying by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.size(34.dp), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val circleRadius = min(canvasWidth, canvasHeight) / 2
            val strokeWidth = 2.dp.toPx()
            val startAngle = -90f
            drawArc(
                color = Color.Gray,
                startAngle = startAngle,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth),
                topLeft = Offset(
                    x = (canvasWidth / 2) - circleRadius + strokeWidth / 2,
                    y = (canvasHeight / 2) - circleRadius + strokeWidth / 2
                ),
                size = Size(
                    width = circleRadius * 2 - strokeWidth,
                    height = circleRadius * 2 - strokeWidth
                )
            )
            drawArc(
                color = Green1,
                startAngle = startAngle,
                sweepAngle = angle,
                useCenter = false,
                style = Stroke(strokeWidth),
                topLeft = Offset(
                    x = (canvasWidth / 2) - circleRadius + strokeWidth / 2,
                    y = (canvasHeight / 2) - circleRadius + strokeWidth / 2
                ),
                size = Size(
                    width = circleRadius * 2 - strokeWidth,
                    height = circleRadius * 2 - strokeWidth
                )
            )
        }

        IconButton(onClick = {
            isPlaying = !isPlaying
            coroutineScope.launch {
                while (isPlaying && angle < 360f) {
                    delay(1000)
                    angle += 360 / duration
                    /** duration là thời lượng bài hát*/
                }
            }
        }) {
            Icon(
                imageVector = if (isPlaying) Icons.Filled.PlayArrow else Icons.Filled.Pause,
                contentDescription = if (isPlaying) "Play" else "Pause",
                tint = Color.White,
                modifier = Modifier.size(17.dp),
                
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CircleSeekBarPreview() {
    MuisicAppTheme {
        CircleSeekBar(9f)
    }
}