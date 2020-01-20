package com.strategythree;

import com.strategythree.dto.MessageInfo;

public interface MessageService {

    void handleMessage(MessageInfo messageInfo);
}