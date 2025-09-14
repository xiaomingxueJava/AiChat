package com.wsm.aichat.tools;

import com.wsm.aichat.domain.entity.Game;
import com.wsm.aichat.service.GameService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class GameTools {

   /* @Autowired
    private GameService gameService;

    @Tool(name = "保存用户游戏信息",value = "根据参数保存用户初始化游戏信息,保存用户的userId和reason")
    public void saveUserGameInfo(Game game){
        System.out.println(game);
        gameService.save(game);
    }*/
}
