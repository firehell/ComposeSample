package com.zz.composesample.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zz.composesample.R
import com.zz.composesample.ui.theme.WeComposeTheme


@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        WeChatBottomBar() {
        }
    }
}

@Composable
fun WeChatBottomBar(onStateChange: (Int) -> Unit) {
    Row() {
        TabItem(
            R.drawable.ic_chat_outlined, "聊天",
            Modifier
                .weight(1.0f)
                .clickable {
                    onStateChange(0)
                }
        )
        TabItem(
            R.drawable.ic_contacts_outlined, "通讯录",
            Modifier
                .weight(1.0f)
                .clickable {
                    onStateChange(1)
                }
        )
        TabItem(
            R.drawable.ic_discovery_outlined, "发现",
            Modifier
                .weight(1.0f)
                .clickable {
                    onStateChange(2)
                }
        )
        TabItem(
            R.drawable.ic_me_outlined, "我",
            Modifier
                .weight(1.0f)
                .clickable {
                    onStateChange(3)
                }
        )
    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(id = iconId), contentDescription = title,
            Modifier.size(24.dp)
        )
        Text(text = title)
    }
}