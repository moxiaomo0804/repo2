package com.strategythree.impl;

import com.strategythree.MSG_TYPE;
import com.strategythree.MessageService;
import com.strategythree.MsgTypeHandler;
import com.strategythree.dto.MessageInfo;
import org.springframework.stereotype.Service;

@Service
@MsgTypeHandler(value = MSG_TYPE.TEXT)
public class TextMessageService implements MessageService {

    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("处理文本消息 " + messageInfo.getContent());
    }
}