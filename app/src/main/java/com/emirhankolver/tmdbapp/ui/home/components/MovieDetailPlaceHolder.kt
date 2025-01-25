package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer


@Composable
fun MovieDetailPlaceHolder() {
    val color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .shimmer()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color)
            )
            Column(Modifier.padding(24.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .clip(RoundedCornerShape(16))
                        .background(color)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(16))
                        .background(color)
                )
            }
        }
    }
}