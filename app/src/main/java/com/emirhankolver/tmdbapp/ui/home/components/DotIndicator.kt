package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DotIndicator(
    listState: LazyListState,
    dotSize: Int = 8,
    spacing: Int = 4,
    selectedColor: Color = Color.White,
    unselectedColor: Color = Color.White.copy(alpha = 0.6f)
) {
    // Observe the currently visible item index
    val selectedIndex by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex
        }
    }
    val totalItemCount by remember {
        derivedStateOf {
            listState.layoutInfo.totalItemsCount
        }
    }

    Row(
        modifier = Modifier.wrapContentWidth().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(spacing.dp)
    ) {
        for (index in 0 until totalItemCount) {
            Box(
                modifier = Modifier
                    .size(dotSize.dp)
                    .background(
                        color = if (index == selectedIndex) selectedColor else unselectedColor,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
        }
    }
}