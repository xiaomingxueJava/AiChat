package com.wsm.aichat;

import com.wsm.aichat.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    void testCalculatorTools(){
        String answer = separateChatAssistant.chat(2, "1+2等于几  9的平方根等于几");
        System.out.println(answer);
    }
}
