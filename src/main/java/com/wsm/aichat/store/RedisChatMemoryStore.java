package com.wsm.aichat.store;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class RedisChatMemoryStore implements ChatMemoryStore {

    private static final String key="conversation_history:";
    private static final String model="qwen:";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String value = redisTemplate.opsForValue().get("chat:" + memoryId.toString());
        if(value == null || value.isEmpty()){
            return List.of();
        }
        return ChatMessageDeserializer.messagesFromJson(value);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        String messages = ChatMessageSerializer.messagesToJson(list);
//        System.out.println(messages);
        redisTemplate.opsForValue().set("chat:" + memoryId.toString(), messages);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete("chat:" + memoryId.toString());
    }



   /* @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String string = redisTemplate.opsForList().index(key + model + memoryId, -1);
        *//*if(Objects.isNull(allElements)|| allElements.isEmpty()){
            return new LinkedList<>();
        }*//*

        return ChatMessageDeserializer.messagesFromJson(string);

    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        redisTemplate.opsForList().rightPush(key+model+memoryId, ChatMessageSerializer.messagesToJson(list));
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete(key+model+memoryId);
    }*/
}
