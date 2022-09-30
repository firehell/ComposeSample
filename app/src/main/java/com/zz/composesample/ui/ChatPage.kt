package com.zz.composesample.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zz.composesample.WechatViewModel
import kotlin.math.roundToInt

/**
 * 聊天详情页面
 */
@Composable
fun ChatPage() {
    val viewModel: WechatViewModel = viewModel()
    val offsetPercentX by animateFloatAsState(if (viewModel.chatting) 0f else 1f)
    val offsetPercentY by animateFloatAsState(if (viewModel.chatting) 0f else 1f)

    Box(
        Modifier
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    val offsetX = (offsetPercentX * placeable.width).roundToInt()
                    val offsetY = (offsetPercentY * placeable.height).roundToInt()
                    placeable.placeRelative(offsetX, offsetY)
                }
            }
            .background(Color.Magenta)
            .fillMaxSize()
    )
}