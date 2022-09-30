package com.zz.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.zz.composesample.ui.ChatList
import com.zz.composesample.ui.Home
import com.zz.composesample.ui.WeChatBottomBar
import com.zz.composesample.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WechatViewModel = viewModel()
            WeComposeTheme(viewModel.theme) {
                Box() {
                    Home(viewModel)
                }
            }
        }
    }
}
