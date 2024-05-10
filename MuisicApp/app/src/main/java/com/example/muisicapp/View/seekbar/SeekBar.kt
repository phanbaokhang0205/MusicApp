

package com.example.muisicapp.View.seekbar

import android.media.AudioManager
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.exoplayer.ExoPlayer
import com.example.muisicapp.ui.theme.Gray1
import com.example.muisicapp.ui.theme.Green1


/**
 * Seek bar
 */

@Composable
fun TestSeekbar() {

    val ctx = LocalContext.current
    val mediaPlayer = MediaPlayer()


    // on below line we are creating a column for our ui.
    Column(
        // in this column we are adding a modifier
        // for our column and specifying max width, height and size.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()

            // on below line we are adding padding
            // from all sides to our column.
            .padding(6.dp),

        // on below line we are adding vertical arrangement
        // for our column as bottom
        verticalArrangement = Arrangement.Center,

        // on below line we are adding horizontal alignment
        // for our column.
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are
        // displaying a simple text
        Text(

            // on below line we are specifying
            // modifier as padding for our text.
            modifier = Modifier.padding(6.dp),

            // on below line we are specifying
            // text as normal image.
            text = "Play Audio from URL",

            // on below line we are specifying
            // font weight as bold.
            fontWeight = FontWeight.Bold,

            // on below line we are
            // setting color for our text
            color = Color.Green,

            // on below line we are
            // setting font size.
            fontSize = 20.sp
        )

        // on below line we are creating a simple spacer
        // with height 20
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a
        // button for displaying error toast
        Button(
            // on below line we are adding
            // width for our button and padding to it.
            modifier = Modifier
                .width(300.dp)
                .padding(7.dp),

            // in this button we are
            // adding on click for it on below line.
            onClick = {

                // on below line we are creating a variable for our audio url
                val audioUrl = "https://breakingnews2222.000webhostapp.com/File%20MP3/Ch%C3%BAng%20Ta%20C%E1%BB%A7a%20Hi%E1%BB%87n%20T%E1%BA%A1i.mp4"

                // on below line we are setting audio stream type as
                // stream music on below line.
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

                // on below line we are running a try and catch block
                // for our media player.
                try {
                    // on below line we are setting audio source
                    // as audio url on below line.
                    mediaPlayer.setDataSource(audioUrl)

                    // on below line we are preparing
                    // our media player.
                    mediaPlayer.prepare()

                    // on below line we are starting
                    // our media player.
                    mediaPlayer.start()

                } catch (e: Exception) {

                    // on below line we are
                    // handling our exception.
                    e.printStackTrace()
                }

                // on below line we are displaying a toast message as audio player.
                Toast.makeText(ctx, "Audio started playing..", Toast.LENGTH_SHORT).show()

            }) {
            // on below line we are specifying
            // text for button.
            Text(text = "Play Audio")
        }

        // on below line we are creating a spacer of height 20
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are
        // creating a button for displaying a toast
        Button(
            // on below line we are
            // adding width for our button and padding to it.
            modifier = Modifier
                .width(300.dp)
                .padding(7.dp),

            // in this button we are adding
            // on click for it on below line.
            onClick = {
                // on below line we are checking
                // if media player is playing.
                if (mediaPlayer.isPlaying) {
                    // if media player is playing
                    // we are stopping it on below line.
                    mediaPlayer.stop()

                    // on below line we are resetting
                    // our media player.
                    mediaPlayer.reset()

                    // on below line we are calling release
                    // to release our media player.
                    mediaPlayer.release()

                    // on below line we are displaying a toast message to pause audio
                    Toast.makeText(ctx, "Audio has been  paused..", Toast.LENGTH_SHORT).show()
                } else {
                    // if audio player is not displaying we are displaying
                    // below toast message
                    Toast.makeText(ctx, "Audio not played..", Toast.LENGTH_SHORT).show()
                }


            }) {
            // on below line we are specifying text for button.
            Text(text = "Pause Audio")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SeekBarPreview() {
    TestSeekbar()
}

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
    onValueChangeFinished:() -> Unit
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
//                            onProgressChange(it)
//                            val seekPosition = (it * mediaPlayer.duration).toLong()
//                            mediaPlayer.seekTo(seekPosition)
                                        },
                        onValueChangeFinished = {
                                                onValueChangeFinished()
//                                                mediaPlayer.play()
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
                        text = "-" + (duration - progress).toString(),
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
