package com.wsm.aichat;

import com.wsm.aichat.domain.entity.Game;
import com.wsm.aichat.service.GameService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest


public class DataSourceTest {

    @Autowired
    private GameService gameService;

    @Test
    void testContent(){
        List<Game> list = gameService.list();
        System.out.println(list.get(0));
    }
}
