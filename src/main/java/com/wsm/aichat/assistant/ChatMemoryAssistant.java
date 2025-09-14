package com.wsm.aichat.assistant;


import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"       //使用内存存储 记忆
)
public interface ChatMemoryAssistant {

    String chat(String message);
}
