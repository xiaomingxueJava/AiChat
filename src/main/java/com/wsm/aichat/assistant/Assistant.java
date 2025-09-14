package com.wsm.aichat.assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;


public interface Assistant {

    @SystemMessage("You are a good friend of mine. Answer using slang.")
    String chat(String userMessage);
}
