package com.wsm.aichat.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatForm {
    private String memoryId;  //对话id
    private String message; //对话内容



}
