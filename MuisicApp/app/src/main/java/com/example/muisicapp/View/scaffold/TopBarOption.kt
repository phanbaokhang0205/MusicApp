package com.example.muisicapp.View.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBarOption(
    goBackEvent:() -> Unit,
    goShareEvent:() -> Unit,
    goOptionEvent:() -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = { goBackEvent() },
            modifier = Modifier.padding(start = 10.dp)

        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null )
        }
        Row(Modifier.padding(end = 15.dp)) {
            IconButton(onClick = { goShareEvent() }) {
                Icon(imageVector = Icons.Default.Share, contentDescription =null, modifier = Modifier.padding() )
            }
            IconButton(onClick = { goOptionEvent() }) {
                Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription =null )
            }
        }
    }
}