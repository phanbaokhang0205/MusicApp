package com.example.muisicapp.View.seekbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.ui.theme.Gray1
import com.example.muisicapp.ui.theme.Green1


/**
 * Seek bar
 */

@Composable
fun SeekBar(
    progress: Float,
    isPlaying: Boolean,
    isFavourite: Boolean,
    songName: String,
    singerName: String,
    duration: Long,
    favouriteEvent: () -> Unit,
    playingEvent: () -> Unit,
    onProgressChange: (Float) -> Unit,
    onValueChangeFinished: () -> Unit,
    onLoading: Boolean,
) {
    Box(modifier = Modifier.background(Color(0x66000000))) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .height(170.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            /**
             * Content song
             */
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    /** Song name */
                    Text(
                        text = songName,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    /** Artist */
                    Text(
                        text = singerName,
                        fontSize = 12.sp,
                        color = Gray1,
                        fontWeight = FontWeight.Bold
                    )

                }

                IconButton(
                    onClick = {
                        favouriteEvent()
                    },
                ) {
                    Icon(
                        imageVector = if (isFavourite) Icons.Filled.Favorite
                        else Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavourite) Green1
                        else Color.White,
                    )
                }
            }

            /**
             * Seek bar
             */
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.height(20.dp)) {
                    Slider(
                        value = progress,
                        onValueChange = {
                            onProgressChange(it)
                        },
                        onValueChangeFinished = {
                            onValueChangeFinished()
                        },
                        valueRange = 0f..duration.toFloat(),
                        modifier = Modifier.fillMaxWidth(),
                        colors = SliderDefaults.colors(
                            thumbColor = Green1,
                            activeTrackColor = Green1,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = progress.toString(),
                        fontSize = 10.sp,
                        color = Gray1
                    )
                    Text(
                        text = "-" + (duration - progress.toLong()).toString(),
                        fontSize = 10.sp,
                        color = Gray1
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                /**
                 * Shuffle
                 */
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Shuffle,
                        contentDescription = "Shuffle",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }

                /**
                Previous
                 */
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.SkipPrevious,
                        contentDescription = "Skip Previous",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }

                /**
                 * Play / Pause
                 */
                IconButton(
                    onClick = {
                        playingEvent()

                    },
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Green1)
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = if (isPlaying) "Play" else "Pause",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }

                /**
                 * Next
                 */
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.SkipNext, contentDescription = "Skip Next",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }

                /**
                 * Repeat
                 */
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Repeat, contentDescription = "Repeat",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    }
}


//@Composable
//fun TestSeekbar() {
//
//    var isFavourite by rememberSaveable {
//        mutableStateOf(false)
//    }
//
//    var isPlaying by rememberSaveable {
//        mutableStateOf(false)
//    }
//
//    val progress by rememberSaveable {
//        mutableStateOf(0F)
//    }
//
//    Column(
//        modifier = Modifier
//            .background(Color(0x66000000))
//            .fillMaxSize()
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.loading_image),
//                contentDescription = null,
//                modifier = Modifier.size(200.dp),
//                tint = Color.Black
//            )
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(12.dp)
//                    .height(170.dp)
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.SpaceBetween,
//            ) {
//
//
//                /**
//                 * Content song
//                 */
//                /**
//                 * Content song
//                 */
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column {
//                        /** Song name */
//                        /** Song name */
//                        Text(
//                            text = "songName",
//                            fontSize = 14.sp,
//                            color = Color.White,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                        /** Artist */
//
//                        /** Artist */
//                        Text(
//                            text = "singerName",
//                            fontSize = 12.sp,
//                            color = Gray1,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                    }
//
//                    IconButton(
//                        onClick = {
//                        },
//                    ) {
//                        Icon(
//                            imageVector = if (isFavourite) Icons.Filled.Favorite
//                            else Icons.Filled.FavoriteBorder,
//                            contentDescription = null,
//                            tint = if (isFavourite) Green1
//                            else Color.White,
//                        )
//                    }
//                }
//
//                /**
//                 * Seek bar
//                 */
//
//                /**
//                 * Seek bar
//                 */
//                Column(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Box(modifier = Modifier.height(20.dp)) {
//                        Slider(
//                            value = progress,
//                            onValueChange = {
//                                //                            onProgressChange(it)
//                                //                            val seekPosition = (it * mediaPlayer.duration).toLong()
//                                //                            mediaPlayer.seekTo(seekPosition)
//                            },
//                            onValueChangeFinished = {
//                                //                                                mediaPlayer.play()
//                            },
//                            valueRange = 0f..100f,
//                            modifier = Modifier.fillMaxWidth(),
//                            colors = SliderDefaults.colors(
//                                thumbColor = Green1,
//                                activeTrackColor = Green1,
//                                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
//                            ),
//                        )
//                    }
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "",
//                            fontSize = 10.sp,
//                            color = Gray1
//                        )
//                        Text(
//                            text = "-",
//                            fontSize = 10.sp,
//                            color = Gray1
//                        )
//                    }
//                }
//
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//
//                    /**
//                     * Shuffle
//                     */
//                    /**
//                     * Shuffle
//                     */
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            imageVector = Icons.Filled.Shuffle,
//                            contentDescription = "Shuffle",
//                            tint = Color.Black,
//                            modifier = Modifier.size(25.dp)
//                        )
//                    }
//
//                    /**
//                    Previous
//                     */
//
//                    /**
//                    Previous
//                     */
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            imageVector = Icons.Filled.SkipPrevious,
//                            contentDescription = "Skip Previous",
//                            tint = Color.Black,
//                            modifier = Modifier.size(25.dp)
//                        )
//                    }
//
//                    /**
//                     * Play / Pause
//                     */
//
//                    /**
//                     * Play / Pause
//                     */
//                    IconButton(
//                        onClick = {
//
//                        },
//                        modifier = Modifier
//                            .size(50.dp)
//                            .clip(RoundedCornerShape(100))
//                            .background(Green1)
//                    ) {
//                        Icon(
//                            imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
//                            contentDescription = if (isPlaying) "Play" else "Pause",
//                            tint = Color.Black,
//                            modifier = Modifier.size(25.dp)
//                        )
//                    }
//
//                    /**
//                     * Next
//                     */
//
//                    /**
//                     * Next
//                     */
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            imageVector = Icons.Filled.SkipNext, contentDescription = "Skip Next",
//                            tint = Color.Black,
//                            modifier = Modifier.size(25.dp)
//                        )
//                    }
//
//                    /**
//                     * Repeat
//                     */
//
//                    /**
//                     * Repeat
//                     */
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            imageVector = Icons.Filled.Repeat, contentDescription = "Repeat",
//                            tint = Color.Black,
//                            modifier = Modifier.size(25.dp)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun SeekBarPreview() {
//    TestSeekbar()
//}

