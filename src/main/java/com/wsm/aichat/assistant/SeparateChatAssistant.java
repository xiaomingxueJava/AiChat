package com.wsm.aichat.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 隔离聊天记忆
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",       //自定义存储
        tools = "calculatorTools"   //配置工具
)
public interface SeparateChatAssistant {

    String chat(@MemoryId int id, @UserMessage String message);
}
