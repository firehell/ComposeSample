package com.zz.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.zz.composesample.ui.ChatList
import com.zz.composesample.ui.WeChatBottomBar
import com.zz.composesample.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                val viewModel:WechatViewModel = viewModel()
                HorizontalPager(count = 4) { page ->
                    when (page) {
                        0-> ChatList(viewModel.chats)
                        1-> Box(Modifier.fillMaxSize())
                        2-> Box(Modifier.fillMaxSize())
                        3-> Box(Modifier.fillMaxSize())
                    }
                }
                WeComposeTheme(WeComposeTheme.Theme.Light) {
                    var selectedTab by remember { mutableStateOf(0) }
                    WeChatBottomBar(selectedTab) { selectedTab = it }
                }
            }
        }
    }
}
