package com.zz.composesample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.zz.composesample.WechatViewModel
import com.zz.composesample.ui.theme.WeComposeTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(viewModel: WechatViewModel) {
    Column() {
        HorizontalPager(count = 4) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(Modifier.fillMaxSize())
                2 -> Box(Modifier.fillMaxSize())
                3 -> Box(Modifier.fillMaxSize())
            }
        }
        WeComposeTheme(WeComposeTheme.Theme.Light) {
            var selectedTab by remember { mutableStateOf(0) }
            WeChatBottomBar(selectedTab) { selectedTab = it }
        }
    }
}