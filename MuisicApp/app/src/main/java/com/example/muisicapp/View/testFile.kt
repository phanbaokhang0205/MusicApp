package com.example.muisicapp.View

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestFile() {

    // Khai báo một giá trị tiến trình
    val progress = remember { mutableStateOf(0.5f) }

    // Hiển thị ProgressBar với giá trị tiến trình
    LinearProgressIndicator(
        progress = progress.value,
        modifier = Modifier.fillMaxWidth(), // Tùy chỉnh kích thước
        color = Color.Blue, // Tùy chỉnh màu sắc
        trackColor = Color.Gray, // Tùy chỉnh màu nền
        strokeCap = StrokeCap.Round, // Tùy chỉnh strokeCap

    )

//    Log.i("ABC", name)
}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    TestFile()
}


