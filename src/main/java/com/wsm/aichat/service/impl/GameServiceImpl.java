package com.wsm.aichat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsm.aichat.dao.GameDao;
import com.wsm.aichat.domain.entity.Game;
import com.wsm.aichat.service.GameService;
import org.springframework.stereotype.Service;

/**
 * (Game)表服务实现类
 *
 * @author makejava
 * @since 2025-05-24 14:15:00
 */
@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, Game> implements GameService {

}

