package com.cofbro.qian.friend.chat.viewholder

import cn.leancloud.im.v2.LCIMMessage
import com.cofbro.qian.databinding.ItemChatNormalFriendBinding
import com.cofbro.qian.friend.viewholder.DefaultViewHolder
import com.cofbro.qian.utils.getStringExt
import com.cofbro.qian.utils.safeParseToJson

class NormalUserSendViewHolder(private val binding: ItemChatNormalFriendBinding,private val avatar: String) : DefaultViewHolder<LCIMMessage>(binding) {
    override fun bind(position: Int, t: LCIMMessage?) {
        // 消息
        binding.tvMessage.text = t?.content?.safeParseToJson()?.getStringExt("_lctext") ?: ""
        // 时间
        binding.tvTime.text = formatTimestamp(t?.timestamp ?: 0L)
        // 头像
        setImage(binding.avatar, avatar)
    }
}