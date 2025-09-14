package com.wsm.aichat.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.model.output.structured.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

/**
 * (Game)表实体类.
 *
 * @author makejava
 * @since 2025-05-24 14:14:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("game")
public class Game implements Serializable {

    private static final long serialVersionUID = 410887712210552732L;
    
    /**
     * id.
     */
    @TableId(type = IdType.AUTO)
    @Description("忽略此字段,该字段由数据库自动生成")
    private Integer id;
    /**
     * 用户标识.
     */
    private Integer userId;
    /**
     * 理由.
     */
    private String reason;
    /**
     * 得分.
     */
    private Integer score;



}


