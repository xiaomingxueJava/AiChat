package com.wsm.aichat.config;

import com.wsm.aichat.store.RedisChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class GameAgentConfig {

    @Autowired
    private RedisChatMemoryStore redisChatMemoryStore;


    @Bean
    public ChatMemoryProvider gameChatMemoryProvider(){
        return memoryId->
            MessageWindowChatMemory
                    .builder()
                    .id(memoryId)
                    .maxMessages(30)
                    .chatMemoryStore(redisChatMemoryStore)
                    .build();

    }
}
