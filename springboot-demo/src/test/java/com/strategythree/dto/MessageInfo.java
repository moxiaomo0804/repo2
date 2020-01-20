package com.strategythree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageInfo {

    // 消息类型
    private Integer type;
    // 消息内容
    private String content;

}