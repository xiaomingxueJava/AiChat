package com.wsm.aichat;

import com.alibaba.fastjson.JSONObject;
import com.wsm.aichat.assistant.Assistant;
import com.wsm.aichat.assistant.ChatMemoryAssistant;
import com.wsm.aichat.assistant.SeparateChatAssistant;
import com.wsm.aichat.domain.pojo.Demo;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

@SpringBootTest
class AichatApplicationTests {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private ChatMemoryAssistant chatMemoryAssistant;

    @Test
    void contextLoads() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String answer = assistant.chat("你是谁?");
        System.out.println(answer);

    }


    //简单的实现 聊天记忆
    @Test
    void chatMemoryBasic(){
        //第一次会话
        UserMessage userMessage1 = UserMessage.userMessage("我是小明");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage = chatResponse1.aiMessage();
        System.out.println(aiMessage.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("我是谁?");
        // 第二次提问 加上了 第一提问的用户问题 ai回答  再加上第二次的用户提问
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,aiMessage,userMessage2));
        AiMessage aiMessage1 = chatResponse2.aiMessage();
        System.out.println(aiMessage1.text());


    }



    //使用 组件方式实现聊天记忆 单账户
    @Test
    void testChatMemory(){
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        String answer1 = assistant.chat("我叫小明");
        System.out.println(answer1);
        String answer2 = assistant.chat("我叫什么名字");
        System.out.println(answer2);

    }


    /**
     * 使用 @AiServe注解方式 实现 自动注入的ai记忆
     */
    @Test
    void testChatMemory2(){
        String answer = chatMemoryAssistant.chat("我叫李白");
        System.out.println(answer);
        answer=chatMemoryAssistant.chat("我叫什么名字");
        System.out.println(answer);

    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    void testChatMemory3(){
        String answer = separateChatAssistant.chat(1, "我叫小明,你的回答不要超过5个字体");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "你是谁?");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1, "我叫什么名字?");
        System.out.println(answer);
    }

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void testRedis(){
        Demo demo = new Demo();
        demo.setName("张三");
        demo.setGender("男");
        demo.setAge(18);

        redisTemplate.opsForValue().set("1", JSONObject.toJSONString(demo));

        String str = (String)redisTemplate.opsForValue().get("1");
        Demo demo1 = JSONObject.parseObject(str, Demo.class);
        System.out.println(demo1);
    }

}
