package com.zz.composesample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rengwuxian.wecompose.data.Chat
import com.rengwuxian.wecompose.data.Msg
import com.rengwuxian.wecompose.data.User
import com.zz.composesample.ui.theme.WeComposeTheme

class WechatViewModel: ViewModel() {
  var chats by mutableStateOf(
    listOf( // List<Chat>
      Chat(
        friend = User("gaolaoshi", "iKun坤", R.drawable.avatar_cai),
        mutableStateListOf(
          Msg(User("gaolaoshi", "iKun坤", R.drawable.avatar_cai), "锄禾日当午", "14:20"),
          Msg(User.Me, "汗滴禾下土", "14:20"),
          Msg(User("gaolaoshi", "iKun坤", R.drawable.avatar_cai), "谁知盘中餐", "14:20"),
          Msg(User.Me, "粒粒皆辛苦", "14:20"),
          Msg(User("gaolaoshi", "iKun坤", R.drawable.avatar_cai), "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。", "14:20"),
          Msg(User.Me, "双兔傍地走，安能辨我是雄雌？", "14:20"),
          Msg(User("gaolaoshi", "iKun坤", R.drawable.avatar_cai), "床前明月光，疑是地上霜。", "14:20"),
          Msg(User.Me, "吃饭吧？", "14:20"),
        )
      ),
      Chat(
        friend = User("diuwuxian", "小楷", R.drawable.avatar_kai),
        mutableStateListOf(
          Msg(User("diuwuxian", "小楷", R.drawable.avatar_kai), "哈哈哈", "13:48"),
          Msg(User.Me, "哈哈昂", "13:48"),
          Msg(User("diuwuxian", "小楷", R.drawable.avatar_kai), "你笑个屁呀", "13:48").apply { read = false },
        )
      ),
    )
  )
  val contacts by mutableStateOf(
    listOf(
      User("gaolaoshi", "iKun坤", R.drawable.avatar_cai),
      User("diuwuxian", "小楷", R.drawable.avatar_kai)
    )
  )
  var theme by mutableStateOf(WeComposeTheme.Theme.Light)
  var currentChat: Chat? by mutableStateOf(null)
  var chatting by mutableStateOf(false)

  fun startChat(chat: Chat) {
    chatting = true
    currentChat = chat
  }

  fun endChat(): Boolean {
    if (chatting) {
      chatting = false
      return true
    }
    return false
  }

  fun boom(chat: Chat) {
    chat.msgs.add(Msg(User.Me, "\uD83D\uDCA3", "15:10").apply { read = true })
  }
}