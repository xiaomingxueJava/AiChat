package com.wsm.aichat.controller;

import com.wsm.aichat.assistant.GameAssistant;
import com.wsm.aichat.domain.pojo.ChatForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameAssistant gameAssistant;


    @PostMapping(value = "/chat",produces = {"text/html;charset=utf-8"})
    public Flux<String> chat(@RequestBody ChatForm chatForm){
        return gameAssistant.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }


}
